package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.jl.project.entity.dto.UpdateExamRecordDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.CorrectUserExamUserVO;
import com.jl.project.entity.vo.ExamRecordVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.observer.correctObserver.ReviewSubject;
import com.jl.project.service.ExamRecordService;
import com.jl.project.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * @Description:考试记录表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("examRecordService")
public class ExamRecordServiceImpl implements ExamRecordService {

    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private ReviewSubject reviewSubject;

    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;


    @Resource
    private PaperMapper<Paper, PaperQuery> paperMapper;

    /**
     * 根据条件查询列表
     */
    public List<ExamRecord> findListByParam(ExamRecordQuery query) {
        return this.examRecordMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(ExamRecordQuery query) {
        return this.examRecordMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<ExamRecord> findListByPage(ExamRecordQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<ExamRecord> list = this.findListByParam(query);
        PaginationResultVO<ExamRecord> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    public Integer add(ExamRecord bean) {
        return this.examRecordMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<ExamRecord> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.examRecordMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<ExamRecord> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.examRecordMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public ExamRecord getExamRecordById(String id) {
        return this.examRecordMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Boolean updateExamRecordById(UpdateExamRecordDTO updateExamRecordDTO) throws BusinessException {
        // 由于系统设计原因，提交阅卷使用的是这个接口
        // 所以手动阅卷的时候，需要在这里更新错题本数据
        String id = updateExamRecordDTO.getId();
        ExamRecord examRecord = updateExamRecordDTO.getExamRecord();
        Integer handState = examRecord.getHandState();

        // 首先拿到原来的记录数据
        ExamRecord oldRecord = examRecordMapper.selectById(id);
        if (oldRecord == null) {
            throw new BusinessException("考试记录不存在");
        }

        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
        // 如果批阅状态是未处理，并且此次提交的数据是批阅状态更改的请求
        if (oldRecord.getHandState() == 0 && handState == 1) {
            // 获取关联的所有答题记录
            userAnswerQuery.setUserId(oldRecord.getUserId());
            userAnswerQuery.setExamRecordId(oldRecord.getId());
            List<UserAnswer> list = userAnswerMapper.selectList(userAnswerQuery);
            if (list != null && list.size() != 0) {
                List<UserAnswer> wrongList = new ArrayList<>();
                for (UserAnswer userAnswer : list) {
                    Integer isRight = userAnswer.getIsRight();
                    if (isRight == 0){ // 只搜集错的
                        wrongList.add(userAnswer);
                    }
                }
                // 搜集错题
                reviewSubject.notifyBookUpdate(wrongList);
            }


        }


        if (handState == 1) {
            examRecord.setReviewTime(new Date());
        }
        Integer result = examRecordMapper.updateById(examRecord, id);

        return result > 0;
    }

    /**
     * 根据Id删除
     */
    public Integer deleteExamRecordById(String id) {
        return this.examRecordMapper.deleteById(id);
    }

    /**
     * 根据考试Id获取考试记录
     *
     * @param examRecordQuery
     * @return
     */
    @Override
    public PaginationResultVO<CorrectUserExamUserVO> getExamRecordByExamId(ExamRecordQuery examRecordQuery) throws BusinessException {
        if (examRecordQuery == null) {
            throw new BusinessException("缺少参数");
        }

        String examId = examRecordQuery.getExamId();
        if (examId == null || "".equals(examId)) {
            throw new BusinessException("缺少参数");
        }


        PaginationResultVO<CorrectUserExamUserVO> resultVO = new PaginationResultVO<>();
        // 1. 获取考试对应的考试记录

        PaginationResultVO<ExamRecord> paginationResultVO = findListByPage(examRecordQuery);
        BeanUtil.copyProperties(paginationResultVO, resultVO);
        List<ExamRecord> examRecords = paginationResultVO.getList();
        if (examRecords == null) {
            resultVO.setList(Collections.emptyList());
            return resultVO;
        }


        List<CorrectUserExamUserVO> correctUserExamUserVOS = new ArrayList<>();
        // 2. 封装视图对象
        for (ExamRecord examRecord : examRecords) {
            CorrectUserExamUserVO examUserVO = new CorrectUserExamUserVO();
            String userId = examRecord.getUserId();
            // 获取用户信息
            User user = userMapper.selectById(userId);
            if (user != null) {
                examUserVO.setUserName(user.getUserName());
            }

            // 获取试卷信息
            Exam exam = examMapper.selectById(examId);
            String paperId = exam.getPaperId();
            Paper paper = paperMapper.selectById(paperId);

            examUserVO.setPaper(paper);
            examUserVO.setExamRecord(examRecord);
            correctUserExamUserVOS.add(examUserVO);
        }

        resultVO.setList(correctUserExamUserVOS);
        return resultVO;
    }

    @Override
    public PaginationResultVO<ExamRecordVO> loadDatalist(ExamRecordQuery query) throws BusinessException {
        PaginationResultVO<ExamRecord> paginationResultVO = findListByPage(query);
        PaginationResultVO<ExamRecordVO> resultVO = new PaginationResultVO<>();
        BeanUtil.copyProperties(paginationResultVO, resultVO);
        if (paginationResultVO == null) {
            return resultVO;
        }
        List<ExamRecord> examRecords = paginationResultVO.getList();
        List<ExamRecordVO> list = new ArrayList<>();
        if (examRecords != null && examRecords.size() != 0) {
            for (ExamRecord examRecord : examRecords) {
                ExamRecordVO examRecordVO = new ExamRecordVO();
                BeanUtil.copyProperties(examRecord, examRecordVO);
                String userId = examRecord.getUserId();
                User user = userMapper.selectById(userId);
                // 赋值作答者姓名
                if (user != null) {
                    examRecordVO.setUserName(user.getUserName());
                }

                if (examRecord.getState() == 2) {// 已作答才有时长
                    long between = DateUtil.between(examRecord.getEndTime(), examRecord.getStartTime(), DateUnit.MINUTE);
                    examRecordVO.setAnswerTime(between);
                }
                list.add(examRecordVO);
            }
        }
        resultVO.setList(list);
        return resultVO;
    }


    /**
     * 根据用户答案更新错题本数据
     *
     * @param userAnswer
     */
    private void updateBookData(UserAnswer userAnswer) {
        // 答错更新错题本数据
        BookQuery bookQuery = new BookQuery();
        bookQuery.setQuId(userAnswer.getQuId());
        bookQuery.setUserId(userAnswer.getUserId());
        List<Book> bookList = bookMapper.selectList(bookQuery);
        if (bookList != null && bookList.size() != 0) {
            // 存在，则直接进行更改
            Book book = bookList.get(0);
            book.setWrongCount(book.getWrongCount() + 1);
            Integer update = bookMapper.updateById(book, book.getId());
            if (update <= 0) {
                throw new BusinessException("更新错题表失败");
            }
        } else {
            Book book = new Book();
            book.setId(CommonUtil.getRandomId());
            book.setQuId(userAnswer.getQuId());
            book.setUserId(userAnswer.getUserId());
            book.setWrongCount(1);
            Integer insert = bookMapper.insert(book);
            if (insert <= 0) {
                throw new BusinessException("更新错题表失败");
            }
        }
    }
}
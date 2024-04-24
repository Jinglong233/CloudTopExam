package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.jl.project.entity.dto.UpdateExamRecordDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.po.Paper;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.CorrectUserExamUserVO;
import com.jl.project.entity.vo.ExamRecordVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.ExamMapper;
import com.jl.project.mapper.ExamRecordMapper;
import com.jl.project.mapper.PaperMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.ExamRecordService;
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
    private ExamMapper<Exam, ExamQuery> examMapper;


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
        if (updateExamRecordDTO == null
                || updateExamRecordDTO.getId() == null
                || updateExamRecordDTO.getExamRecord() == null) {
            throw new BusinessException("缺少参数");
        }
        String id = updateExamRecordDTO.getId();
        ExamRecord examRecord = updateExamRecordDTO.getExamRecord();
        Integer handState = examRecord.getHandState();
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
        if (query == null) {
            throw new BusinessException("缺少查询参数");
        }
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

}
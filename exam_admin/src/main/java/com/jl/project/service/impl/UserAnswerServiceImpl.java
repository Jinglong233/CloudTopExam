package com.jl.project.service.impl;

import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.dto.UpdateUserAnswerDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.GroupListVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.PaperAndQuVO;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.service.UserAnswerService;
import com.jl.project.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:用户答案表Service
 * @author:jingLong
 * @date:2023/12/11
 */
@Service("userAnswerService")
public class UserAnswerServiceImpl implements UserAnswerService {

    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private QuAnswerMapper<QuAnswer, QuAnswerQuery> quAnswerMapper;

    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

    @Resource
    private QuMapper<Qu, QuMapper> quMapper;

    /**
     * 根据条件查询列表
     */
    public List<UserAnswer> findListByParam(UserAnswerQuery query) throws BusinessException {
        if (query == null) {
            throw new BusinessException("缺少参数");
        }
        List<UserAnswer> list = userAnswerMapper.selectList(query);
        return list;
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(UserAnswerQuery query) {
        return this.userAnswerMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<UserAnswer> findListByPage(UserAnswerQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<UserAnswer> list = this.findListByParam(query);
        PaginationResultVO<UserAnswer> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    public List<UserAnswer> add(AddUserAnswerDTO addUserAnswerDTO) throws BusinessException {
        if (addUserAnswerDTO == null
                || addUserAnswerDTO.getUserId() == null
                || addUserAnswerDTO.getExamRecordId() == null) {
            throw new BusinessException("缺少参数");
        }


        String userId = addUserAnswerDTO.getUserId();
        if (userId == null) {
            throw new BusinessException("缺少用户信息");
        }

        String examRecordId = addUserAnswerDTO.getExamRecordId();
        if (examRecordId == null) {
            throw new BusinessException("缺少考试记录信息");
        }


        // 如果是第一次才创建空白记录
        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
        userAnswerQuery.setExamRecordId(examRecordId);
        List<UserAnswer> list = userAnswerMapper.selectList(userAnswerQuery);
        if (list != null) {
            return list;
        }

        // 1. 获取所有的题目
        PaperAndQuVO paperAndQuVO = addUserAnswerDTO.getPaperAndQuVO();
        if (paperAndQuVO == null) {
            throw new BusinessException("缺少试卷信息");
        }
        List<GroupListVO> groupLists = paperAndQuVO.getGroupLists();
        if (groupLists == null || groupLists.size() == 0) {
            throw new BusinessException("缺少答题参数");
        }

        // 2. 遍历大题
        for (GroupListVO groupList : groupLists) {
            List<QuAndAnswerVo> quList = groupList.getQuList();
            if (quList == null) {
                throw new BusinessException("缺少题目信息");
            }

            // 3. 遍历题目
            for (QuAndAnswerVo quAndAnswerVo : quList) {
                List<QuAnswer> quAnswerList = quAndAnswerVo.getQuAnswerList();
                String quId = quAndAnswerVo.getId();
                // 4. 创建题目记录
                UserAnswer userAnswer = new UserAnswer();
                String userAnswerId = CommonUtil.getRandomId();
                userAnswer.setQuId(quId);
                userAnswer.setExamRecordId(examRecordId);
                userAnswer.setId(userAnswerId);
                userAnswer.setUserId(userId);
                // todo 多选题考虑 创建几个答案

                // todo 题目排序预留

                // 5. 插入用户记录
                Integer result = userAnswerMapper.insert(userAnswer);
                if (result <= 0) {
                    throw new BusinessException("创建失败，联系管理员");
                }
            }

        }
        userAnswerQuery = new UserAnswerQuery();
        userAnswerQuery.setExamRecordId(examRecordId);
        list = userAnswerMapper.selectList(userAnswerQuery);
        return list;
    }

    /**
     * 批量新增
     */
    public Integer addBatch(List<UserAnswer> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.userAnswerMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    public Integer addOrUpdateBatch(List<UserAnswer> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.userAnswerMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据Id查询
     */
    public UserAnswer getUserAnswerById(String id) {
        return this.userAnswerMapper.selectById(id);
    }

    /**
     * 根据Id更新
     */
    public Boolean updateUserAnswerById(UpdateUserAnswerDTO updateUserAnswerDTO) throws BusinessException {
        if (updateUserAnswerDTO == null) {
            throw new BusinessException("缺少参数");
        }
        UserAnswer userAnswer = updateUserAnswerDTO.getUserAnswer();
        if (userAnswer == null) {
            throw new BusinessException("缺少必要参数");
        }

        String id = userAnswer.getId();
        if (id == null) {
            throw new BusinessException("缺少Id");
        }

        // 更新该条答题记录
        Integer result = userAnswerMapper.updateById(userAnswer, id);
        if (result <= 0) {
            throw new BusinessException("更新答题记录失败");
        }


        // 查询关联考试记录信息
        String examRecordId = userAnswer.getExamRecordId();
        if (examRecordId == null) {
            throw new BusinessException("缺少考试记录信息");
        }
        ExamRecord examRecord = examRecordMapper.selectById(examRecordId);

        // 查询考试记录关联的所有答题记录
        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
        userAnswerQuery.setExamRecordId(examRecordId);
        List<UserAnswer> userAnswers = userAnswerMapper.selectList(userAnswerQuery);
        if (userAnswers == null || userAnswers.isEmpty()) {
            throw new BusinessException("缺少用户答题列表信息");
        }

        // 更新总分
        Integer totalScore = 0;
        for (UserAnswer answer : userAnswers) {
            totalScore += answer.getScore();
        }
        examRecord.setTotalScore(totalScore);

        // 获取该场考试信息
        String examId = examRecord.getExamId();
        if (examId == null) {
            throw new BusinessException("缺少关联考试信息");
        }

        Exam exam = examMapper.selectById(examId);
        if (exam == null) {
            throw new BusinessException("缺少关联考试信息");
        }
        Integer qualifyScore = exam.getQualifyScore();

        // 判断是否及格
        examRecord.setPassed(totalScore < qualifyScore ? 0 : 1);

        Integer examRecordUpdate = examRecordMapper.updateById(examRecord, examRecordId);
        if (examRecordUpdate <= 0) {
            throw new BusinessException("更新关联考试记录信息失败");
        }

        return true;
    }

    /**
     * 根据Id删除
     */
    public Integer deleteUserAnswerById(String id) {
        return this.userAnswerMapper.deleteById(id);
    }

}
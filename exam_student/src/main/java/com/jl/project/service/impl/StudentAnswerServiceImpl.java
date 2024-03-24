package com.jl.project.service.impl;

import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.po.GlQu;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.po.UserAnswer;
import com.jl.project.entity.query.GlQuQuery;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.UserAnswerQuery;
import com.jl.project.entity.vo.*;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.GlQuMapper;
import com.jl.project.mapper.QuMapper;
import com.jl.project.mapper.UserAnswerMapper;
import com.jl.project.service.StudentAnswerService;
import com.jl.project.strategy.StrategyContext;
import com.jl.project.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:用户答案表Service
 * @author:jingLong
 * @date:2023/12/11
 */
@Service("studentAnswerService")
public class StudentAnswerServiceImpl implements StudentAnswerService {

    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private GlQuMapper<GlQu, GlQuQuery> glQuMapper;

    @Resource
    private StrategyContext strategyContext;

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
        if (list != null && !list.isEmpty()) {
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
    public List<UserAnswer> updateUserAnswerById(CorrectUserAnswerDTO correctUserAnswerDTO) throws BusinessException {
        if (correctUserAnswerDTO == null) {
            throw new BusinessException("缺少参数");
        }
        UserAnswer userAnswer = correctUserAnswerDTO.getUserAnswer();
        if (userAnswer == null) {
            throw new BusinessException("缺少必要参数");
        }

        String id = userAnswer.getId();
        if (id == null) {
            throw new BusinessException("缺少Id");
        }


        // 获取题目题型
        String quId = userAnswer.getQuId();
        if (quId == null) {
            throw new BusinessException("缺少题目Id");
        }
        Qu qu = quMapper.selectById(quId);
        if (qu == null) {
            throw new BusinessException("题目信息不存在");
        }

        Integer quType = qu.getQuType();

        // 注意：这里的分数从gl_qu来拿
        // glId + quId 可以获取到对应的分数
        GlQuQuery glQuQuery = new GlQuQuery();
        String glId = correctUserAnswerDTO.getGlId();
        glQuQuery.setGlId(glId);
        glQuQuery.setQuId(quId);


        Integer score = 0;
        List<GlQu> glQus = glQuMapper.selectList(glQuQuery);
        if (glQus != null && !glQus.isEmpty()) {
            score = glQus.get(0).getScore();
        }


        Boolean answer = strategyContext.isAnswer(userAnswer, quType,score);
        if (!answer) {
            throw new BusinessException("用户答题记录更新出错");
        }

        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
        userAnswerQuery.setUserId(correctUserAnswerDTO.getUserAnswer().getUserId());
        userAnswerQuery.setExamRecordId(correctUserAnswerDTO.getUserAnswer().getExamRecordId());
        List<UserAnswer> userAnswers = userAnswerMapper.selectList(userAnswerQuery);

        return userAnswers;
    }

    /**
     * 根据Id删除
     */
    public Integer deleteUserAnswerById(String id) {
        return this.userAnswerMapper.deleteById(id);
    }

}
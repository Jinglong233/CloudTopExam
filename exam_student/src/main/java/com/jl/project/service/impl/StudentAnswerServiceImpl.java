package com.jl.project.service.impl;

import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.*;
import com.jl.project.enums.PageSize;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.service.QuService;
import com.jl.project.service.StudentAnswerService;
import com.jl.project.strategy.JudeProblemStrategyContext;
import com.jl.project.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private UserMapper<User, UserQuery> userMapper;
    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private GlQuMapper<GlQu, GlQuQuery> glQuMapper;


    @Resource
    private TrainRecordMapper<TrainRecord, TrainRecordQuQuery> trainRecordMapper;

    @Resource
    private TrainMapper<Train, TrainQuery> trainMapper;

    @Resource
    private QuService quService;


    @Resource
    private JudeProblemStrategyContext strategyContext;


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

        Boolean answer = strategyContext.isAnswer(userAnswer, quType, score);
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

    @Override
    public List<ErrorVO> errorCount(String userId) throws BusinessException {
        if (userId == null) {
            throw new BusinessException("缺少参数");
        }
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        // 获取考试中的错题
        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
        userAnswerQuery.setUserId(userId);
        List<UserAnswer> userAnswers =
                userAnswerMapper.selectList(userAnswerQuery);
        // 抽取题目回答的正确错误次数(考试记录中：1是答对，null和0是答错)
        // 注意：true是答对的，false是答错的
        Map<String, Map<Boolean, Long>> examCount = userAnswers.stream()
                .collect(Collectors.groupingBy(p -> p.getQuId(),
                        Collectors.partitioningBy(p -> p.getIsRight() != null && p.getIsRight() == 1,
                                Collectors.counting())));


        List<TrainRecord> trainRecordCount = new ArrayList<>();
        // 获取训练记录
        TrainQuery trainQuery = new TrainQuery();
        trainQuery.setUserId(userId);
        List<Train> trains = trainMapper.selectList(trainQuery);
        if (trains != null && !trains.isEmpty()) {
            // 遍历记录，获取答题记录
            for (Train train : trains) {
                Integer answerCount = train.getAnswerCount();
                // 如果训练回答题目数量为0，则题目记录就不存在
                if (answerCount <= 0) {
                    continue;
                }
                TrainRecordQuery trainRecordQuery = new TrainRecordQuery();
                trainRecordQuery.setTrainId(train.getId());
                List<TrainRecord> trainRecords =
                        trainRecordMapper.selectList(trainRecordQuery);
                trainRecordCount.addAll(trainRecords);
            }
        }

        // 统计训练的错题
        Map<String, Map<Boolean, Long>> trainCount = trainRecordCount.stream()
                .filter(p -> p.getIsRight() != null) // 过滤p.getIsRight()的情况（因为训练的null没意义，训练结束后会删除）
                .collect(Collectors.groupingBy(p -> p.getQuId(),
                        Collectors.partitioningBy(p -> p.getIsRight() == 1,
                                Collectors.counting())));

        // 统计总记录
        // 创建一个新的Map用于存储合并后的结果
        Map<String, Map<Boolean, Long>> resultCount = new HashMap<>();

        // 将trainCount1的内容添加到mergedTrainCount中
        for (Map.Entry<String, Map<Boolean, Long>> entry : examCount.entrySet()) {
            String key = entry.getKey();
            Map<Boolean, Long> value = entry.getValue();
            resultCount.put(key, new HashMap<>(value));
        }

        // 将trainCount2的内容添加到mergedTrainCount中
        for (Map.Entry<String, Map<Boolean, Long>> entry : trainCount.entrySet()) {
            String key = entry.getKey();
            Map<Boolean, Long> value = entry.getValue();
            if (!resultCount.containsKey(key)) {
                resultCount.put(key, new HashMap<>(value));
            } else {
                Map<Boolean, Long> existingValue = resultCount.get(key);
                for (Map.Entry<Boolean, Long> subEntry : value.entrySet()) {
                    Boolean subKey = subEntry.getKey();
                    Long subValue = subEntry.getValue();
                    existingValue.put(subKey, existingValue.getOrDefault(subKey, 0L) + subValue);
                }
            }
        }

        List<ErrorVO> result = new ArrayList<>();

        // 查询题目的具体信息
        for (Map.Entry<String, Map<Boolean, Long>> quEntry : resultCount.entrySet()) {
            String quId = quEntry.getKey();
            Map<Boolean, Long> value = quEntry.getValue();
            QuAndAnswerVo quAndAnswerVo = quService.getQuById(quId);
            if (quAndAnswerVo != null) {
                ErrorVO errorVO = new ErrorVO();
                errorVO.setQuAndAnswerVo(quAndAnswerVo);
                Integer rightCount = Integer.valueOf(value.get(true).toString());
                Integer wrongCount = Integer.valueOf(value.get(false).toString());
                errorVO.setRightCount(rightCount);
                errorVO.setWrongCount(wrongCount);
                errorVO.setTotalCount(rightCount + wrongCount);
                result.add(errorVO);
            }
        }

        return result;
    }

}
package com.jl.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.google.gson.Gson;
import com.jl.project.entity.dto.StartTrainDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.entity.vo.TrainRecordQuVO;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuType;
import com.jl.project.enums.TrainMode;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.observer.correctObserver.TrainSubject;
import com.jl.project.service.RecommendService;
import com.jl.project.service.StudentTrainService;
import com.jl.project.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service("studentTrainService")
public class StudentTrainServiceImpl implements StudentTrainService {

    @Resource
    private RepoMapper<Repo, RepoQuery> repoMapper;

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;
    @Resource
    private TrainMapper<Train, TrainQuery> trainMapper;

    @Resource
    private TrainSubject trainSubject;


    @Resource
    private QuMapper<Qu, QuQuery> QuMapper;

    @Resource
    private QuAnswerMapper<QuAnswer, QuAnswerQuery> quAnswerMapper;

    @Resource
    private TrainRecordMapper<TrainRecord, TrainRecordQuery> trainRecordMapper;

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private RecommendService recommendService;


    @Override
    public List<Repo> getRepoList(RepoQuery repoQuery) {
        List<Repo> repos = repoMapper.selectList(repoQuery);
        return repos;
    }

    @Override
    public Map<Integer, Long> getQuTypeClassifyByRepoId(String repoId) {
        QuQuery quQuery = new QuQuery();
        quQuery.setRepoId(repoId);


        Map<Integer, Long> result = new HashMap<>();

        // 单选
        quQuery.setQuType(QuType.RADIO.getValue());
        Integer radioCount = quMapper.selectCount(quQuery);
        result.put(QuType.RADIO.getValue(), Long.valueOf(radioCount));

        // 多选
        quQuery.setQuType(QuType.MULTI.getValue());
        Integer multiCount = quMapper.selectCount(quQuery);
        result.put(QuType.MULTI.getValue(), Long.valueOf(multiCount));

        // 判断
        quQuery.setQuType(QuType.JUDGE.getValue());
        Integer judgeCount = quMapper.selectCount(quQuery);
        result.put(QuType.JUDGE.getValue(), Long.valueOf(judgeCount));

        return result;
    }

    @Override
    @Transactional
    public String startTrain(StartTrainDTO startTrainDTO) throws BusinessException {

        if (startTrainDTO == null) {
            throw new BusinessException("缺少参数");
        }


        // 获取用户Id
        String userId = startTrainDTO.getUserId();
        if (userId == null || userId.trim().equals("")) {
            throw new BusinessException("缺少参数");
        }

        // 获取训练模式
        Integer mode = startTrainDTO.getMode();

        String repoId = startTrainDTO.getRepoId();
        // 不是智能训练的都需要题库ID
        if (!TrainMode.INTELLIGENT.getValue().equals(mode) && StrUtil.isEmpty(repoId)) {
            throw new BusinessException("缺少题库Id");
        }

        Integer quType = startTrainDTO.getQuType();


        // 判断是否该模式下是否有未完成的训练记录
        TrainQuery trainQuery = new TrainQuery();
        trainQuery.setUserId(userId);
        trainQuery.setRepoId(repoId);
        trainQuery.setMode(mode);
        if (mode.equals(TrainMode.QUTYPE.getValue())) { // 指定题型训练
            if (quType == null) {
                throw new BusinessException("缺少题型参数");
            }
            trainQuery.setQuType(quType);
        }
        trainQuery.setState(0);

        List<Train> list = trainMapper.selectList(trainQuery);
        if (list != null && !list.isEmpty()) {
            return list.get(0).getId();
        }


        Train train = new Train();
        // 设置题库Id
        train.setRepoId(repoId);


        // 生成随机ID
        String trainId = CommonUtil.getRandomId();
        train.setId(trainId);
        // 设置开始训练时间
        train.setTrainTime(new Date());


        // 设置答题者Id
        train.setUserId(userId);

        // 设置训练状态(未完成)
        train.setState(0);
        // 设置训练进度
        train.setPercent("0");


        train.setMode(mode);

        List<Qu> quList = null;
        QuQuery quQuery = new QuQuery();
        quQuery.setRepoId(repoId);
        if (mode.equals(TrainMode.QUTYPE.getValue())) { // 指定题型训练

            // 设置题型
            train.setQuType(quType);

            // 判断题型
            quType = startTrainDTO.getQuType();
            if (quType == null) {
                throw new BusinessException("缺少题型类型");
            }

            // 获取指定题型题目
            quQuery.setQuType(quType);
            quList = quMapper.selectList(quQuery);
            if (quList == null || quList.isEmpty()) {
                throw new BusinessException("题库对应题型题目数量为0");
            }
        } else if (mode.equals(TrainMode.RANDOM.getValue())) { // 随机训练
            quList = quMapper.selectList(quQuery);
            // 排除简答题和填空
            quList = quList.stream().filter(qu -> {
                if (QuType.SHORTANSWER.getValue().equals(qu.getQuType())
                        || QuType.FILL.getValue().equals(qu.getQuType())) {
                    return false;
                }
                return true;
            }).collect(Collectors.toList());
            // 排除多选和填空
            Collections.shuffle(quList);

        } else if (mode.equals(TrainMode.SEQUENCE.getValue())) { // 顺序训练
            quList = quMapper.selectList(quQuery);
            // 排除简答题和填空
            quList = quList.stream().filter(qu -> {
                if (QuType.SHORTANSWER.getValue().equals(qu.getQuType())
                        || QuType.FILL.getValue().equals(qu.getQuType())) {
                    return false;
                }
                return true;
            }).collect(Collectors.toList());
        } else if (mode.equals(TrainMode.INTELLIGENT.getValue())) {// 智能推荐训练
            List<String> recommendQuList = recommendService.getRecommendQuList();
            quList = quMapper.getQuListByIds(recommendQuList);
        }
        // 设置题目总数
        train.setTotalCount(quList.size());

        //  插入
        Integer result = trainMapper.insert(train);
        if (result <= 0) {
            throw new BusinessException("创建训练记录失败");
        }

        // 创建题目训练记录
        List<TrainRecord> trainRecords = new ArrayList<>();
        int sort = 1;
        if (quList == null || quList.isEmpty()) {
            throw new BusinessException("题目为空");
        }
        for (Qu qu : quList) {
            String trainRecordId = CommonUtil.getRandomId();
            TrainRecord trainRecord = new TrainRecord();
            trainRecord.setQuId(qu.getId());
            trainRecord.setTrainId(trainId);
            trainRecord.setId(trainRecordId);
            trainRecord.setSort(sort++);
            trainRecord.setAnswered(0);
            trainRecords.add(trainRecord);
        }

        // 批量插入
        Integer insert = trainRecordMapper.insertBatch(trainRecords);

        // 新增用户答题训练记录
        if (insert <= 0) {
            throw new BusinessException("新增用户答题记录失败");
        }
        return trainId;
    }

    @Override
    public Integer getTrainRecordById(String trainId) throws BusinessException {
        // 根据Id获取训练记录
        Train train = trainMapper.selectById(trainId);
        if (train == null) {
            throw new BusinessException("训练记录不存在");
        }

        // 这里直接查询总数量，为了提高查询效率：点击对应题目的时候，当前题目index（sort）+此次训练Id就可以定位到对应的题目
        // 在题目上千的时候，查询效率很慢
        Integer totalCount = train.getTotalCount();

        if (totalCount <= 0) {
            throw new BusinessException("训练题目为0");
        }

        return totalCount;
    }

    @Override
    public TrainRecordQuVO getTrainRecordQu(TrainRecordQuQuery trainRecordQuQuery) throws BusinessException {
        if (trainRecordQuQuery == null) {
            throw new BusinessException("缺少参数");
        }

        Integer sort = trainRecordQuQuery.getSort();
        String trainId = trainRecordQuQuery.getTrainId();
        if (sort == null || trainId == null) {
            throw new BusinessException("缺少参数");
        }

        TrainRecordQuery trainRecordQuery = new TrainRecordQuery();
        trainRecordQuery.setTrainId(trainId);
        trainRecordQuery.setSort(sort);

        List<TrainRecord> trainRecords = trainRecordMapper.selectList(trainRecordQuery);
        if (trainRecords == null || trainRecords.isEmpty()) {
            throw new BusinessException("该训练题目不存在");
        }

        TrainRecord trainRecord = trainRecords.get(0);
        if (trainRecord == null) {
            throw new BusinessException("题目记录不存在");
        }
        String quId = trainRecord.getQuId();
        Qu qu = quMapper.selectById(quId);
        if (qu == null) {
            throw new BusinessException("题目不存在");
        }

        // 获取题目对应选项
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(quId);
        List<QuAnswer> quAnswerList = quAnswerMapper.selectList(quAnswerQuery);
        // 非选择题不用排序
        if (qu.getQuType().equals(QuType.MULTI.getValue()) || qu.getQuType().equals(QuType.RADIO.getValue())) {
            // 对选项排序
            quAnswerList = quAnswerList.stream().sorted(Comparator.comparing(QuAnswer::getTag)).collect(Collectors.toList());
        }

        // 创建返回视图对象
        TrainRecordQuVO trainRecordQuVO = new TrainRecordQuVO();
        trainRecordQuVO.setTrainRecord(trainRecord);
        QuAndAnswerVo quAndAnswerVo = new QuAndAnswerVo();
        BeanUtil.copyProperties(qu, quAndAnswerVo);
        quAndAnswerVo.setQuAnswerList(quAnswerList);
        trainRecordQuVO.setQuAndAnswerVo(quAndAnswerVo);

        return trainRecordQuVO;
    }

    @Transactional
    @Override
    public Boolean updateTrainRecord(TrainRecord trainRecord) throws BusinessException {
        if (trainRecord == null) {
            throw new BusinessException("缺少参数");
        }
        String jsonAnswerId = trainRecord.getAnswerId();
        // 将Json字符串转换为数组
        Gson gson = new Gson();
        List<String> answerIdList = gson.fromJson(jsonAnswerId, List.class);

        // 判断是否作答(非简答题)
        if (answerIdList == null || answerIdList.isEmpty()) {
            trainRecord.setAnswered(0);
        } else {
            trainRecord.setAnswered(1);
        }

        // 获取该题目的正确答案
        QuAnswerQuery quAnswerQuery = new QuAnswerQuery();
        quAnswerQuery.setQuId(trainRecord.getQuId());
        quAnswerQuery.setIsRight(1);

        List<QuAnswer> trueQuAnswers = quAnswerMapper.selectList(quAnswerQuery);
        if (trueQuAnswers == null || trueQuAnswers.isEmpty()) {
            throw new BusinessException("该单选题没答案");
        }

        List<String> trueAnswerIdList = new ArrayList<>();
        if (trueQuAnswers == null || trueQuAnswers.isEmpty()) {
            throw new BusinessException("该题目无答案");
        } else {
            // 只抽取正确答案的Id
            trueAnswerIdList = trueQuAnswers.stream()
                    .map(QuAnswer::getId).collect(Collectors.toList());
        }

        // 判断题目是否作对
        boolean isEqual = CollUtil.isEqualList(trueAnswerIdList, answerIdList);


        trainRecord.setIsRight(isEqual ? 1 : 0);
        // 更新
        Integer result = trainRecordMapper.updateById(trainRecord, trainRecord.getId());

        if (result <= 0) {
            throw new BusinessException("更新作答记录失败");
        }

        // 更新关联训练信息
        String trainId = trainRecord.getTrainId();
        if (trainId == null) {
            throw new BusinessException("未关联训练记录");
        }
        Train train = trainMapper.selectById(trainId);
        if (train == null) {
            throw new BusinessException("关联训练记录不存在");
        }

        // 更新答题数量
        Integer answerCount = train.getAnswerCount();
        answerCount += 1;
        train.setAnswerCount(answerCount);

        // 更新正确数量
        if (isEqual) {
            Integer rightCount = train.getRightCount();
            rightCount += 1;
            train.setRightCount(rightCount);
        }

        // 更新训练进度
        Integer count = train.getAnswerCount();
        Integer totalCount = train.getTotalCount();
        String per = NumberUtil.decimalFormat("#.##", (double) count / totalCount);
        train.setPercent(per);

        // 更新最近训练时间
        train.setTrainTime(new Date());

        // 进行更新操作
        result = trainMapper.updateById(train, trainId);
        return result > 0;
    }

    @Override
    public Boolean stopTrain(String trainId) throws BusinessException {
        // 更新训练状态
        Train train = trainMapper.selectById(trainId);
        if (train == null) {
            throw new BusinessException("训练记录不存在");
        }
        train.setState(1);


        // 更新
        Integer result = trainMapper.updateById(train, trainId);
        if (result <= 0) {
            throw new BusinessException("更新训练记录失败");
        }


        // 压缩作答记录节省空间（删除未作答的记录，该部分内容没用）

        // 获取关联记录
        TrainRecordQuery trainRecordQuery = new TrainRecordQuery();
        trainRecordQuery.setTrainId(trainId);

        // 进行未作答题目的删除
        try {
            trainRecordMapper.deleteNoAnswerRecord();
        } catch (Exception e) {
            throw new BusinessException("提交失败");
        }

        // 获取此次训练的所有答题记录，做错题统计
        List<TrainRecord> trainRecords = trainRecordMapper.selectList(trainRecordQuery);
        if (trainRecords != null && trainRecords.size() != 0) {
            List<String> wrongList = new ArrayList<>();
            for (TrainRecord trainRecord : trainRecords) {
                // 错题搜集
                if (trainRecord.getIsRight() == 0) {
                    wrongList.add(trainRecord.getQuId());
                }
            }
            // 搜集错题
            trainSubject.notifyBookUpdate(wrongList, train.getUserId());
        }


        return true;
    }

    @Override
    public Train getTrainById(String trainId) throws BusinessException {
        Train train = trainMapper.selectById(trainId);
        if (train == null) {
            throw new BusinessException("训练记录不存在");
        }
        return train;
    }

    @Override
    public PaginationResultVO<Train> getTrain(TrainQuery trainQuery) throws BusinessException {

        if (trainQuery == null) {
            throw new BusinessException("缺少参数");
        }

        return findListByPage(trainQuery);
    }


    /**
     * 根据条件查询列表
     */
    public List<Train> findListByParam(TrainQuery query) {
        return this.trainMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    public Integer findCountByParam(TrainQuery query) {
        return this.trainMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    public PaginationResultVO<Train> findListByPage(TrainQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Train> list = this.findListByParam(query);
        PaginationResultVO<Train> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }


    /**
     * 根据用户答案记录更新错题数据
     */
    private void updateBookData(TrainRecord trainRecord, String userId) {
        // 同时更新错题本数据
        BookQuery bookQuery = new BookQuery();
        bookQuery.setQuId(trainRecord.getQuId());
        bookQuery.setUserId(userId);
        List<Book> list = bookMapper.selectList(bookQuery);
        if (list != null && list.size() != 0) {
            // 存在，则直接进行更改
            Book book = list.get(0);
            book.setWrongCount(book.getWrongCount() + 1);
            Integer integer = bookMapper.updateById(book, book.getId());
            if (integer <= 0) {
                throw new BusinessException("更新错题表失败");
            }
        } else {
            Book book = new Book();
            book.setId(CommonUtil.getRandomId());
            book.setQuId(trainRecord.getQuId());
            book.setUserId(userId);
            book.setWrongCount(1);
            Integer insert = bookMapper.insert(book);
            if (insert <= 0) {
                throw new BusinessException("更新错题表失败");
            }
        }
    }
}
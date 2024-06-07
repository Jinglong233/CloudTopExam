package com.jl.project.service.impl;

import com.jl.project.entity.dto.AddUserAnswerDTO;
import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.*;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuType;
import com.jl.project.exception.BusinessException;
import com.jl.project.mapper.*;
import com.jl.project.service.BookService;
import com.jl.project.service.QuService;
import com.jl.project.service.StudentAnswerService;
import com.jl.project.strategy.JudeProblemStrategyContext;
import com.jl.project.utils.CommonUtil;
import com.jl.project.utils.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:用户答案表Service
 * @author:jingLong
 * @date:2023/12/11
 */
@Service("studentAnswerService")
public class StudentAnswerServiceImpl implements StudentAnswerService {

    private static final Logger logger = LoggerFactory.getLogger(StudentAnswerServiceImpl.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    BookService bookService;


    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private TrainRecordMapper<TrainRecord, TrainRecordQuery> trainRecordMapper;

    @Resource
    private QuService quService;


    @Resource
    private BookMapper<Book, BookQuery> bookMapper;

    @Resource
    private WrongAnswerMapper<WrongAnswer, WrongAnswerQuery> wrongAnswerMapper;

    @Resource
    private QuMapper<Qu, QuQuery> quMapper;

    @Resource
    private GlQuMapper<GlQu, GlQuQuery> glQuMapper;

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
    public PaginationResultVO<ErrorVO> errorCount(BookQuery bookQuery) throws BusinessException {
        PaginationResultVO<ErrorVO> resultVO = new PaginationResultVO<>();

        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        String userId = loginUserInfo.getId();
        if (userId == null) {
            throw new BusinessException("缺少参数");
        }
        List<ErrorVO> result = new ArrayList<>();
        // 获取错题记录中的题目
        bookQuery.setUserId(userId);
        PaginationResultVO<Book> bookPage = bookService.findListByPage(bookQuery);
        List<Book> bookList = bookPage.getList();
        if (bookList != null && !bookList.isEmpty()) {
            for (Book book : bookList) {
                Integer quAnswerCount = 0;
                ErrorVO errorVO = new ErrorVO();
                Integer quType = book.getQuType();
                // 获取该道题目的详情和选项数据
                QuAndAnswerVo qu = quService.getQuById(book.getQuId());
                if (qu == null) {
                    logger.error("题目不存在,题目Id:{}", book.getQuId());
                    continue;
                }
                // 统计答题总数
                UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
                userAnswerQuery.setQuId(qu.getId());
                userAnswerQuery.setUserId(userId);
                // 考试答题次数
                Integer examAnswerCount = userAnswerMapper.selectCount(userAnswerQuery);
                // 训练答题次数
                TrainRecordQuery trainRecordQuery = new TrainRecordQuery();
                trainRecordQuery.setAnswered(1); // 避免将未提交的训练题目统计
                trainRecordQuery.setQuId(qu.getId());
                Integer trainCount = trainRecordMapper.selectCount(trainRecordQuery);
                quAnswerCount = trainCount + examAnswerCount;
                errorVO.setAnswerCount(quAnswerCount);

                errorVO.setQuAndAnswerVo(qu);
                if (quType != QuType.FILL.getValue() && quType != QuType.SHORTANSWER.getValue()) {
                    Map<String, Integer> wrongAnswerMap = new HashMap<>();
                    List<QuAnswer> quAnswerList = qu.getQuAnswerList();
                    if (quAnswerList != null && !quAnswerList.isEmpty()) {
                        // 建立选项和次数累计
                        for (QuAnswer quAnswer : quAnswerList) {
                            WrongAnswerQuery wrongAnswerQuery = new WrongAnswerQuery();
                            wrongAnswerQuery.setBookId(book.getId());
                            wrongAnswerQuery.setAnswerId(quAnswer.getId());
                            List<WrongAnswer> list = wrongAnswerMapper.selectList(wrongAnswerQuery);
                            if (list != null && !list.isEmpty()) {
                                wrongAnswerMap.put(
                                        quType.equals(QuType.JUDGE.getValue()) ? quAnswer.getContent() : quAnswer.getTag(),
                                        list.get(0).getWrongCount());
                            } else {
                                wrongAnswerMap.put(quType.equals(QuType.JUDGE.getValue()) ? quAnswer.getContent() : quAnswer.getTag(), 0);
                            }
                            errorVO.setWrongAnswerCount(wrongAnswerMap);
                        }
                    }
                }
                errorVO.setBook(book);
                result.add(errorVO);
            }
        }

        resultVO.setPageTotal(bookPage.getPageTotal());
        resultVO.setTotalCount(bookPage.getTotalCount());
        resultVO.setPageNo(bookPage.getPageNo());
        resultVO.setPageSize(bookPage.getPageSize());
        resultVO.setList(result);
        return resultVO;

    }

    @Override
    public WrongKnowledgeVO getErrorKnowledge() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(request, stringRedisTemplate);
        List<String> userId = new ArrayList<>();
        userId.add(loginUserInfo.getId());
        List<Book> bookList = bookMapper.getBookListByUserIds(userId);
        List<ChartVO> resultList = null;
        Long count = 0L;
        if (!bookList.isEmpty()) {

            Map<String, Long> knowlendgeCountMap = bookList.stream()
                    .collect(Collectors.groupingBy(Book::getKnContent, Collectors.counting()));

            count = knowlendgeCountMap.values().stream()
                    .mapToLong(Long::longValue)
                    .sum();
            resultList = knowlendgeCountMap.entrySet().stream()
                    .map(entry -> new ChartVO(entry.getKey(), entry.getValue().intValue()))
                    .collect(Collectors.toList());
        }

        WrongKnowledgeVO wrongKnowledgeVO = new WrongKnowledgeVO();
        wrongKnowledgeVO.setChartData(resultList);
        wrongKnowledgeVO.setCount(count.intValue());
        wrongKnowledgeVO.setStatisticalTime(new Date());
        return wrongKnowledgeVO;
    }

}
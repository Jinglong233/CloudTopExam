package com.jl.project.service.impl;

import com.jl.project.entity.po.*;
import com.jl.project.entity.query.*;
import com.jl.project.entity.vo.*;
import com.jl.project.enums.PageSize;
import com.jl.project.enums.QuType;
import com.jl.project.mapper.*;
import com.jl.project.service.DataAnalysisService;
import com.jl.project.service.QuService;
import com.jl.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service("dataAnalysisService")
public class DataAnalysisServiceImpl implements DataAnalysisService {
    private static final Logger logger = LoggerFactory.getLogger(DataAnalysisServiceImpl.class);

    @Resource
    private UserMapper<User, UserQuery> userMapper;


    @Resource
    private TrainRecordMapper<TrainRecord, TrainRecordQuery> trainRecordMapper;


    @Resource
    private UserAnswerMapper<UserAnswer, UserAnswerQuery> userAnswerMapper;

    @Resource
    private QuService quService;

    @Resource
    private SubjectMapper<Subject, SubjectQuery> subjectMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;


    @Resource
    private BookMapper<Book, BookQuery> bookMapper;

    @Resource
    private UserService userService;

    @Resource
    private DepartmentMapper<Department, DepartmentQuery> departmentMapper;

    @Resource
    private WrongAnswerMapper<WrongAnswer, WrongAnswerQuery> wrongAnswerMapper;

    @Override
    public List<Map<String, Object>> getSexProportion() {
        List<User> userList = userMapper.selectList(new UserQuery());
        if (userList == null || userList.isEmpty()) {
            return new ArrayList<>();
        }
        List<Map<String, Object>> collect = userList.stream().collect(
                        Collectors.groupingBy(
                                user -> {
                                    if (user.getSex() == null) {
                                        return "未知";
                                    } else if (user.getSex() == 0) {
                                        return "女";
                                    } else if (user.getSex() == 1) {
                                        return "男";
                                    } else {
                                        return "未知";
                                    }
                                }, Collectors.counting()
                        )).entrySet().stream()
                .map(entry -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("name", entry.getKey());
                    map.put("value", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public Map<String, List> getRecentExamInfo() {
        ExamQuery examQuery = null;
        Map<String, List> map = new HashMap<>();
        List<String> x = new ArrayList<>();
        // 添加X轴日期
        for (int i = 6; i >= 0; i--) {
            x.add(LocalDate.now().minusDays(i).toString());
        }
        map.put("x", x);

        List<Integer> data = new ArrayList<>();
        for (String date : x) {
            examQuery = new ExamQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String start = LocalDateTime.of(LocalDate.parse(date), LocalTime.of(0, 0, 0)).format(formatter);
            String end = LocalDateTime.of(LocalDate.parse(date), LocalTime.of(23, 59, 59)).format(formatter);
            examQuery.setStartTimeStart(start);
            examQuery.setStartTimeEnd(end);
            List<Exam> examList = examMapper.selectList(examQuery);
            if (examList != null) {
                data.add(examList.size());
            }
        }
        map.put("data", data);
        return map;
    }

    @Override
    public WrongDeptCommon getQuTypeProportion() {

        Integer count = 0;

        List<ChartVO> result = new ArrayList<>();
        // 分类获取错题题型统计
        BookQuery bookQuery = new BookQuery();
        // 单选
        bookQuery.setQuType(QuType.RADIO.getValue());
        Integer radioCount = bookMapper.selectCount(bookQuery);
        ChartVO radioVO = new ChartVO(QuType.RADIO.getType(), radioCount);
        result.add(radioVO);
        // 多选
        bookQuery.setQuType(QuType.MULTI.getValue());
        Integer multiCount = bookMapper.selectCount(bookQuery);
        ChartVO multiVO = new ChartVO(QuType.MULTI.getType(), multiCount);
        result.add(multiVO);
        // 填空
        bookQuery.setQuType(QuType.FILL.getValue());
        Integer fillCount = bookMapper.selectCount(bookQuery);
        ChartVO fillVO = new ChartVO(QuType.FILL.getType(), fillCount);
        result.add(fillVO);
        // 判断
        bookQuery.setQuType(QuType.JUDGE.getValue());
        Integer judgeCount = bookMapper.selectCount(bookQuery);
        ChartVO judgeVO = new ChartVO(QuType.JUDGE.getType(), judgeCount);
        result.add(judgeVO);
        // 简答
        bookQuery.setQuType(QuType.SHORTANSWER.getValue());
        Integer shortAnswerCount = bookMapper.selectCount(bookQuery);
        ChartVO shortAnswerVO = new ChartVO(QuType.SHORTANSWER.getType(), shortAnswerCount);
        result.add(shortAnswerVO);

        // 总错题数量
        count = radioCount + multiCount + judgeCount + fillCount + shortAnswerCount;


        WrongDeptCommon WrongDeptCommon = new WrongDeptCommon(result, count, new Date());

        return WrongDeptCommon;
    }

    @Override
    public WrongDeptCommon getTopFiveWrongTopics() {
        // 1. 获取所有错题的分类统计
        List<ChartVO> chartVOS = bookMapper.selectByKnowledge();

        Integer count = 0;
        // 2. 获取总数
        if (chartVOS != null && !chartVOS.isEmpty()) {
            for (ChartVO chartVO : chartVOS) {
                count += chartVO.getValue();
            }
        }
        WrongDeptCommon result = new WrongDeptCommon(chartVOS, count, new Date());
        return result;
    }

    @Override
    public WrongDeptCommon getTemporalErrorAnalysis() {
        // 查询考试、训练时间段错题
        UserAnswerQuery userAnswerQuery = new UserAnswerQuery();
        userAnswerQuery.setIsRight(0);
        // todo 未做完

        return null;
    }

    @Override
    public List<WrongCountSummaryVO> getWrongCountSummary() {
        List<WrongCountSummaryVO> result = bookMapper.selectWrongCountSummary();
        return result;
    }

    @Override
    public List<String> getKnowledgeList() {
        List<String> result = bookMapper.selectKnContentList();
        return result;
    }

    @Override
    public WrongDeptCommon getWrongDeptWrongKn(String deptCode) {
        // 获取部门下的所有用户
        UserQuery userQuery = new UserQuery();
        userQuery.setDeptCodeFuzzy(deptCode);
        List<User> userList = userMapper.selectList(userQuery);
        List<Book> bookList = new ArrayList<>();
        if (userList != null && !userList.isEmpty()) {
            // 获取用户的错题统计
            for (User user : userList) {
                BookQuery bookQuery = new BookQuery();
                bookQuery.setUserId(user.getId());
                bookList.addAll(bookMapper.selectList(bookQuery));
            }
        }
        WrongDeptCommon wrongDeptCommon = null;
        if (bookList != null && !bookList.isEmpty()) {
            // 分类统计知识点
            Map<String, Long> attributeCounts =
                    bookList.stream()
                            .collect(Collectors.groupingBy(Book::getKnContent, Collectors.counting()));
            List<ChartVO> result = attributeCounts.entrySet().stream()
                    .map(entry -> new ChartVO(entry.getKey(), entry.getValue().intValue()))
                    .sorted(Comparator.comparingInt(ChartVO::getValue).reversed())
                    .limit(5)
                    .collect(Collectors.toList());
            // 计算所有统计值的总和
            Long totalCount = result.stream()
                    .mapToLong(ChartVO::getValue)
                    .sum();
            wrongDeptCommon = new WrongDeptCommon(result, totalCount.intValue(), new Date());
        }

        return wrongDeptCommon == null ? new WrongDeptCommon() : wrongDeptCommon;
    }

    @Override
    public WrongDeptCommon getWrongDeptSubject(String deptCode) {
        // 获取部门下的所有用户
        UserQuery userQuery = new UserQuery();
        userQuery.setDeptCodeFuzzy(deptCode);
        List<User> userList = userMapper.selectList(userQuery);
        List<Book> bookList = new ArrayList<>();
        if (userList != null && !userList.isEmpty()) {
            // 获取用户的错题统计
            for (User user : userList) {
                BookQuery bookQuery = new BookQuery();
                bookQuery.setUserId(user.getId());
                bookList.addAll(bookMapper.selectList(bookQuery));
            }
        }
        WrongDeptCommon wrongDeptCommon = null;
        if (bookList != null && !bookList.isEmpty()) {
            // 分类统计学科
            Map<String, Long> attributeCounts =
                    bookList.stream()
                            .collect(Collectors.groupingBy(Book::getSubjectId, Collectors.counting()));
            List<ChartVO> result = attributeCounts.entrySet().stream()
                    .map(entry -> new ChartVO(entry.getKey(), entry.getValue().intValue()))
                    .sorted(Comparator.comparingInt(ChartVO::getValue).reversed())
                    .limit(5)
                    .collect(Collectors.toList());

            // 获取学科的名称
            if (!result.isEmpty()) {
                for (ChartVO chartVO : result) {
                    Subject subject = subjectMapper.selectById(chartVO.getName());
                    chartVO.setName(subject.getTitle());
                }
            }

            // 计算所有统计值的总和
            Long totalCount = result.stream()
                    .mapToLong(ChartVO::getValue)
                    .sum();
            wrongDeptCommon = new WrongDeptCommon(result, totalCount.intValue(), new Date());
        }

        return wrongDeptCommon == null ? new WrongDeptCommon() : wrongDeptCommon;
    }

    @Override
    public PaginationResultVO<ErrorVO> errorCount(ErrorCountQuery errorCountQuery) {
        Integer pageSize = errorCountQuery.getPageSize() == null ? PageSize.SIZE15.getSize() : errorCountQuery.getPageSize();
        List<ErrorVO> result = new ArrayList<>();
        // 获取部门下的所有用户
        UserQuery userQuery = new UserQuery();
        userQuery.setDeptCodeFuzzy(errorCountQuery.getDeptCode());
        List<User> userList = userMapper.selectList(userQuery);
        if(userList.isEmpty()){
            return new PaginationResultVO();
        }
        Integer count = bookMapper.selectErrorCountNumByUserList(userList);
        SimplePage page = new SimplePage(errorCountQuery.getPageNo(), count, pageSize);
        errorCountQuery.setSimplePage(page);
        List<Book> bookList = bookMapper.selectErrorCountByUserList(userList,errorCountQuery);
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

        PaginationResultVO<ErrorVO> resultVO = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), result);
        return resultVO;
    }


}

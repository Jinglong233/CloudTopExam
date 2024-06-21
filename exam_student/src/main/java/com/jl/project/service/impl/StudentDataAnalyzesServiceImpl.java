package com.jl.project.service.impl;

import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.query.TrainQuery;
import com.jl.project.entity.vo.LoginResponseVo;
import com.jl.project.mapper.ExamMapper;
import com.jl.project.mapper.ExamRecordMapper;
import com.jl.project.mapper.TrainMapper;
import com.jl.project.service.StudentDataAnalyzesService;
import com.jl.project.utils.UserInfoUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service("studentDataAnalyzesService")
public class StudentDataAnalyzesServiceImpl implements StudentDataAnalyzesService {

    @Resource
    private TrainMapper<Train, TrainQuery> trainMapper;

    @Resource
    private ExamRecordMapper<ExamRecord, ExamRecordQuery> examRecordMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Integer getTrainCount() {
        // 获取当前登录用户
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        TrainQuery trainQuery = new TrainQuery();
        trainQuery.setUserId(loginUserInfo.getId());
        trainQuery.setState(1);
        Integer count = trainMapper.selectCount(trainQuery);
        return count;
    }

    @Override
    public Integer getExamCount() {
        // 获取当前登录用户
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);
        ExamRecordQuery examRecordQuery = new ExamRecordQuery();
        examRecordQuery.setUserId(loginUserInfo.getId());
        Integer count = examRecordMapper.selectCount(examRecordQuery);
        return count;
    }

    @Override
    public Map<String, List> getMyRecentExam() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        LoginResponseVo loginUserInfo = UserInfoUtil.getLoginUserInfo(stringRedisTemplate);

        ExamQuery examQuery = null;
        Map<String, List> map = new HashMap<>();
        List<String> x = new ArrayList<>();

        // 添加X轴日期
        for (int i = 1; i <= 2; i++) {
            x.add(LocalDate.now().plusDays(i).toString());
            x.add(LocalDate.now().minusDays(i).toString());
        }
        x.add(LocalDate.now().toString());
        // 日期排序
        Collections.sort(x, (date1, date2) -> LocalDate.parse(date1).compareTo(LocalDate.parse(date2)));


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
            Integer temp = 0;
            if (examList != null && examList.size() != 0) {
                for (Exam exam : examList) {
                    // 判断该场考试，是否有该考生
                    ExamRecordQuery examRecordQuery = new ExamRecordQuery();
                    examRecordQuery.setExamId(exam.getId());
                    examRecordQuery.setUserId(loginUserInfo.getId());
                    Integer count = examRecordMapper.selectCount(examRecordQuery);
                    if (count > 0) {
                        temp++;
                    }
                }
            }
            data.add(temp);
        }
        map.put("data", data);
        return map;
    }
}

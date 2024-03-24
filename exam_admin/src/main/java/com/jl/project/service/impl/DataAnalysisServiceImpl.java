package com.jl.project.service.impl;

import com.jl.project.entity.po.Exam;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.query.UserQuery;
import com.jl.project.mapper.ExamMapper;
import com.jl.project.mapper.UserMapper;
import com.jl.project.service.DataAnalysisService;
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

    @Resource
    private UserMapper<User, UserQuery> userMapper;

    @Resource
    private ExamMapper<Exam, ExamQuery> examMapper;

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
        map.put("data",data);
        return map;
    }
}

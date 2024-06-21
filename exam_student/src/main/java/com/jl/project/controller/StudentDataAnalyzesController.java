package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.service.StudentDataAnalyzesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@SaCheckLogin
@SaCheckRole("student")
public class StudentDataAnalyzesController {

    @Resource
    private StudentDataAnalyzesService studentDataAnalyzesService;

    /**
     * 获取当前用户的训练次数
     *
     * @return
     */
    @RequestMapping("/trainCount")
    public SaResult getTrainCount() {
        Integer result = studentDataAnalyzesService.getTrainCount();
        return SaResult.ok().setData(result);
    }

    /**
     * 获取当前考试的次数
     *
     * @return
     */
    @RequestMapping("/examCount")
    public SaResult getExamCount() {
        Integer result = studentDataAnalyzesService.getExamCount();
        return SaResult.ok().setData(result);
    }


    /**
     * 获取自己最近考试的信息
     *
     * @return
     */
    @RequestMapping("/myRecentExam")
    public SaResult getMyRecentExam() {
        Map<String, List> result = studentDataAnalyzesService.getMyRecentExam();
        return SaResult.ok().setData(result);
    }
}

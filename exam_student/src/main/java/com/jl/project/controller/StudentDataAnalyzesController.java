package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.StudentDataAnalyzesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentDataAnalyzesController extends ABaseController {

    @Resource
    private StudentDataAnalyzesService studentDataAnalyzesService;

    /**
     * 获取当前用户的训练次数
     *
     * @return
     */
    @RequestMapping("/trainCount")
    @GlobalInterceptor(checkLogin = true, checkStudent = true)
    public ResponseVO getTrainCount() {
        Integer result = studentDataAnalyzesService.getTrainCount();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取当前考试的次数
     *
     * @return
     */
    @RequestMapping("/examCount")
    @GlobalInterceptor(checkLogin = true, checkStudent = true)
    public ResponseVO getExamCount() {
        Integer result = studentDataAnalyzesService.getExamCount();
        return getSuccessResponseVO(result);
    }


    /**
     * 获取自己最近考试的信息
     *
     * @return
     */
    @RequestMapping("/myRecentExam")
    @GlobalInterceptor(checkLogin = true, checkStudent = true)
    public ResponseVO getMyRecentExam() {
        Map<String, List> result = studentDataAnalyzesService.getMyRecentExam();
        return getSuccessResponseVO(result);
    }
}

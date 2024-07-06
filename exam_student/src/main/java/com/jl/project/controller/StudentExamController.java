package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.SubmitExamDTO;
import com.jl.project.entity.vo.ExamResultVO;
import com.jl.project.entity.vo.ExamVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description:学生考试Controller
 * @author:jingLong
 * @date:2023/11/12
 */
@Api(tags = "学生考试操作")
@RestController
@RequestMapping("/student")
@SaCheckLogin
@SaCheckRole("student")
public class StudentExamController {

    @Resource
    private StudentExamService studentExamService;

    /**
     * 根据学生Id查询考试列表
     */
    @ApiOperation("根据学生Id查询考试列表")
    @RequestMapping("loadStudentExamList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam(require = true) String userId) throws BusinessException {
        List<ExamVO> result = studentExamService.loadStudentExamList(userId);
        return SaResult.ok().setData(result);
    }

    /**
     * 提交试卷
     */
    @ApiOperation("提交试卷")
    @RequestMapping("submitExam")
    @GlobalInterceptor(checkParams = true)
    public SaResult submitExam(@RequestBody @VerifyParam SubmitExamDTO submitExamDTO) {
        Boolean result = studentExamService.submitExam(submitExamDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 回显考试结果
     */
    @ApiOperation("回显考试结果")
    @RequestMapping("examResult")
    @GlobalInterceptor(checkParams = true)
    public SaResult getExamResult(@RequestBody @VerifyParam(require = true) String examRecordId) {
        ExamResultVO result = studentExamService.getExamResult(examRecordId);
        return SaResult.ok().setData(result);
    }

}
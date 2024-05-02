package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.SubmitExamDTO;
import com.jl.project.entity.vo.ExamResultVO;
import com.jl.project.entity.vo.ExamVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentExamService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description:管理用户Service
 * @author:jingLong
 * @date:2023/11/12
 */
@RestController
@RequestMapping("/student")
public class StudentExamController extends ABaseController {

    @Resource
    private StudentExamService studentExamService;

    /**
     * 根据学生Id查询考试列表
     */
    @RequestMapping("loadStudentExamList")
    @GlobalInterceptor(checkLogin = true, checkParams = true, checkStudent = true)
    public ResponseVO loadDatalist(@RequestBody @VerifyParam(require = true) String userId) throws BusinessException {
        List<ExamVO> result = studentExamService.loadStudentExamList(userId);
        return getSuccessResponseVO(result);
    }

    /**
     * 提交试卷
     */
    @RequestMapping("submitExam")
    @GlobalInterceptor(checkLogin = true, checkParams = true, checkStudent = true)
    public ResponseVO submitExam(@RequestBody @VerifyParam SubmitExamDTO submitExamDTO) {
        Double result = studentExamService.submitExam(submitExamDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 回显考试结果
     */
    @RequestMapping("examResult")
    @GlobalInterceptor(checkLogin = true, checkParams = true, checkStudent = true)
    public ResponseVO getExamResult(@RequestBody @VerifyParam(require = true) String examRecordId) {
        ExamResultVO result = studentExamService.getExamResult(examRecordId);
        return getSuccessResponseVO(result);
    }

}
package com.jl.project.controller;

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
    public ResponseVO loadDatalist(@RequestBody String userId) throws BusinessException {
        List<ExamVO> result = studentExamService.loadStudentExamList(userId);
        return getSuccessResponseVO(result);
    }

    /**
     * 提交试卷
     */
    @RequestMapping("submitExam")
    public ResponseVO submitExam(@RequestBody SubmitExamDTO submitExamDTO) {
        Double result = null;
        try {
            result = studentExamService.submitExam(submitExamDTO);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 回显考试结果
     */
    @RequestMapping("examResult")
    public ResponseVO getExamResult(@RequestBody String examRecordId) {
        ExamResultVO result = null;
        try {
            result = studentExamService.getExamResult(examRecordId);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

}
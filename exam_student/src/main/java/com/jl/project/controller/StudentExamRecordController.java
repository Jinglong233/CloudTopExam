package com.jl.project.controller;

import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.StudentExamRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @Description:考试记录表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/student")
public class StudentExamRecordController extends ABaseController {

    @Resource
    private StudentExamRecordService studentExamRecordService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody ExamRecordQuery query) {
        List<ExamRecord> studentExamRecord = null;
        try {
            studentExamRecord = studentExamRecordService.getStudentExamRecord(query);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(studentExamRecord);
    }


    /**
     * 考生开始作答（这里只接收 userId 和 ExamId）
     */
    @RequestMapping("startAnswer")
    public ResponseVO startAnswer(@RequestBody ExamRecordQuery query) {
        Date result = null;
        try {
            result = studentExamRecordService.startAnswer(query);
        } catch (BusinessException e) {
            return getErrorResponseVO("考试失败，请联系管理员", e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result,"开始考试");
    }


}
package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.AnsweredRecordVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.StudentExamRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description:考试记录表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/student")
@SaCheckLogin
@SaCheckRole("student")
public class StudentExamRecordController{

    @Resource
    private StudentExamRecordService studentExamRecordService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam ExamRecordQuery query) {
        PaginationResultVO<ExamRecord> result = studentExamRecordService.getStudentExamRecord(query);
        return SaResult.ok().setData(result);
    }


    /**
     * 获取已经作答的考试记录
     *
     * @param userId
     * @return
     */
    @RequestMapping("getAnsweredRecord")
    @GlobalInterceptor(checkParams = true)
    public SaResult getAnsweredRecord(@RequestBody @VerifyParam(require = true) String userId) {
        List<AnsweredRecordVO> result =
                studentExamRecordService.getAnsweredRecord(userId);
        return SaResult.ok().setData(result);
    }


    /**
     * 考生开始作答（这里只接收 userId 和 ExamId）
     */
    @RequestMapping("startAnswer")
    @GlobalInterceptor(checkParams = true)
    public SaResult startAnswer(@RequestBody @VerifyParam ExamRecordQuery query) {
        Date result = studentExamRecordService.startAnswer(query);
        return SaResult.ok().setData(result);
    }


}
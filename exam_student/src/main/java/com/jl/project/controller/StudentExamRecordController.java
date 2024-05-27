package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.AnsweredRecordVO;
import com.jl.project.entity.vo.ResponseVO;
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
public class StudentExamRecordController extends ABaseController {

    @Resource
    private StudentExamRecordService studentExamRecordService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO loadDatalist(@RequestBody @VerifyParam ExamRecordQuery query) {
        return getSuccessResponseVO(studentExamRecordService.getStudentExamRecord(query));
    }


    /**
     * 获取已经作答的考试记录
     *
     * @param userId
     * @return
     */
    @RequestMapping("getAnsweredRecord")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getAnsweredRecord(@RequestBody @VerifyParam(require = true) String userId) {
        List<AnsweredRecordVO> resultVO =
                studentExamRecordService.getAnsweredRecord(userId);
        return getSuccessResponseVO(resultVO);
    }


    /**
     * 考生开始作答（这里只接收 userId 和 ExamId）
     */
    @RequestMapping("startAnswer")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO startAnswer(@RequestBody @VerifyParam ExamRecordQuery query) {
        Date result = studentExamRecordService.startAnswer(query);
        return getSuccessResponseVO(result);
    }


}
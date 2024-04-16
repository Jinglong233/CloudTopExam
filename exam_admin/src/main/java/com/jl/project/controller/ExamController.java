package com.jl.project.controller;

import com.jl.project.entity.dto.AddExamDTO;
import com.jl.project.entity.dto.UpdateExamDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.vo.*;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.ExamService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description:考试表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/exam")
public class ExamController extends ABaseController {

    @Resource
    private ExamService examService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public ResponseVO loadDatalist(@RequestBody ExamQuery query) throws BusinessException {
        PaginationResultVO<ExamVO> result = examService.loadDatalist(query);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据条件分页查询
     */
    @RequestMapping("getCorrectExamByParam")
    public ResponseVO getCorrectExamByParam(@RequestBody ExamQuery query) throws BusinessException {
        List<CorrectExamVO> result = null;
        try {
            result = examService.getCorrectExamByParam(query);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 获取批阅试卷
     */
    @RequestMapping("getCorrectExam")
    public ResponseVO getCorrectExam(@RequestBody ExamQuery examQuery) {

        PaginationResultVO<CorrectExamVO> result = null;
        try {
            result = examService.getCorrectExam(examQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 通过用户Id获取考试信息
     */
    @RequestMapping("getExamInfoByUserId")
    public ResponseVO getExamInfoByUserId(@RequestBody String userId) throws BusinessException {
        List<ExamVO> result = null;
        try {
            result = examService.getExamInfoByUserId(userId);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    public ResponseVO add(@RequestBody AddExamDTO addExamDTO) throws BusinessException {
        Boolean result = examService.add(addExamDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public ResponseVO addBatch(@RequestBody List<Exam> listBean) {
        return getSuccessResponseVO(this.examService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public ResponseVO addOrUpdateBatch(@RequestBody List<Exam> listBean) {
        return getSuccessResponseVO(this.examService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getExamById")
    public ResponseVO getExamById(@RequestBody String id) throws BusinessException {
        ExamVO result = examService.getExamById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateExamById")
    public ResponseVO updateExamById(@RequestBody UpdateExamDTO updateExamDTO) {
        Boolean result = examService.updateExamById(updateExamDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteExamById")
    public ResponseVO deleteExamById(@RequestBody String id) {
        Boolean result = examService.deleteExamById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取考试倒计时
     */
    @RequestMapping("getServerTime")
    public ResponseVO<Date> getServerTime() {
        Date result = null;
        try {
            result = examService.getServerTime();
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

    /**
     * 获取考试题目分析
     */
    @RequestMapping("getExamQuAnalyse")
    public ResponseVO getExamQuAnalyse(@RequestBody String examId) {
        List<WrongQuVO> result = null;
        try {
            result = examService.getExamQuAnalyse(examId);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }


    /**
     * 获取试卷题目分析
     */
    @RequestMapping("getPaperQuAnalyse")
    public ResponseVO getPaperQuAnalyse(@RequestBody String paperId) {
        List<WrongQuVO> result = null;
        try {
            result = examService.getPaperQuAnalyse(paperId);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }

}
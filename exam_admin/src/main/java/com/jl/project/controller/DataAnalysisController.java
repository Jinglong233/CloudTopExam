package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.query.ErrorCountQuery;
import com.jl.project.entity.vo.*;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.DataAnalysisService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataAnalysis")
public class DataAnalysisController extends ABaseController {

    @Resource
    private DataAnalysisService dataAnalysisService;


    /**
     * 获取知识点
     */
    @RequestMapping("knowledgeList")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO getKnowledgeList() {
        List<String> result = dataAnalysisService.getKnowledgeList();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取男女占比
     *
     * @return
     */
    @RequestMapping("sexProportion")
    @GlobalInterceptor(checkAdmin = true, checkLogin = true)
    public ResponseVO getSexProportion() {
        List<Map<String, Object>> result = dataAnalysisService.getSexProportion();
        return getSuccessResponseVO(result);
    }


    /**
     * 获取最近其他考试信息
     *
     * @return
     */
    @RequestMapping("recentExamInfo")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO getRecentExamInfo() {
        Map<String, List> result = dataAnalysisService.getRecentExamInfo();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取题目占比信息
     *
     * @return
     */
    @RequestMapping("quTypeProportion")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO getQuTypeProportion() {
        WrongDeptCommon result = dataAnalysisService.getQuTypeProportion();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取错题占比前五的知识点
     */
    @RequestMapping("topFiveWrongTopics")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO getTopFiveWrongTopics() {
        WrongDeptCommon result = dataAnalysisService.getTopFiveWrongTopics();
        return getSuccessResponseVO(result);
    }

    /**
     * 时间段错题分析统计
     */
    @RequestMapping("temporalErrorAnalysis")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO getTemporalErrorAnalysis() {
        WrongDeptCommon result = dataAnalysisService.getTemporalErrorAnalysis();
        return getSuccessResponseVO(result);
    }

    /**
     * 分类获取每个题型中每个知识点的错题统计
     */
    @RequestMapping("getWrongCountSummary")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true)
    public ResponseVO getWrongCountSummary() {
        List<WrongCountSummaryVO> result = dataAnalysisService.getWrongCountSummary();
        return getSuccessResponseVO(result);
    }


    /**
     * 根据部门获取知识点统计
     */
    @RequestMapping("wrongDeptWrongKn")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true,checkParams = true)
    public ResponseVO getWrongDeptWrongKn(@RequestBody @VerifyParam(require = true) String deptCode) {
        WrongDeptCommon result = dataAnalysisService.getWrongDeptWrongKn(deptCode);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据部门获取学科统计
     */
    @RequestMapping("wrongDeptSubject")
    @GlobalInterceptor(checkLogin = true, checkAdmin = true,checkParams = true)
    public ResponseVO getWrongDeptSubject(@RequestBody @VerifyParam(require = true) String deptCode) {
        WrongDeptCommon result = dataAnalysisService.getWrongDeptSubject(deptCode);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取部门错题统计
     *
     * @param errorCountQuery
     * @return
     */
    @RequestMapping("errorCount")
    @GlobalInterceptor(checkLogin = true,  checkParams = true)
    public ResponseVO errorCount(@RequestBody ErrorCountQuery errorCountQuery) {
        PaginationResultVO<ErrorVO> result = null;
        try {
            result = dataAnalysisService.errorCount(errorCountQuery);
        } catch (BusinessException e) {
            return getErrorResponseVO(null, e.getCode(), e.getMessage());
        }
        return getSuccessResponseVO(result);
    }




}

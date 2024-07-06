package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.query.ErrorCountQuery;
import com.jl.project.entity.vo.ErrorVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.WrongCountSummaryVO;
import com.jl.project.entity.vo.WrongDeptCommon;
import com.jl.project.service.DataAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataAnalysis")
@SaCheckLogin
@SaCheckRole("admin")
@Api(tags = "数据分析统计")
public class DataAnalysisController {

    @Resource
    private DataAnalysisService dataAnalysisService;


    /**
     * 获取知识点
     */
    @ApiOperation("获取知识点")
    @RequestMapping("knowledgeList")
    public SaResult getKnowledgeList() {
        List<String> result = dataAnalysisService.getKnowledgeList();
        return SaResult.ok().setData(result);
    }

    /**
     * 获取男女占比
     *
     * @return
     */
    @ApiOperation("获取男女占比")
    @RequestMapping("sexProportion")
    public SaResult getSexProportion() {
        List<Map<String, Object>> result = dataAnalysisService.getSexProportion();
        return SaResult.ok().setData(result);
    }


    /**
     * 获取最近其他考试信息
     *
     * @return
     */
    @ApiOperation("获取最近其他考试信息")
    @RequestMapping("recentExamInfo")
    public SaResult getRecentExamInfo() {
        Map<String, List> result = dataAnalysisService.getRecentExamInfo();
        return SaResult.ok().setData(result);
    }

    /**
     * 获取题目占比信息
     *
     * @return
     */
    @ApiOperation("获取题目占比信息")
    @RequestMapping("quTypeProportion")
    public SaResult getQuTypeProportion() {
        WrongDeptCommon result = dataAnalysisService.getQuTypeProportion();
        return SaResult.ok().setData(result);
    }

    /**
     * 获取错题占比前五的知识点
     */
    @ApiOperation("获取错题占比前五的知识点")
    @RequestMapping("topFiveWrongTopics")
    public SaResult getTopFiveWrongTopics() {
        WrongDeptCommon result = dataAnalysisService.getTopFiveWrongTopics();
        return SaResult.ok().setData(result);
    }

    /**
     * 时间段错题分析统计
     */
    @ApiOperation("时间段错题分析统计")
    @RequestMapping("temporalErrorAnalysis")
    public SaResult getTemporalErrorAnalysis() {
        WrongDeptCommon result = dataAnalysisService.getTemporalErrorAnalysis();
        return SaResult.ok().setData(result);
    }

    /**
     * 分类获取每个题型中每个知识点的错题统计
     */
    @ApiOperation("分类获取每个题型中每个知识点的错题统计")
    @RequestMapping("getWrongCountSummary")
    public SaResult getWrongCountSummary() {
        List<WrongCountSummaryVO> result = dataAnalysisService.getWrongCountSummary();
        return SaResult.ok().setData(result);
    }


    /**
     * 根据部门获取知识点统计
     */
    @ApiOperation("根据部门获取知识点统计")
    @RequestMapping("wrongDeptWrongKn")
    @GlobalInterceptor(checkParams = true)
    public SaResult getWrongDeptWrongKn(@RequestBody @VerifyParam(require = true) String deptCode) {
        WrongDeptCommon result = dataAnalysisService.getWrongDeptWrongKn(deptCode);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据部门获取学科统计
     */
    @ApiOperation("根据部门获取学科统计")
    @RequestMapping("wrongDeptSubject")
    @GlobalInterceptor(checkParams = true)
    public SaResult getWrongDeptSubject(@RequestBody @VerifyParam(require = true) String deptCode) {
        WrongDeptCommon result = dataAnalysisService.getWrongDeptSubject(deptCode);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取部门错题统计
     *
     * @param errorCountQuery
     * @return
     */
    @ApiOperation("获取部门错题统计")
    @RequestMapping("errorCount")
    @GlobalInterceptor(checkParams = true)
    public SaResult errorCount(@RequestBody ErrorCountQuery errorCountQuery) {
        PaginationResultVO<ErrorVO> result = dataAnalysisService.errorCount(errorCountQuery);
        return SaResult.ok().setData(result);
    }


}

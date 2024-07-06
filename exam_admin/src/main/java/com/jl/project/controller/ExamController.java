package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddExamDTO;
import com.jl.project.entity.dto.UpdateExamDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.vo.CorrectExamVO;
import com.jl.project.entity.vo.ExamVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.WrongQuVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.ExamService;
import com.jl.project.utils.QrCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * @Description:考试表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/exam")
@SaCheckLogin
@SaCheckRole("admin")
@Api(tags = "考试操作")
public class ExamController {

    @Resource
    private ExamService examService;
    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadExamList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadExamList(@RequestBody @VerifyParam ExamQuery query) throws BusinessException {
        PaginationResultVO<ExamVO> result = examService.loadExamList(query);
        return SaResult.ok().setData(result);
    }
    /**
     * 获取批阅考试
     */
    @ApiOperation("获取批阅考试")
    @RequestMapping("getCorrectExam")
    @GlobalInterceptor(checkParams = true)
    public SaResult getCorrectExam(@RequestBody @VerifyParam ExamQuery examQuery) throws BusinessException {
        PaginationResultVO<CorrectExamVO> result = examService.getCorrectExam(examQuery);
        return SaResult.ok().setData(result);

    }

    /**
     * 根据考试Id查询考试信息
     */
    @ApiOperation("根据考试Id查询考试信息")
    @RequestMapping("getExamById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getExamById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        ExamVO result = examService.getExamById(id);
        return SaResult.ok().setData(result);
    }
    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody @VerifyParam AddExamDTO addExamDTO) throws BusinessException {
        Boolean result = examService.add(addExamDTO);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateExamById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateExamById(@RequestBody @VerifyParam UpdateExamDTO updateExamDTO) {
        Boolean result = examService.updateExamById(updateExamDTO);
        return SaResult.ok().setData(result);

    }
    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteExamById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteExamById(@RequestBody @VerifyParam(require = true) String id) {
        Boolean result = examService.deleteExamById(id);
        return SaResult.ok().setData(result);

    }

    /**
     * 获取服务器时间
     */
    @ApiOperation("获取服务器时间")
    @RequestMapping("getServerTime")
    public SaResult getServerTime() {
        Date result = examService.getServerTime();
        return SaResult.ok().setData(result);
    }
    /**
     * 获取考试题目分析
     */
    @ApiOperation("获取考试题目分析")
    @RequestMapping("getExamQuAnalyse")
    @GlobalInterceptor(checkParams = true)
    public SaResult getExamQuAnalyse(@RequestBody @VerifyParam(require = true) String examId) {
        List<WrongQuVO> result = examService.getExamQuAnalyse(examId);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取试卷题目分析
     */
    @ApiOperation("获取试卷题目分析")
    @RequestMapping("getPaperQuAnalyse")
    @GlobalInterceptor(checkParams = true)
    public SaResult getPaperQuAnalyse(@RequestBody @VerifyParam(require = true) String paperId) throws BusinessException {
        List<WrongQuVO> result = examService.getPaperQuAnalyse(paperId);
        return SaResult.ok().setData(result);
    }

    /**
     * 生成考试二维码
     *
     * @param examId 生成考试二维码Id
     * @param response
     * @return
     */
    @ApiOperation("")
    @RequestMapping("/qrcode/{examId}")
    @GlobalInterceptor(checkParams = true)
    public SaResult qrcode(@PathVariable(name = "examId") @VerifyParam(require = true) String examId, HttpServletResponse response) throws Exception {
        String requestUrl = examId;
        OutputStream os = response.getOutputStream();
        QrCodeUtil.encode(requestUrl, null, os);
        return SaResult.ok();
    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<Exam> listBean) {
        Integer result = this.examService.addBatch(listBean);
        return SaResult.ok().setData(result);
    }
    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<Exam> listBean) {
        Integer result = this.examService.addOrUpdateBatch(listBean);
        return SaResult.ok().setData(result);
    }

}
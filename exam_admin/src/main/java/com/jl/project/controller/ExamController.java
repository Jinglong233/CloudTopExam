package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddExamDTO;
import com.jl.project.entity.dto.UpdateExamDTO;
import com.jl.project.entity.po.Exam;
import com.jl.project.entity.query.ExamQuery;
import com.jl.project.entity.vo.*;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.ExamService;
import com.jl.project.utils.QrCodeUtil;
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
public class ExamController extends ABaseController {

    @Resource
    private ExamService examService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadExamList")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO loadExamList(@RequestBody @VerifyParam ExamQuery query) throws BusinessException {
        PaginationResultVO<ExamVO> result = examService.loadExamList(query);
        return getSuccessResponseVO(result);
    }

    /**
     * 获取批阅考试
     */
    @RequestMapping("getCorrectExam")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getCorrectExam(@RequestBody @VerifyParam ExamQuery examQuery) throws BusinessException {
        PaginationResultVO<CorrectExamVO> result = examService.getCorrectExam(examQuery);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据考试Id查询考试信息
     */
    @RequestMapping("getExamById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getExamById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        ExamVO result = examService.getExamById(id);
        return getSuccessResponseVO(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO add(@RequestBody @VerifyParam AddExamDTO addExamDTO) throws BusinessException {
        Boolean result = examService.add(addExamDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id更新
     */
    @RequestMapping("updateExamById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO updateExamById(@RequestBody @VerifyParam UpdateExamDTO updateExamDTO) {
        Boolean result = examService.updateExamById(updateExamDTO);
        return getSuccessResponseVO(result);
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteExamById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO deleteExamById(@RequestBody @VerifyParam(require = true) String id) {
        Boolean result = examService.deleteExamById(id);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取服务器时间
     */
    @RequestMapping("getServerTime")
    @GlobalInterceptor(checkLogin = true)
    public ResponseVO<Date> getServerTime() {
        Date result = examService.getServerTime();
        return getSuccessResponseVO(result);
    }

    /**
     * 获取考试题目分析
     */
    @RequestMapping("getExamQuAnalyse")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getExamQuAnalyse(@RequestBody @VerifyParam(require = true) String examId) {
        List<WrongQuVO> result = examService.getExamQuAnalyse(examId);
        return getSuccessResponseVO(result);
    }


    /**
     * 获取试卷题目分析
     */
    @RequestMapping("getPaperQuAnalyse")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getPaperQuAnalyse(@RequestBody @VerifyParam(require = true) String paperId) throws BusinessException {
        List<WrongQuVO> result = examService.getPaperQuAnalyse(paperId);
        return getSuccessResponseVO(result);
    }


    /**
     * 生成考试二维码
     *
     * @param examId
     * @param response
     * @return
     */
    @RequestMapping("/qrcode/{examId}")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO qrcode(@PathVariable(name = "examId") @VerifyParam(require = true) String examId, HttpServletResponse response) throws Exception {
        String requestUrl = examId;
        OutputStream os = response.getOutputStream();
        QrCodeUtil.encode(requestUrl, null, os);
        return getSuccessResponseVO(null);
    }

//    下面接口未测试


    /**
     * 根据参数获取批阅考试
     */
    /*@RequestMapping("getCorrectExamByParam")
    @GlobalInterceptor(checkLogin = true,checkParams = true)
    public ResponseVO getCorrectExamByParam(@RequestBody @VerifyParam ExamQuery query) throws BusinessException {
        List<CorrectExamVO> result = examService.getCorrectExamByParam(query);
        return getSuccessResponseVO(result);
    }*/

    /**
     * 通过用户Id获取考试信息
     */
  /*  @RequestMapping("getExamInfoByUserId")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getExamInfoByUserId(@RequestBody @VerifyParam(require = true) String userId) throws BusinessException {
        List<ExamVO> result = examService.getExamInfoByUserId(userId);
        return getSuccessResponseVO(result);
    }*/

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

}
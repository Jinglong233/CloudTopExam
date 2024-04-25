package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.UpdateExamRecordDTO;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.CorrectUserExamUserVO;
import com.jl.project.entity.vo.ExamRecordVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.ExamRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:考试记录表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/examRecord")
public class ExamRecordController extends ABaseController {

    @Resource
    private ExamRecordService examRecordService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO loadDatalist(@RequestBody @VerifyParam ExamRecordQuery query) throws BusinessException {
        PaginationResultVO<ExamRecordVO> result = examRecordService.loadDatalist(query);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据考试Id获取考试记录
     */
    @RequestMapping("getExamRecordByExamId")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getExamRecordByExamId(@RequestBody ExamRecordQuery examRecordQuery) throws BusinessException{
        PaginationResultVO<CorrectUserExamUserVO> result =  examRecordService.getExamRecordByExamId(examRecordQuery);
        return getSuccessResponseVO(result);
    }


    /**
     * 根据Id更新
     */
    @RequestMapping("updateExamRecordById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO updateExamRecordById(@RequestBody @VerifyParam UpdateExamRecordDTO updateExamRecordDTO)throws BusinessException {
        Boolean result =  examRecordService.updateExamRecordById(updateExamRecordDTO);
        return getSuccessResponseVO(result);
    }


    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO add(@RequestBody ExamRecord bean)throws BusinessException {
        return getSuccessResponseVO(examRecordService.add(bean));
    }



    /**
     * 根据Id查询
     */

    @RequestMapping("getExamRecordById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO getExamRecordById(@RequestBody @VerifyParam(require = true) String id) {
        return getSuccessResponseVO(this.examRecordService.getExamRecordById(id));
    }


    /**
     * 根据Id删除
     */
    @RequestMapping("deleteExamRecordById")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO deleteExamRecordById(@RequestBody @VerifyParam(require = true) String id) {
        this.examRecordService.deleteExamRecordById(id);
        return getSuccessResponseVO(null);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO addBatch(@RequestBody List<ExamRecord> listBean) {
        return getSuccessResponseVO(this.examRecordService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkLogin = true, checkParams = true)
    public ResponseVO addOrUpdateBatch(@RequestBody List<ExamRecord> listBean) {
        return getSuccessResponseVO(this.examRecordService.addOrUpdateBatch(listBean));
    }


}
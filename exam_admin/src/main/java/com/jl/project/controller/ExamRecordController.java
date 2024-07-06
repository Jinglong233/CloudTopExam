package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.UpdateExamRecordDTO;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.CorrectUserExamUserVO;
import com.jl.project.entity.vo.ExamRecordVO;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.ExamRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@SaCheckLogin
@SaCheckRole("admin")
@Api(tags = "考试记录")
public class ExamRecordController {

    @Resource
    private ExamRecordService examRecordService;


    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam ExamRecordQuery query) throws BusinessException {
        PaginationResultVO<ExamRecordVO> result = examRecordService.loadDatalist(query);
        return SaResult.ok().setData(result);
    }



    /**
     * 根据考试Id获取考试记录
     */
    @ApiOperation("根据考试Id获取考试记录")
    @RequestMapping("getExamRecordByExamId")
    @GlobalInterceptor(checkParams = true)
    public SaResult getExamRecordByExamId(@RequestBody ExamRecordQuery examRecordQuery) throws BusinessException {
        PaginationResultVO<CorrectUserExamUserVO> result = examRecordService.getExamRecordByExamId(examRecordQuery);
        return SaResult.ok().setData(result);
    }



    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateExamRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateExamRecordById(@RequestBody @VerifyParam UpdateExamRecordDTO updateExamRecordDTO) throws BusinessException {
        Boolean result = examRecordService.updateExamRecordById(updateExamRecordDTO);
        return SaResult.ok().setData(result);
    }



    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody ExamRecord bean) throws BusinessException {
        Integer result = examRecordService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败");
    }



    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getExamRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getExamRecordById(@RequestBody @VerifyParam(require = true) String id) {
        ExamRecord result = this.examRecordService.getExamRecordById(id);
        return SaResult.ok().setData(result);
    }



    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteExamRecordById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteExamRecordById(@RequestBody @VerifyParam(require = true) String id) {
        Integer result = this.examRecordService.deleteExamRecordById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }


    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<ExamRecord> listBean) {
        Integer result = this.examRecordService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败");
    }


    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<ExamRecord> listBean) {
        Integer result = this.examRecordService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/修改成功" : "批量添加/修改失败");

    }


}
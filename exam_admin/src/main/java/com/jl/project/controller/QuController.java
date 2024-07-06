package com.jl.project.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.OperationLog;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddQuAndAnswerDTO;
import com.jl.project.entity.dto.RandomSelectQuDTO;
import com.jl.project.entity.dto.UpdateQuAndAnswerDTO;
import com.jl.project.entity.po.Qu;
import com.jl.project.entity.query.QuExcludeQuery;
import com.jl.project.entity.query.QuQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.QuAndAnswerVo;
import com.jl.project.enums.LogType;
import com.jl.project.enums.OperationType;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.QuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:题目表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@Api(tags = "题目操作")
@RestController
@RequestMapping("/qu")
@SaCheckLogin
@SaCheckRole("admin")
public class QuController {

    @Resource
    private QuService quService;

    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadQuList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadQuList(@RequestBody @VerifyParam QuQuery query) {
        PaginationResultVO<Qu> result = quService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取题目+选项列表
     */
    @ApiOperation("获取题目+选项列表")
    @RequestMapping("loadQuAndAnswerList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadQuAndAnswerList(@RequestBody QuQuery query) throws BusinessException {
        List<QuAndAnswerVo> result = quService.loadQuAndAnswerList(query);
        return SaResult.ok().setData(result);
    }


    /**
     * 过滤指定题目之后的题目和选项列表
     *
     * @param query
     * @return
     * @throws BusinessException
     */
    @ApiOperation("过滤指定题目之后的题目和选项列表")
    @RequestMapping("loadExcludeQuAnAnswerList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadExcludeQuAnAnswerList(@RequestBody @VerifyParam QuExcludeQuery query) throws BusinessException {
        PaginationResultVO<QuAndAnswerVo> result = quService.loadExcludeQuAnAnswerList(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增题目和选项
     */
    @ApiOperation("新增题目和选项")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    @OperationLog(logType = LogType.OPERATION_LOG, oper = OperationType.ADD)
    public SaResult add(@RequestBody @VerifyParam AddQuAndAnswerDTO bean) throws BusinessException {
        Boolean result = quService.add(bean);
        return SaResult.ok(result ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 根据题目Id更新题目和关联选项
     */
    @ApiOperation("根据题目Id更新题目和关联选项")
    @RequestMapping("updateQuById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateQuById(@RequestBody @VerifyParam UpdateQuAndAnswerDTO bean) throws BusinessException {
        Boolean result = quService.updateQuById(bean);
        return SaResult.ok().setData(result);
    }

    /**
     * 随机抽题题目
     */
    @ApiOperation("随机抽题题目")
    @RequestMapping("randomSelectQu")
    @GlobalInterceptor(checkParams = true)
    public SaResult randomSelectQu(@RequestBody @VerifyParam RandomSelectQuDTO selectQuDTO) throws BusinessException {
        List<QuAndAnswerVo> result = quService.randomSelectQu(selectQuDTO);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据Id查询题目和对应选项的信息
     */
    @ApiOperation("根据Id查询题目和对应选项的信息")
    @RequestMapping("getQuById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getQuById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        QuAndAnswerVo result = quService.getQuById(id);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteQuById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteQuById(@RequestBody @VerifyParam(require = true) String id) throws BusinessException {
        Boolean result = quService.deleteQuById(id);
        return SaResult.ok(result ? "删除成功" : "删除失败");
    }


    /**
     * 获取题目数量
     */
    @ApiOperation("获取题目数量")
    @RequestMapping("quCount")
    @GlobalInterceptor(checkParams = true)
    public SaResult getQuCount(@RequestBody @VerifyParam QuQuery query) throws BusinessException {
        Integer result = quService.getQuCount(query);
        return SaResult.ok().setData(result);
    }


    /**
     * 导出
     */
    @ApiOperation("导出")
    @RequestMapping("export")
    @GlobalInterceptor(checkParams = true)
    public void getQuCount(HttpServletResponse response) throws BusinessException, IOException {
        quService.export(response);
    }

    /**
     * 批量导入
     */
    @ApiOperation("批量导入")
    @RequestMapping("importQu")
    @GlobalInterceptor(checkParams = true)
    public SaResult importQuestions(@RequestPart("file") MultipartFile file, @RequestPart("repoId") String repoId) throws BusinessException, IOException {
        Boolean result = quService.importQuestions(file, repoId);
        return SaResult.ok(result ? "导出成功" : "导出失败");
    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<Qu> listBean) {
        Integer result = this.quService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }


    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<Qu> listBean) {
        Integer result = this.quService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }


}
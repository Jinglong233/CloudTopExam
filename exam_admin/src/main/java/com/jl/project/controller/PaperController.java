package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.dto.AddPaperDTO;
import com.jl.project.entity.dto.UpdatePaperAndQuDTO;
import com.jl.project.entity.po.Paper;
import com.jl.project.entity.query.PaperQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.vo.PaperAndQuVO;
import com.jl.project.exception.BusinessException;
import com.jl.project.service.PaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:试卷表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@Api(tags = "试卷操作")
@RestController
@RequestMapping("/paper")
@SaCheckLogin
@SaCheckRole("admin")
public class PaperController {

    @Resource
    private PaperService paperService;

    /**
     * 根据Id查询试卷详细信息
     */
    @ApiOperation("根据Id查询试卷详细信息")
    @RequestMapping("getPaperDetailById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getPaperDetailById(@RequestBody @VerifyParam(require = true) String id) {
        PaperAndQuVO result = paperService.getPaperDetailById(id);
        return SaResult.ok().setData(result);
    }


    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updatePaperById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updatePaperById(@RequestBody @VerifyParam UpdatePaperAndQuDTO bean) throws BusinessException {
        Boolean result = paperService.updatePaperById(bean);
        return SaResult.ok(result ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deletePaperById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deletePaperById(@RequestBody @VerifyParam(require = true) String id) {
        Boolean result = paperService.deletePaperById(id);
        return SaResult.ok(result ? "删除成功" : "删除失败");
    }


    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody AddPaperDTO paperDTO) throws BusinessException {
        Boolean result = paperService.add(paperDTO);
        return SaResult.ok(result ? "添加成功" : "添加失败").setData(result);
    }


    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody PaperQuery query) throws BusinessException {
        PaginationResultVO<Paper> result = paperService.loadDatalist(query);
        return SaResult.ok().setData(result);
    }


    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<Paper> listBean) {
        Integer result = this.paperService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<Paper> listBean) {
        Integer result = this.paperService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getPaperById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getPaperById(@RequestBody @VerifyParam(require = true) String id) {
        Paper result = this.paperService.getPaperById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 获取试卷总数
     */
    @ApiOperation("获取试卷总数")
    @RequestMapping("paperCount")
    @GlobalInterceptor(checkParams = true)
    public SaResult getPaperCount(@RequestBody PaperQuery paperQuery) throws BusinessException {
        Integer result = paperService.getPaperCount(paperQuery);
        return SaResult.ok().setData(result);
    }


}
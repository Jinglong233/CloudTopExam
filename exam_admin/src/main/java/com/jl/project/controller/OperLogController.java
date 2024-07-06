package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.OperLog;
import com.jl.project.entity.query.OperLogQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.OperLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:操作日志表Controller
 * @author:jingLong
 * @date:2024/05/13
 */
@RestController
@RequestMapping("/operLog")
@SaCheckLogin
@SaCheckRole("admin")
@Api(tags = "操作日志")
public class OperLogController {

    @Resource
    private OperLogService operLogService;

    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor( checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam(require = true) OperLogQuery query) {
        PaginationResultVO<OperLog> result = operLogService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    public SaResult add(OperLog bean) {
        Integer result = this.operLogService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<OperLog> listBean) {
        Integer result = this.operLogService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<OperLog> listBean) {
        Integer result = this.operLogService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);
    }


    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getOperLogById")
    public SaResult getOperLogById(Integer id) {
        OperLog result = this.operLogService.getOperLogById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateOperLogById")
    public SaResult updateOperLogById(OperLog bean, Integer id) {
        Integer result = this.operLogService.updateOperLogById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteOperLogById")
    public SaResult deleteOperLogById(Integer id) {
        Integer result = this.operLogService.deleteOperLogById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}
package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.Tmpl;
import com.jl.project.entity.query.TmplQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.TmplService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:消息模板表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/tmpl")
@SaCheckLogin
@SaCheckRole("admin")
@Api(tags = "消息模板")
public class TmplController {

    @Resource
    private TmplService tmplService;

    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(TmplQuery query) {
        PaginationResultVO<Tmpl> result = tmplService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(Tmpl bean) {
        Integer result = this.tmplService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<Tmpl> listBean) {
        Integer result = this.tmplService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<Tmpl> listBean) {
        Integer result = this.tmplService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getTmplById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getTmplById(String id) {
        Tmpl result = this.tmplService.getTmplById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateTmplById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateTmplById(Tmpl bean, String id) {
        Integer result = this.tmplService.updateTmplById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");

    }

    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteTmplById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteTmplById(String id) {
        Integer result = this.tmplService.deleteTmplById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}
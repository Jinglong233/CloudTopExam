package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.GlQu;
import com.jl.project.entity.query.GlQuQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.GlQuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:大题题目关联表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/glQu")
@SaCheckLogin
@SaCheckRole("admin")
public class GlQuController {

    @Resource
    private GlQuService glQuService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(GlQuQuery query) {
        PaginationResultVO<GlQu> result = glQuService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(GlQu bean) {
        Integer result = this.glQuService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<GlQu> listBean) {
        Integer result = this.glQuService.addBatch(listBean);

        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<GlQu> listBean) {
        Integer result = this.glQuService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getGlQuById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getGlQuById(String id) {
        GlQu result = this.glQuService.getGlQuById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateGlQuById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateGlQuById(GlQu bean, String id) {
        Integer result = this.glQuService.updateGlQuById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteGlQuById")
    public SaResult deleteGlQuById(String id) {
        Integer result = this.glQuService.deleteGlQuById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}
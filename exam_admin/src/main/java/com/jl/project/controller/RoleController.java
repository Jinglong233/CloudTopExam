package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.Role;
import com.jl.project.entity.query.RoleQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:角色表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@Api(tags = "角色操作")
@RestController
@RequestMapping("/role")
@SaCheckLogin
@SaCheckRole("admin")
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 根据条件分页查询
     */
    @ApiOperation("根据条件分页查询")
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody RoleQuery query) {
        PaginationResultVO<Role> result = roleService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @ApiOperation("新增")
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(@RequestBody Role bean) {
        Integer result = this.roleService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);

    }

    /**
     * 批量新增
     */
    @ApiOperation("批量新增")
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<Role> listBean) {
        Integer result = this.roleService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @ApiOperation("批量新增或修改")
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<Role> listBean) {
        Integer result = this.roleService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */
    @ApiOperation("根据Id查询")
    @RequestMapping("getRoleById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getRoleById(@RequestBody @VerifyParam(require = true) String id) {
        Role result = this.roleService.getRoleById(id);
        return SaResult.ok().setData(result);

    }

    /**
     * 根据Id更新
     */
    @ApiOperation("根据Id更新")
    @RequestMapping("updateRoleById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateRoleById(Role bean, String id) {
        Integer result = this.roleService.updateRoleById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @ApiOperation("根据Id删除")
    @RequestMapping("deleteRoleById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteRoleById(String id) {
        Integer result = this.roleService.deleteRoleById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}
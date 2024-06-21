package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.LoginLog;
import com.jl.project.entity.query.LoginLogQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.LoginLogService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:登录日志表Controller
 * @author:jingLong
 * @date:2024/05/13
 */
@RestController
@RequestMapping("/loginLog")
@SaCheckLogin
@SaCheckRole("admin")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(@RequestBody @VerifyParam(require = true) LoginLogQuery query) {
        PaginationResultVO<LoginLog> result = loginLogService.findListByPage(query);
        return SaResult.ok().setData(result);

    }


    /**
     * 批量删除
     */
    @RequestMapping("deleteBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteLoginLogBatchById(@RequestBody List<Integer> deleteList) {
        Boolean result = loginLogService.deleteLoginLogBatchById(deleteList);
        return SaResult.ok(result ? "批量删除成功" : "批量删除失败");
    }


    /**
     * 新增
     */
    @RequestMapping("add")
    public SaResult add(LoginLog bean) {
        Integer result = this.loginLogService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<LoginLog> listBean) {
        Integer result = this.loginLogService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<LoginLog> listBean) {
        Integer result = this.loginLogService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);

    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getLoginLogById")
    public SaResult getLoginLogById(Integer id) {
        LoginLog result = this.loginLogService.getLoginLogById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateLoginLogById")
    public SaResult updateLoginLogById(LoginLog bean, Integer id) {
        Integer result = this.loginLogService.updateLoginLogById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteLoginLogById")
    public SaResult deleteLoginLogById(@RequestBody Integer id) {
        Integer result = this.loginLogService.deleteLoginLogById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}
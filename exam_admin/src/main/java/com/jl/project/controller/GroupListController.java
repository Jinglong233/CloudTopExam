package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.entity.po.GroupList;
import com.jl.project.entity.query.GroupListQuery;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.service.GroupListService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:大题表Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/groupList")
@SaCheckLogin
@SaCheckRole("admin")
public class GroupListController {

    @Resource
    private GroupListService groupListService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    @GlobalInterceptor(checkParams = true)
    public SaResult loadDatalist(GroupListQuery query) {
        PaginationResultVO<GroupList> result = groupListService.findListByPage(query);
        return SaResult.ok().setData(result);
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    @GlobalInterceptor(checkParams = true)
    public SaResult add(GroupList bean) {
        Integer result = this.groupListService.add(bean);
        return SaResult.ok(result > 0 ? "添加成功" : "添加失败").setData(result);
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addBatch(@RequestBody List<GroupList> listBean) {
        Integer result = this.groupListService.addBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加成功" : "批量添加失败").setData(result);

    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    @GlobalInterceptor(checkParams = true)
    public SaResult addOrUpdateBatch(@RequestBody List<GroupList> listBean) {
        Integer result = this.groupListService.addOrUpdateBatch(listBean);
        return SaResult.ok(result > 0 ? "批量添加/更新成功" : "批量添加/更新失败").setData(result);
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getGroupListById")
    @GlobalInterceptor(checkParams = true)
    public SaResult getGroupListById(String id) {
        GroupList result = this.groupListService.getGroupListById(id);
        return SaResult.ok().setData(result);
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateGroupListById")
    @GlobalInterceptor(checkParams = true)
    public SaResult updateGroupListById(GroupList bean, String id) {
        Integer result = this.groupListService.updateGroupListById(bean, id);
        return SaResult.ok(result > 0 ? "更新成功" : "更新失败");

    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteGroupListById")
    @GlobalInterceptor(checkParams = true)
    public SaResult deleteGroupListById(String id) {
        Integer result = this.groupListService.deleteGroupListById(id);

        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");

    }

}
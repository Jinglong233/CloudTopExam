package com.jl.project.controller;

import com.jl.project.annotation.GlobalInterceptor;
import com.jl.project.annotation.VerifyParam;
import com.jl.project.entity.po.Role;
import com.jl.project.entity.query.RoleQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.RoleService;
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
@RestController
@RequestMapping("/role")
public class RoleController extends ABaseController{

	@Resource
	private RoleService roleService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO loadDatalist(@RequestBody RoleQuery query) {
		return getSuccessResponseVO(roleService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO add(@RequestBody Role bean) {
		return getSuccessResponseVO(this.roleService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO addBatch(@RequestBody List<Role> listBean) {
		return getSuccessResponseVO(this.roleService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO addOrUpdateBatch(@RequestBody List<Role> listBean) {
		return getSuccessResponseVO(this.roleService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getRoleById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO getRoleById(@RequestBody @VerifyParam(require = true) String id) {
		return getSuccessResponseVO(this.roleService.getRoleById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateRoleById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO updateRoleById(Role bean, String id) {
		return getSuccessResponseVO(this.roleService.updateRoleById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteRoleById")
	@GlobalInterceptor(checkLogin = true,checkAdmin = true,checkParams = true)
	public ResponseVO deleteRoleById(String id) {
		this.roleService.deleteRoleById(id);
		return getSuccessResponseVO(null);
	}

}
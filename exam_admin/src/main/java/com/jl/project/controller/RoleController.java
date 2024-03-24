package com.jl.project.controller;

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
	public ResponseVO loadDatalist(RoleQuery query) {
		return getSuccessResponseVO(roleService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(Role bean) {
		return getSuccessResponseVO(this.roleService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<Role> listBean) {
		return getSuccessResponseVO(this.roleService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Role> listBean) {
		return getSuccessResponseVO(this.roleService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getRoleById")
	public ResponseVO getRoleById(String id) {
		return getSuccessResponseVO(this.roleService.getRoleById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateRoleById")
	public ResponseVO updateRoleById(Role bean, String id) {
		return getSuccessResponseVO(this.roleService.updateRoleById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteRoleById")
	public ResponseVO deleteRoleById(String id) {
		this.roleService.deleteRoleById(id);
		return getSuccessResponseVO(null);
	}

}
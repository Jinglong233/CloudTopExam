package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Role;
import com.jl.project.entity.query.RoleQuery;

import java.util.List;
/**
 * @Description:角色表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface RoleService {

	/**
	 * 根据条件查询列表
	 */
	List<Role> findListByParam(RoleQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(RoleQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Role> findListByPage(RoleQuery query);

	/**
	 * 新增
	 */
	Integer add(Role bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Role> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Role> listBean);

	/**
	 * 根据Id查询
	 */
	Role getRoleById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateRoleById(Role bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteRoleById(String id);

}
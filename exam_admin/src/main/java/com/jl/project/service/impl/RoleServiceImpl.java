package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Role;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.RoleQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.RoleMapper;
import com.jl.project.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:角色表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper<Role,RoleQuery> roleMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Role> findListByParam(RoleQuery query) {
		return this.roleMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(RoleQuery query) {
		return this.roleMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Role> findListByPage(RoleQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Role> list = this.findListByParam(query);
		PaginationResultVO<Role> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Role bean) {
		return this.roleMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Role> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.roleMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Role> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.roleMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Role getRoleById(String id) {
		return this.roleMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateRoleById(Role bean, String id) {
		return this.roleMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteRoleById(String id) {
		return this.roleMapper.deleteById(id);
	}

}
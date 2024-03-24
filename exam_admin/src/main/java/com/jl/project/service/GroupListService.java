package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.GroupList;
import com.jl.project.entity.query.GroupListQuery;

import java.util.List;
/**
 * @Description:大题表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface GroupListService {

	/**
	 * 根据条件查询列表
	 */
	List<GroupList> findListByParam(GroupListQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(GroupListQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<GroupList> findListByPage(GroupListQuery query);

	/**
	 * 新增
	 */
	Integer add(GroupList bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<GroupList> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<GroupList> listBean);

	/**
	 * 根据Id查询
	 */
	GroupList getGroupListById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateGroupListById(GroupList bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteGroupListById(String id);

}
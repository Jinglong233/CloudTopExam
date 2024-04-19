package com.jl.project.service.impl;

import com.jl.project.entity.po.GroupList;
import com.jl.project.entity.query.GroupListQuery;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.GroupListMapper;
import com.jl.project.service.GroupListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:大题表Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("groupListService")
public class GroupListServiceImpl implements GroupListService {

	@Resource
	private GroupListMapper<GroupList,GroupListQuery> groupListMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<GroupList> findListByParam(GroupListQuery query) {
		return this.groupListMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(GroupListQuery query) {
		return this.groupListMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<GroupList> findListByPage(GroupListQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<GroupList> list = this.findListByParam(query);
		PaginationResultVO<GroupList> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(GroupList bean) {
		return this.groupListMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<GroupList> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.groupListMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<GroupList> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.groupListMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public GroupList getGroupListById(String id) {
		return this.groupListMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateGroupListById(GroupList bean, String id) {
		return this.groupListMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteGroupListById(String id) {
		return this.groupListMapper.deleteById(id);
	}

}
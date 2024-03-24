package com.jl.project.controller;

import com.jl.project.entity.po.GroupList;
import com.jl.project.entity.query.GroupListQuery;
import com.jl.project.entity.vo.ResponseVO;
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
public class GroupListController extends ABaseController{

	@Resource
	private GroupListService groupListService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(GroupListQuery query) {
		return getSuccessResponseVO(groupListService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(GroupList bean) {
		return getSuccessResponseVO(this.groupListService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<GroupList> listBean) {
		return getSuccessResponseVO(this.groupListService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<GroupList> listBean) {
		return getSuccessResponseVO(this.groupListService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getGroupListById")
	public ResponseVO getGroupListById(String id) {
		return getSuccessResponseVO(this.groupListService.getGroupListById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateGroupListById")
	public ResponseVO updateGroupListById(GroupList bean, String id) {
		return getSuccessResponseVO(this.groupListService.updateGroupListById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteGroupListById")
	public ResponseVO deleteGroupListById(String id) {
		this.groupListService.deleteGroupListById(id);
		return getSuccessResponseVO(null);
	}

}
package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.MsgUser;
import com.jl.project.entity.query.MsgUserQuery;

import java.util.List;
/**
 * @Description:用户消息关联表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface MsgUserService {

	/**
	 * 根据条件查询列表
	 */
	List<MsgUser> findListByParam(MsgUserQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(MsgUserQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<MsgUser> findListByPage(MsgUserQuery query);

	/**
	 * 新增
	 */
	Integer add(MsgUser bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<MsgUser> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<MsgUser> listBean);

	/**
	 * 根据Id查询
	 */
	MsgUser getMsgUserById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateMsgUserById(MsgUser bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteMsgUserById(String id);

}
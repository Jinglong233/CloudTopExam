package com.jl.project.service;

;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Msg;
import com.jl.project.entity.query.MsgQuery;

import java.util.List;
/**
 * @Description:消息表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface MsgService {

	/**
	 * 根据条件查询列表
	 */
	List<Msg> findListByParam(MsgQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(MsgQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Msg> findListByPage(MsgQuery query);

	/**
	 * 新增
	 */
	Integer add(Msg bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Msg> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Msg> listBean);

	/**
	 * 根据Id查询
	 */
	Msg getMsgById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateMsgById(Msg bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteMsgById(String id);

}
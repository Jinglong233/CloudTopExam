package com.jl.project.service;

import com.jl.project.entity.po.OperLog;
import com.jl.project.entity.query.OperLogQuery;
import com.jl.project.entity.vo.PaginationResultVO;

import java.util.List;

;
/**
 * @Description:操作日志表Service
 * @author:jingLong
 * @date:2024/05/08
 */
public interface OperLogService {

	/**
	 * 根据条件查询列表
	 */
	List<OperLog> findListByParam(OperLogQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(OperLogQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<OperLog> findListByPage(OperLogQuery query);

	/**
	 * 新增
	 */
	Integer add(OperLog bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<OperLog> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<OperLog> listBean);

	/**
	 * 根据Id查询
	 */
	OperLog getOperLogById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateOperLogById(OperLog bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteOperLogById(Integer id);

}
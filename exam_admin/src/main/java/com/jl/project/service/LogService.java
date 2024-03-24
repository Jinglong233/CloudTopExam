package com.jl.project.service;

;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Log;
import com.jl.project.entity.query.LogQuery;

import java.util.List;
/**
 * @Description:日志表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface LogService {

	/**
	 * 根据条件查询列表
	 */
	List<Log> findListByParam(LogQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(LogQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Log> findListByPage(LogQuery query);

	/**
	 * 新增
	 */
	Integer add(Log bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Log> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Log> listBean);

	/**
	 * 根据Id查询
	 */
	Log getLogById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateLogById(Log bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteLogById(String id);

}
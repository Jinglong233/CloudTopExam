package com.jl.project.service;

import com.jl.project.entity.po.LoginLog;
import com.jl.project.entity.query.LoginLogQuery;
import com.jl.project.entity.vo.PaginationResultVO;

import java.util.List;

;
/**
 * @Description:登录日志表Service
 * @author:jingLong
 * @date:2024/05/13
 */
public interface LoginLogService {

	/**
	 * 根据条件查询列表
	 */
	List<LoginLog> findListByParam(LoginLogQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(LoginLogQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<LoginLog> findListByPage(LoginLogQuery query);

	/**
	 * 新增
	 */
	Integer add(LoginLog bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<LoginLog> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<LoginLog> listBean);

	/**
	 * 根据Id查询
	 */
	LoginLog getLoginLogById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateLoginLogById(LoginLog bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteLoginLogById(Integer id);

    Boolean deleteLoginLogBatchById(List<Integer> deleteList);

	void test(Integer deleteList);
}
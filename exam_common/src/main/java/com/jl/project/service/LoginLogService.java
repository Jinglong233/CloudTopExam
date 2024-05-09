package com.jl.project.service;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;;
import org.springframework.format.annotation.DateTimeFormat;
import com.jl.project.enums.DateTimePatternEnum;
import com.jl.project.utils.DateUtils;
import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.LoginLog;
import com.jl.project.entity.query.LoginLogQuery;

import java.util.List;
/**
 * @Description:登录日志表Service
 * @author:jingLong
 * @date:2024/05/08
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

}
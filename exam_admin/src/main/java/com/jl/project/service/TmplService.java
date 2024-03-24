package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Tmpl;
import com.jl.project.entity.query.TmplQuery;

import java.util.List;
/**
 * @Description:消息模板表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface TmplService {

	/**
	 * 根据条件查询列表
	 */
	List<Tmpl> findListByParam(TmplQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(TmplQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Tmpl> findListByPage(TmplQuery query);

	/**
	 * 新增
	 */
	Integer add(Tmpl bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Tmpl> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Tmpl> listBean);

	/**
	 * 根据Id查询
	 */
	Tmpl getTmplById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateTmplById(Tmpl bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteTmplById(String id);

}
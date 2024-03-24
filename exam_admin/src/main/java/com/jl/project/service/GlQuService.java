package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.GlQu;
import com.jl.project.entity.query.GlQuQuery;

import java.util.List;
/**
 * @Description:大题题目关联表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface GlQuService {

	/**
	 * 根据条件查询列表
	 */
	List<GlQu> findListByParam(GlQuQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(GlQuQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<GlQu> findListByPage(GlQuQuery query);

	/**
	 * 新增
	 */
	Integer add(GlQu bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<GlQu> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<GlQu> listBean);

	/**
	 * 根据Id查询
	 */
	GlQu getGlQuById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateGlQuById(GlQu bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteGlQuById(String id);

}
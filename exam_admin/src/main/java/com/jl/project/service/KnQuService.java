package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.KnQu;
import com.jl.project.entity.query.KnQuQuery;

import java.util.List;
/**
 * @Description:题目知识点关联表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface KnQuService {

	/**
	 * 根据条件查询列表
	 */
	List<KnQu> findListByParam(KnQuQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(KnQuQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<KnQu> findListByPage(KnQuQuery query);

	/**
	 * 新增
	 */
	Integer add(KnQu bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<KnQu> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<KnQu> listBean);

	/**
	 * 根据Id查询
	 */
	KnQu getKnQuById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateKnQuById(KnQu bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteKnQuById(String id);

}
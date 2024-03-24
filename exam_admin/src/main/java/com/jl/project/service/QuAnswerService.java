package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.QuAnswer;
import com.jl.project.entity.query.QuAnswerQuery;

import java.util.List;
/**
 * @Description:题目答案表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface QuAnswerService {

	/**
	 * 根据条件查询列表
	 */
	List<QuAnswer> findListByParam(QuAnswerQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(QuAnswerQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<QuAnswer> findListByPage(QuAnswerQuery query);

	/**
	 * 新增
	 */
	Integer add(QuAnswer bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<QuAnswer> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<QuAnswer> listBean);

	/**
	 * 根据Id查询
	 */
	QuAnswer getQuAnswerById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateQuAnswerById(QuAnswer bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteQuAnswerById(String id);

}
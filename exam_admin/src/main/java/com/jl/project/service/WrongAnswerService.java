package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.WrongAnswer;
import com.jl.project.entity.query.WrongAnswerQuery;

import java.util.List;
/**
 * @Description:错题答案表Service
 * @author:jingLong
 * @date:2024/05/29
 */
public interface WrongAnswerService {

	/**
	 * 根据条件查询列表
	 */
	List<WrongAnswer> findListByParam(WrongAnswerQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(WrongAnswerQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<WrongAnswer> findListByPage(WrongAnswerQuery query);

	/**
	 * 新增
	 */
	Integer add(WrongAnswer bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<WrongAnswer> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<WrongAnswer> listBean);

	/**
	 * 根据Id查询
	 */
	WrongAnswer getWrongAnswerById(Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateWrongAnswerById(WrongAnswer bean, Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteWrongAnswerById(Integer id);

}
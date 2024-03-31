package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.ExamAnswer;
import com.jl.project.entity.query.ExamAnswerQuery;

import java.util.List;
/**
 * @Description:考试答案表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface ExamAnswerService {

	/**
	 * 根据条件查询列表
	 */
	List<ExamAnswer> findListByParam(ExamAnswerQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(ExamAnswerQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ExamAnswer> findListByPage(ExamAnswerQuery query);

	/**
	 * 新增
	 */
	Integer add(ExamAnswer bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ExamAnswer> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<ExamAnswer> listBean);

	/**
	 * 根据Id查询
	 */
	ExamAnswer getExamAnswerById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateExamAnswerById(ExamAnswer bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteExamAnswerById(String id);

}
package com.jl.project.service;


import com.jl.project.entity.dto.UpdateExamRecordDTO;
import com.jl.project.entity.po.ExamRecord;
import com.jl.project.entity.query.ExamRecordQuery;
import com.jl.project.entity.vo.CorrectUserExamUserVO;
import com.jl.project.entity.vo.PaginationResultVO;

import java.util.List;
/**
 * @Description:考试记录表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface ExamRecordService {

	/**
	 * 根据条件查询列表
	 */
	List<ExamRecord> findListByParam(ExamRecordQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(ExamRecordQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ExamRecord> findListByPage(ExamRecordQuery query);

	/**
	 * 新增
	 */
	Integer add(ExamRecord bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ExamRecord> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<ExamRecord> listBean);

	/**
	 * 根据Id查询
	 */
	ExamRecord getExamRecordById(String id);

	/**
	 * 根据Id更新
	 */
	Boolean updateExamRecordById(UpdateExamRecordDTO updateExamRecordDTO);

	/**
	 * 根据Id删除
	 */
	Integer deleteExamRecordById(String id);

	/**
	 * 根据考试Id获取考试记录
	 * @param examId
	 * @return
	 */
    PaginationResultVO<CorrectUserExamUserVO> getExamRecordByExamId(ExamRecordQuery examRecordQuery);
}
package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.TrainRecord;
import com.jl.project.entity.query.TrainRecordQuery;

import java.util.List;
/**
 * @Description:训练详情记录表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface TrainRecordService {

	/**
	 * 根据条件查询列表
	 */
	List<TrainRecord> findListByParam(TrainRecordQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(TrainRecordQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<TrainRecord> findListByPage(TrainRecordQuery query);

	/**
	 * 新增
	 */
	Integer add(TrainRecord bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<TrainRecord> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<TrainRecord> listBean);

	/**
	 * 根据Id查询
	 */
	TrainRecord getTrainRecordById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateTrainRecordById(TrainRecord bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteTrainRecordById(String id);

}
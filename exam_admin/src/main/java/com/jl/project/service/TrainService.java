package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Train;
import com.jl.project.entity.query.TrainQuery;

import java.util.List;
/**
 * @Description:训练表Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface TrainService {

	/**
	 * 根据条件查询列表
	 */
	List<Train> findListByParam(TrainQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(TrainQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Train> findListByPage(TrainQuery query);

	/**
	 * 新增
	 */
	Integer add(Train bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Train> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Train> listBean);

	/**
	 * 根据Id查询
	 */
	Train getTrainById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateTrainById(Train bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteTrainById(String id);

}
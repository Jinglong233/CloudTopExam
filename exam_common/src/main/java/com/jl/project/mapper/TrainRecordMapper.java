package com.jl.project.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:训练详情记录表商品Mapper
 * @author:jingLong
 * @date:2023/11/22
 */
public interface TrainRecordMapper<T, P> extends BaseMapper {
	/**
	 * 根据Id查询
	 */
	T selectById(@Param("id") String id);

	/**
	 * 根据Id更新
	 */
	Integer updateById(@Param("bean") T t, @Param("id") String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteById(@Param("id") String id);

	/**
	 * 批量删除未作答的记录
	 */
	Integer deleteNoAnswerRecord();


}
package com.jl.project.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:考试答案表商品Mapper
 * @author:jingLong
 * @date:2023/11/22
 */
public interface ExamAnswerMapper<T, P> extends BaseMapper {
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

}
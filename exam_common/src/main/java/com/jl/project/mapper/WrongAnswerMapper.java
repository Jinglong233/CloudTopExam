package com.jl.project.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:错题答案表商品Mapper
 * @author:jingLong
 * @date:2024/05/29
 */
public interface WrongAnswerMapper<T, P> extends BaseMapper {
	/**
	 * 根据Id查询
	 */
	T selectById(@Param("id") Integer id);

	/**
	 * 根据Id更新
	 */
	Integer updateById(@Param("bean") T t, @Param("id") Integer id);

	/**
	 * 根据Id删除
	 */
	Integer deleteById(@Param("id") Integer id);

}
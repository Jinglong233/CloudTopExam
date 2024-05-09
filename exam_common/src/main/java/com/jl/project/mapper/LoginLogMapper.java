package com.jl.project.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:登录日志表商品Mapper
 * @author:jingLong
 * @date:2024/05/08
 */
public interface LoginLogMapper<T, P> extends BaseMapper {
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
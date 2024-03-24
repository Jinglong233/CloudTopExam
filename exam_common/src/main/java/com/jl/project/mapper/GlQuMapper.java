package com.jl.project.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description:大题题目关联表商品Mapper
 * @author:jingLong
 * @date:2023/11/22
 */
public interface GlQuMapper<T, P> extends BaseMapper {
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
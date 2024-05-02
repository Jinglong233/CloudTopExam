package com.jl.project.mapper;

import com.jl.project.entity.po.Qu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:题目表商品Mapper
 * @author:jingLong
 * @date:2023/11/22
 */
public interface QuMapper<T, P> extends BaseMapper {
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
     * 根据给定的题目列表返回对应的问题列表
     */
    List<Qu> getQuListByIds(@Param("quIds") List<String> quIds);
}
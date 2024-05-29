package com.jl.project.mapper;

import com.jl.project.entity.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:错题本商品Mapper
 * @author:jingLong
 * @date:2024/05/29
 */
public interface BookMapper<T, P> extends BaseMapper {
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
     * 查询指定用户集合的错题记录
     */
    List<Book> getBookListByUserIds(@Param("userIds") List<String> userIds);

}
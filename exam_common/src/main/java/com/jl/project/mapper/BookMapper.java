package com.jl.project.mapper;

import com.jl.project.entity.po.Book;
import com.jl.project.entity.po.User;
import com.jl.project.entity.query.ErrorCountQuery;
import com.jl.project.entity.vo.ChartVO;
import com.jl.project.entity.vo.WrongCountSummaryVO;
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

	/**
	 * 根据知识点分类获取前五的错题知识点
	 */
    List<ChartVO> selectByKnowledge();

	/**
	 * 分类获取每个题型中每个知识点的错题总和
	 * @return
	 */
    List<WrongCountSummaryVO> selectWrongCountSummary();

	/**
	 * 获取知识点列表
	 * @return
	 */
	List<String> selectKnContentList();

	/**
	 * 根据用户列表获取错题列表
	 * @param userList
	 * @return
	 */
    List<Book> selectErrorCountByUserList(@Param("userList") List<User> userList, @Param("query") ErrorCountQuery errorCountQuery);

	/**
	 * 获取知识点列表数量
	 * @return
	 */
	Integer selectErrorCountNumByUserList(@Param("userList") List<User> userList);
}
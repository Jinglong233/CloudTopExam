package com.jl.project.service;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Book;
import com.jl.project.entity.query.BookQuery;

import java.util.List;
/**
 * @Description:错题本Service
 * @author:jingLong
 * @date:2023/11/22
 */
public interface BookService {

	/**
	 * 根据条件查询列表
	 */
	List<Book> findListByParam(BookQuery query);

	/**
	 * 根据条件查询数量
	 */
	Integer findCountByParam(BookQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Book> findListByPage(BookQuery query);

	/**
	 * 新增
	 */
	Integer add(Book bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<Book> listBean);

	/**
	 * 批量新增或修改
	 */
	Integer addOrUpdateBatch(List<Book> listBean);

	/**
	 * 根据Id查询
	 */
	Book getBookById(String id);

	/**
	 * 根据Id更新
	 */
	Integer updateBookById(Book bean, String id);

	/**
	 * 根据Id删除
	 */
	Integer deleteBookById(String id);

}
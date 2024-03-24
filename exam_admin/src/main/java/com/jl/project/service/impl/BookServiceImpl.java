package com.jl.project.service.impl;

import com.jl.project.entity.vo.PaginationResultVO;
import com.jl.project.entity.po.Book;
import com.jl.project.entity.query.SimplePage;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.enums.PageSize;
import com.jl.project.mapper.BookMapper;
import com.jl.project.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description:错题本Service
 * @author:jingLong
 * @date:2023/11/22
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource
	private BookMapper<Book,BookQuery> bookMapper;

	/**
	 * 根据条件查询列表
	 */
	public List<Book> findListByParam(BookQuery query) {
		return this.bookMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	public Integer findCountByParam(BookQuery query) {
		return this.bookMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	public PaginationResultVO<Book> findListByPage(BookQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Book> list = this.findListByParam(query);
		PaginationResultVO<Book> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	public Integer add(Book bean) {
		return this.bookMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	public Integer addBatch(List<Book> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.bookMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或修改
	 */
	public Integer addOrUpdateBatch(List<Book> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.bookMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据Id查询
	 */
	public Book getBookById(String id) {
		return this.bookMapper.selectById(id);
	}

	/**
	 * 根据Id更新
	 */
	public Integer updateBookById(Book bean, String id) {
		return this.bookMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	public Integer deleteBookById(String id) {
		return this.bookMapper.deleteById(id);
	}

}
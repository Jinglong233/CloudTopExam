package com.jl.project.controller;

import com.jl.project.entity.po.Book;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.entity.vo.ResponseVO;
import com.jl.project.service.BookService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:错题本Controller
 * @author:jingLong
 * @date:2023/11/22
 */
@RestController
@RequestMapping("/book")
public class BookController extends ABaseController{

	@Resource
	private BookService bookService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("loadDataList")
	public ResponseVO loadDatalist(BookQuery query) {
		return getSuccessResponseVO(bookService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("add")
	public ResponseVO add(Book bean) {
		return getSuccessResponseVO(this.bookService.add(bean));
	}

	/**
	 * 批量新增
	 */
	@RequestMapping("addBatch")
	public ResponseVO addBatch(@RequestBody List<Book> listBean) {
		return getSuccessResponseVO(this.bookService.addBatch(listBean));
	}

	/**
	 * 批量新增或修改
	 */
	@RequestMapping("addOrUpdateBatch")
	public ResponseVO addOrUpdateBatch(@RequestBody List<Book> listBean) {
		return getSuccessResponseVO(this.bookService.addOrUpdateBatch(listBean));
	}

	/**
	 * 根据Id查询
	 */

	@RequestMapping("getBookById")
	public ResponseVO getBookById(String id) {
		return getSuccessResponseVO(this.bookService.getBookById(id));
	}

	/**
	 * 根据Id更新
	 */
	@RequestMapping("updateBookById")
	public ResponseVO updateBookById(Book bean, String id) {
		return getSuccessResponseVO(this.bookService.updateBookById(bean, id));
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("deleteBookById")
	public ResponseVO deleteBookById(String id) {
		this.bookService.deleteBookById(id);
		return getSuccessResponseVO(null);
	}

}
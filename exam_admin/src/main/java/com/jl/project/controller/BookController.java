package com.jl.project.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.util.SaResult;
import com.jl.project.entity.po.Book;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "错题本Controller", description = "错题本Controller")
@RestController
@RequestMapping("/book")
@SaCheckLogin
@SaCheckRole("admin")
public class BookController {

    @Resource
    private BookService bookService;


    /**
     * 根据条件分页查询
     */
    @RequestMapping("loadDataList")
    public SaResult loadDatalist(BookQuery query) {
        return SaResult.ok().setData(bookService.findListByPage(query));
    }

    /**
     * 新增
     */
    @RequestMapping("add")
    public SaResult add(Book bean) {
        return SaResult.ok().setData(this.bookService.add(bean));
    }

    /**
     * 批量新增
     */
    @RequestMapping("addBatch")
    public SaResult addBatch(@RequestBody List<Book> listBean) {
        return SaResult.ok().setData(this.bookService.addBatch(listBean));
    }

    /**
     * 批量新增或修改
     */
    @RequestMapping("addOrUpdateBatch")
    public SaResult addOrUpdateBatch(@RequestBody List<Book> listBean) {
        return SaResult.ok().setData(this.bookService.addOrUpdateBatch(listBean));
    }

    /**
     * 根据Id查询
     */

    @RequestMapping("getBookById")
    public SaResult getBookById(String id) {
        return SaResult.ok().setData(this.bookService.getBookById(id));
    }

    /**
     * 根据Id更新
     */
    @RequestMapping("updateBookById")
    public SaResult updateBookById(Book bean, String id) {
        return SaResult.ok().setData(this.bookService.updateBookById(bean, id));
    }

    /**
     * 根据Id删除
     */
    @RequestMapping("deleteBookById")
    public SaResult deleteBookById(String id) {
        Integer result = this.bookService.deleteBookById(id);
        return SaResult.ok(result > 0 ? "删除成功" : "删除失败");
    }

}
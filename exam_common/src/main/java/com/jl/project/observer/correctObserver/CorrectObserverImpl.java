package com.jl.project.observer.correctObserver;

import com.jl.project.entity.po.Book;
import com.jl.project.entity.query.BookQuery;
import com.jl.project.mapper.BookMapper;
import com.jl.project.utils.CommonUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author huawei
 * @Date 2024-05-26 22:40
 **/
@Repository
public class CorrectObserverImpl implements CorrectObserver {

    @Resource
    private BookMapper<Book, BookQuery> bookMapper;

    @Override
    public void insertErrorCollection(List<String> quList, String userId) {
        if (quList != null && !quList.isEmpty()) {
            for (String quId : quList) {
                // 1. 查询该用户，该题目有没有做错过
                BookQuery bookQuery = new BookQuery();
                bookQuery.setQuId(quId);
                bookQuery.setUserId(userId);

                List<Book> bookList = bookMapper.selectList(bookQuery);
                if (bookList != null && !bookList.isEmpty()) {
                    // 存在就累加
                    Book book = bookList.get(0);
                    book.setWrongCount(book.getWrongCount() + 1);
                    // 更新
                    bookMapper.updateById(book, book.getId());
                } else {
                    // 不存在就新建
                    Book book = new Book();
                    book.setId(CommonUtil.getRandomId());
                    book.setQuId(quId);
                    book.setUserId(userId);
                    book.setWrongCount(1);
                    // 插入
                    bookMapper.insert(book);
                }
            }
        }

    }
}

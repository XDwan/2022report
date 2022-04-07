package com.dubbo.bookInfo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.bookInfo.BookInfoService;
import com.dubbo.bookInfo.entity.Book;
import com.dubbo.bookInfo.service.BookInfoQueryService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: XDwan
 * @Date:2022/4/4
 * @Description:
 **/
@Component
public class BookInfoQueryServiceImpl implements BookInfoQueryService {

    @Reference(
            version = "${spring.application.version}",
            application = "${spring.application.id}",
            registry = "${dubbo.registry.address}"
    )
    private BookInfoService service;

    @Override
    public boolean addBook(Book book) {
        return service.add(book);
    }

    @Override
    public List<Book> queryAllBook() {

        return service.getAllBook();
    }

    @Override
    public List<Book> queryLikeBook(String name) {

        return service.getLikeBook(name);
    }

    @Override
    public List<Book> queryBookByID(int id) {
        return service.getBookByID(id);
    }

    @Override
    public boolean deleteBook(int id) {
        return service.deleteBookByID(id);
    }


}

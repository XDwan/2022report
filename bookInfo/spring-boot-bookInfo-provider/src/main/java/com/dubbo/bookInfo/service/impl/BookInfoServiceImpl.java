package com.dubbo.bookInfo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.bookInfo.BookInfoService;
import com.dubbo.bookInfo.entity.Book;
import com.dubbo.bookInfo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @Author: XDwan
 * @Date:2022/4/3
 * @Description:
 **/

@Service(
        version = "${spring.application.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public boolean add(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookMapper.selectAllBookList();
    }

    @Override
    public List<Book> getLikeBook(String name) {
        return bookMapper.selectLikeBookList(name);
    }

    @Override
    public List<Book> getBookByID(int id) {
        return bookMapper.selectBookByID(id);
    }

    @Override
    public boolean deleteBookByID(int id) {
        return bookMapper.deleteBookByID(id);

    }

}

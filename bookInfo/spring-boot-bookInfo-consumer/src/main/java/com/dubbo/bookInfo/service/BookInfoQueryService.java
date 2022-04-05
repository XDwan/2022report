package com.dubbo.bookInfo.service;

import com.dubbo.bookInfo.entity.Book;

import java.util.List;

/**
 * @Author: XDwan
 * @Date:2022/4/4
 * @Description:
 **/
public interface BookInfoQueryService {
    public boolean addBook(Book book);
    public List<Book> queryAllBook();
    public List<Book> queryLikeBook(String name);
    public List<Book> queryBookByID(int id);
    public boolean deleteBook(int id);
}

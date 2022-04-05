package com.dubbo.bookInfo;

import com.dubbo.bookInfo.entity.Book;

import java.util.List;

public interface BookInfoService {
    public boolean add(Book book);

    public List<Book> getAllBook();

    public List<Book> getLikeBook(String name);

    public List<Book> getBookByID(int id);

    public boolean deleteBookByID(int id);
}

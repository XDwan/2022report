package com.dubbo.bookInfo.mapper;

import com.dubbo.bookInfo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    public List<Book> selectAllBookList();

    public boolean insertBook(@Param("book") Book book);

    public List<Book> selectLikeBookList(@Param("bookName") String bookName);

    public List<Book> selectBookByID(@Param("id") int id);

    public boolean deleteBookByID(@Param("id") int id);
}

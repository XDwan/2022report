package com.dubbo.bookInfo.controller;

import com.dubbo.bookInfo.entity.Book;
import com.dubbo.bookInfo.service.BookInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: XDwan
 * @Date:2022/4/3
 * @Description:
 **/

@RestController
public class InfoQueryController {
    @Autowired
    private BookInfoQueryService bookInfoQueryService;

    @GetMapping("/getAllBook")
    public List<Book> addBook(){
        List<Book> bookList = bookInfoQueryService.queryAllBook();
        for(Book book: bookList){
            System.out.println(book);
        }
        return bookList;
    }

    @GetMapping("/getLikeBook")
    public List<Book> getLikeBook(@RequestParam("name") String name){
        System.out.println(name);
        List<Book> bookList = bookInfoQueryService.queryLikeBook(name);
        System.out.println(bookList.isEmpty());
        for(Book book: bookList){
            System.out.println(book);
        }
        return bookList;
    }

    @PostMapping("/insertBook")
    public boolean insertBook(@RequestParam("name") String name,
                            @RequestParam("id") int id
                            ){
        System.out.println(name);
        System.out.println(id);
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        return bookInfoQueryService.addBook(book);
    }
    @GetMapping("/getBookByID")
    public List<Book> getBookByID(@RequestParam("id") int id){
        List<Book> bookList = bookInfoQueryService.queryBookByID(id);
        System.out.println(bookList.isEmpty());
        for(Book book: bookList){
            System.out.println(book);
        }
        return bookList;
    }

    @GetMapping("/deleteBook")
    public List<Book> deleteBook(@RequestParam("id") int id){
        List<Book> bookList = bookInfoQueryService.queryBookByID(id);
        if(bookInfoQueryService.deleteBook(id)){
            return bookList;
        }
        else return null;
    }
}

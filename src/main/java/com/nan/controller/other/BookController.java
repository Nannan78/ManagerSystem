package com.nan.controller.other;

import com.nan.mapper.BookMapper;
import com.nan.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookMapper bookMapper;
    @GetMapping("/qbs")
    @ResponseBody
    public String queryBooks(){
        List<Book> list = bookMapper.queryBooks();
        return list.toString();
    }

    @GetMapping("/qbbi")
    @ResponseBody
    public String queryBookById(int id){
        Book book = bookMapper.queryBookById(id);
        return book.toString();
    }

    @GetMapping("/qbbn")
    @ResponseBody
    public String queryBookByName(String bookName){
        Book book = bookMapper.queryBookByName(bookName);
        return book.toString();
    }

    @GetMapping("/ub")
    @ResponseBody
    public String updateBook(Book book){
        int i = bookMapper.updateBook(book);
        return "";
    }

    @GetMapping("/db")
    @ResponseBody
    public String deleteBook(int id){
        int i = bookMapper.deleteBook(id);
        return "";
    }

    @GetMapping("/ab")
    @ResponseBody
    public String addBook(Book book){
        int i = bookMapper.addBook(book);
        return "";
    }

}

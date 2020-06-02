package com.nan.mapper;


import com.nan.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    List<Book> queryBooks();

    Book queryBookById(int id);

    int addBook(Book book);

    int deleteBook(int id);

    int updateBook(Book book);

    Book queryBookByName(String bookName);
}

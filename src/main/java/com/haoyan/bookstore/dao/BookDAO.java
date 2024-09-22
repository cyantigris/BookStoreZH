package com.haoyan.bookstore.dao;

import com.haoyan.bookstore.pojo.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDAO {
    int addBook(Book book);
    int removeBook(long bookId);
    int updateBook(Book book);
    Book queryById(long id);
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}

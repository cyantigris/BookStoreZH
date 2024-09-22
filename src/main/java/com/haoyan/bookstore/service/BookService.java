package com.haoyan.bookstore.service;

import com.haoyan.bookstore.pojo.dto.BookCreateRequest;
import com.haoyan.bookstore.pojo.dto.BookUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    boolean addNewBook(BookCreateRequest book);

    boolean removeBook(long bookId);

    boolean updateBook(BookUpdateRequest book);


    Book queryById(long bookId);

    List<Book> queryAll(int offset, int limit);
}

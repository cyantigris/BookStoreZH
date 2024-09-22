package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.pojo.dto.BookCreateRequest;
import com.haoyan.bookstore.pojo.dto.BookQueryRequest;
import com.haoyan.bookstore.pojo.dto.BookUpdateRequest;
import com.haoyan.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {
    @Autowired
    BookService bookService;
    @Test
    void addNewBook() {
        BookCreateRequest bookCreateRequest = new BookCreateRequest(
                12345,
                "Test Book2",
                "This is fake detail",
                10,
                "/b/c/d"
        );
        assertTrue(bookService.addNewBook(bookCreateRequest));
    }

    @Test
    void updateBook() {
        BookUpdateRequest bookUpdateRequest = new BookUpdateRequest(
                12345,
                    "Test Book3",
                "This is fake detail",
                9,
                ""
        );
        assertTrue(bookService.updateBook(bookUpdateRequest));
    }

    @Test
    void queryById() {

        assertEquals(12345, bookService.queryById(12345).getBookId());
    }

    @Test
    void queryAll() {
        assertFalse(bookService.queryAll(0, 10).isEmpty());
    }
    @Test
    void removeBook() {
        assertTrue(bookService.removeBook(12345));
    }
}
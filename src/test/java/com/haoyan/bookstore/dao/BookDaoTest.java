package com.haoyan.bookstore.dao;

import com.haoyan.bookstore.BookstoreApplicationTests;
import com.haoyan.bookstore.pojo.entity.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class BookDaoTest extends BookstoreApplicationTests {
    @Autowired
    BookDAO bookDAO;

    @Test
    public void TestAddBook() throws Exception{
        Date now = new Date();
        long timeStamp = now.getTime();
        Book book = new Book(
                233,
                "Test Book",
                "description of book",
                10,
                "a/b/c/d/e",
                timeStamp,
                timeStamp
        );
        Assert.assertTrue(bookDAO.addBook(book) > 0);
    }
    @Test
    public void TestUpdateBook() throws Exception{
        Date now = new Date();
        long timeStamp = now.getTime();
        Book book = new Book(
                233L,
                "Test Book1",
                "description of book1",
                10,
                "a/b/c/d/e",
                timeStamp,
                timeStamp
        );
        Assert.assertTrue(bookDAO.updateBook(book) > 0);
    }

    @Test
    public void TestQueryById(){
        long id = 233;
        Assert.assertNotNull(bookDAO.queryById(id));
    }

    @Test
    public void TestQueryAll(){
        Assert.assertNotNull(bookDAO.queryAll(0, 10));
    }
    @Test
    public void TestRemoveBook(){
        long id = 233;
        Assert.assertTrue(bookDAO.removeBook(233) > 0);
    }

}

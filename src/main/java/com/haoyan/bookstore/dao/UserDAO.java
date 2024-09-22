package com.haoyan.bookstore.dao;

import com.haoyan.bookstore.pojo.entity.Book;
import com.haoyan.bookstore.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDAO {
    int addUser(User book);
    int removeUser(long bookId);
    int updateUser(User book);
    User queryById(long id);
    User queryByName(String name);
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}

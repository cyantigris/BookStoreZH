package com.haoyan.bookstore.dao;


import com.haoyan.bookstore.BookstoreApplicationTests;
import com.haoyan.bookstore.pojo.entity.User;
import com.haoyan.bookstore.pojo.enums.RoleEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserDaoTest  extends BookstoreApplicationTests {
    @Autowired
    UserDAO userDAO;

    @Test
    public void TestAddUser() throws Exception{
        Date now = new Date();
        long timeStamp = now.getTime();
        User user = new User(
                2221,
                "Jay Zhou",
                RoleEnum.USER,
                "abcde",
                timeStamp,
                timeStamp
        );
        Assert.assertTrue(userDAO.addUser(user) > 0);
    }

    @Test
    public void TestQueryById() throws Exception{
        long id = 2221;
        Assert.assertNotNull(userDAO.queryById(id));
    }

    @Test
    public void TestQueryByName() throws Exception{
        String name = "Jay Zhou";
        Assert.assertNotNull(userDAO.queryByName(name));
    }

    @Test
    public void TestUpdateUser() throws Exception{
        Date now = new Date();
        long timeStamp = now.getTime();
        User user = new User(
                2221,
                "Jay Zhou1",
                RoleEnum.USER,
                "abcde",
                timeStamp,
                timeStamp
        );
        Assert.assertTrue( userDAO.updateUser(user) > 0);
    }

    @Test
    public void TestRemoveUser() throws Exception{
        long userId = 2221;
        Assert.assertTrue(userDAO.removeUser(userId) > 0);
    }

}

package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.pojo.dto.UserCreateRequest;
import com.haoyan.bookstore.pojo.dto.UserDeleteRequest;
import com.haoyan.bookstore.pojo.dto.UserLoginRequest;
import com.haoyan.bookstore.pojo.dto.UserModifyRequest;
import com.haoyan.bookstore.pojo.enums.RoleEnum;
import com.haoyan.bookstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    void create() {
        UserCreateRequest userCreateRequest = new UserCreateRequest(
                123456,
                "fake Name",
                RoleEnum.USER,
                "asdfa"
        );
        assertTrue(userService.create(userCreateRequest));
    }

    @Test
    void login() {
        UserLoginRequest userLoginRequest = new UserLoginRequest(
                "fake Name","asdfa");
        assertTrue(userService.login(userLoginRequest));
    }

    @Test
    void modification() {
        UserModifyRequest userModifyRequest = new UserModifyRequest(
                123456,
                "fake Name1",
                "asdfa"
        );
        assertTrue(userService.modification(userModifyRequest));
    }

    @Test
    void queryOne() {
        assertNotNull(userService.queryOne(123456));
    }

    @Test
    void delete() {
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest(123456);
        assertTrue(userService.delete(userDeleteRequest));
    }
}
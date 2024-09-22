package com.haoyan.bookstore.service;

import com.haoyan.bookstore.pojo.dto.UserCreateRequest;
import com.haoyan.bookstore.pojo.dto.UserDeleteRequest;
import com.haoyan.bookstore.pojo.dto.UserLoginRequest;
import com.haoyan.bookstore.pojo.dto.UserModifyRequest;
import com.haoyan.bookstore.pojo.entity.User;

public interface UserService {
    boolean create(UserCreateRequest ucr);
    boolean login(UserLoginRequest ulr);
    boolean delete(UserDeleteRequest udr);
    boolean modification(UserModifyRequest userId);
    User queryOne(long userId);
}

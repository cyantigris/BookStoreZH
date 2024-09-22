package com.haoyan.bookstore.controller;

import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.entity.User;
import com.haoyan.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.haoyan.bookstore.pojo.Constants.*;
import static com.haoyan.bookstore.pojo.Constants.SUCCESS;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Response<String> register(@RequestBody UserCreateRequest ucr){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");
        if(userService.create(ucr)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("User registered Successfully");
        }
        return response;
    }
    @PostMapping("/login")
    public Response<String> login(@RequestBody UserLoginRequest ulr){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");
        if(userService.login(ulr)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("User login Successfully");
        }
        return response;
    }

    @PostMapping("/update")
    public Response<String> update(@RequestBody UserModifyRequest umr){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");

        if(userService.modification(umr)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("User info updated Successfully");
        }
        return response;
    }

    @PostMapping("/get")
    public Response<User> get(@RequestBody UserQueryRequest uqr){

        return new Response<>(
                SUCCESS_CODE,
                SUCCESS,
                userService.queryOne(uqr.getUserId())
        );
    }
}

package com.haoyan.bookstore.controller;

import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.entity.User;
import com.haoyan.bookstore.pojo.enums.ApplicationStatusEnum;
import com.haoyan.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody UserCreateRequest ucr){
        Response res = new Response(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(), "");
        if(userService.create(ucr)){
            res.setCode(ApplicationStatusEnum.SUCCESS.getState());
            res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }
        return res;
    }
    @PostMapping("/login")
    public Response login(@RequestBody UserLoginRequest ulr){
        Response res = new Response(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(), "");
        if(userService.login(ulr)){
            res.setCode(ApplicationStatusEnum.SUCCESS.getState());
            res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }
        return res;
    }

    @PostMapping("/update")
    public String update(@RequestBody UserModifyRequest umr){
        boolean res = userService.modification(umr);
        return "OK";
    }

    @PostMapping("/get")
    public Response<User> get(@RequestBody UserQueryRequest uqr){
        Response<User> res = new Response(
            ApplicationStatusEnum.SUCCESS.getState(),
            ApplicationStatusEnum.SUCCESS.getStateInfo(),
            userService.queryOne(uqr.getUserId()));

        return res;
    }

}

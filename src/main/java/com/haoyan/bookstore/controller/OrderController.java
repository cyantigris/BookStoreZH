package com.haoyan.bookstore.controller;

import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.entity.Order;
import com.haoyan.bookstore.pojo.enums.ApplicationStatusEnum;
import com.haoyan.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public Response<Order> create(OrderCreateRequest ocr){
        Response<Order> res = new Response<>(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(), null);
        if(orderService.create(ocr)){
            res.setCode(ApplicationStatusEnum.SUCCESS.getState());
            res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }
        return res;
    };

    @PostMapping("/updateAddress")
    public Response<String> updateAddress(OrderAddressUpdateRequest orderAddressUpdateRequest){
        Response<String> res = new Response<>(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(), "");
        if(orderService.updateAddress(orderAddressUpdateRequest)){
            res.setCode(ApplicationStatusEnum.SUCCESS.getState());
            res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }

        return res;
    }

    @PostMapping("/updateStatus")
    public Response<String> updateOrderStatus(OrderStatusUpdateRequest orderStatusUpdateRequest){
        Response<String> res = new Response<>(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(), "");

        if(orderService.updateOrderStatus(orderStatusUpdateRequest)){
            res.setCode(ApplicationStatusEnum.SUCCESS.getState());
            res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }

        return res;
    }

    @PostMapping("/delete")
    public Response<String> delete(OrderDeleteRequest odr){
        Response<String> res = new Response<>(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(), "");

        if(orderService.delete(odr)){
            res.setCode(ApplicationStatusEnum.SUCCESS.getState());
            res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }

        return res;
    }

}

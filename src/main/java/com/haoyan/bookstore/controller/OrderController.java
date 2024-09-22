package com.haoyan.bookstore.controller;

import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.entity.Order;
import com.haoyan.bookstore.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public Response<Order> create(@RequestBody OrderCreateRequest ocr){
        Response<Order> response = new Response<>(
                        FAILURE_CODE,
                        FAILURE,null);
        if(orderService.create(ocr)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Order Create Success");
        }
        return response;
    };

    @PostMapping("/updateAddress")
    public Response<String> updateAddress(@RequestBody OrderAddressUpdateRequest orderAddressUpdateRequest){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");

        if(orderService.updateAddress(orderAddressUpdateRequest)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Address Updated Success");
        }

        return response;
    }

    @PostMapping("/updateStatus")
    public Response<String> updateOrderStatus(@RequestBody OrderStatusUpdateRequest orderStatusUpdateRequest){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");

        if(orderService.updateOrderStatus(orderStatusUpdateRequest)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Order Status Updated Success");
        }

        return response;
    }

    @PostMapping("/delete")
    public Response<String> delete(@RequestBody OrderDeleteRequest orderDeleteRequest){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");

        if(orderService.delete(orderDeleteRequest)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Order delete Success");
        }

        return response;
    }

}

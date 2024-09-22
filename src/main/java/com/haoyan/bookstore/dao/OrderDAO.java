package com.haoyan.bookstore.dao;

import com.haoyan.bookstore.pojo.dto.OrderAddressUpdateRequest;
import com.haoyan.bookstore.pojo.dto.OrderCreateRequest;
import com.haoyan.bookstore.pojo.dto.OrderDeleteRequest;
import com.haoyan.bookstore.pojo.dto.OrderStatusUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Book;
import com.haoyan.bookstore.pojo.entity.Order;
import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDAO {
    int create(Order order);

    int delete(long orderId);

    int updateAddress(long orderId, String address);

    int updateOrderStatus(long orderId, OrderStatusEnum orderStatus);

    Order get(long orderId);

}

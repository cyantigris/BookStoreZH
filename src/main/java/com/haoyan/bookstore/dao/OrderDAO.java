package com.haoyan.bookstore.dao;

import com.haoyan.bookstore.pojo.dto.OrderAddressUpdateRequest;
import com.haoyan.bookstore.pojo.dto.OrderCreateRequest;
import com.haoyan.bookstore.pojo.dto.OrderDeleteRequest;
import com.haoyan.bookstore.pojo.dto.OrderStatusUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Order;
import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;

public interface OrderDAO {
    int create(Order order);

    int delete(long orderId);

    int updateAddress(long orderId, String address);

    int updateOrderStatus(long orderId, OrderStatusEnum OrderStatus);

    Order get(long orderId);

}

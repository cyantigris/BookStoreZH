package com.haoyan.bookstore.service;

import com.haoyan.bookstore.pojo.dto.OrderAddressUpdateRequest;
import com.haoyan.bookstore.pojo.dto.OrderCreateRequest;
import com.haoyan.bookstore.pojo.dto.OrderDeleteRequest;
import com.haoyan.bookstore.pojo.dto.OrderStatusUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Order;

public interface OrderService {
    boolean create(OrderCreateRequest orderCreateRequest);
    boolean delete(OrderDeleteRequest orderDeleteRequest);
    boolean updateAddress(OrderAddressUpdateRequest orderAddressUpdateRequest);
    boolean updateOrderStatus(OrderStatusUpdateRequest orderStatusUpdateRequest);
    Order getOne(long orderId);
}

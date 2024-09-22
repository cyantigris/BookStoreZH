package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;
import com.haoyan.bookstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    OrderService orderService;
    @Test
    void create() {
        List<OrderItem> itemList = new ArrayList<>();
        itemList.add(new OrderItem(1234L,1));
        OrderCreateRequest request = new OrderCreateRequest(
                223456L,
                itemList,
                1234,
                OrderStatusEnum.NEW,
                "fake address"
        );
        assertTrue(orderService.create(request));
    }

    @Test
    void updateAddress() {
        OrderAddressUpdateRequest orderAddressUpdateRequest = new OrderAddressUpdateRequest();
        orderAddressUpdateRequest.setAddress("fake address1");
        orderAddressUpdateRequest.setOrderId( 223456L);
        assertTrue(orderService.updateAddress(orderAddressUpdateRequest));

    }

    @Test
    void updateOrderStatus() {
        OrderStatusUpdateRequest orderStatusUpdateRequest = new OrderStatusUpdateRequest();
        orderStatusUpdateRequest.setOrderId(223456L);
        orderStatusUpdateRequest.setStatus(OrderStatusEnum.PAY_BEFORE);
        assertTrue(orderService.updateOrderStatus(orderStatusUpdateRequest));
    }

    @Test
    void getOne() {
        long orderId = 223456L;
        assertNotNull(orderService.getOne(orderId));
    }

    @Test
    void delete() {
        OrderDeleteRequest orderDeleteRequest = new OrderDeleteRequest();
        orderDeleteRequest.setOrderId(223456L);
        assertTrue(orderService.delete(orderDeleteRequest));
    }
}
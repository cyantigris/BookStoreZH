package com.haoyan.bookstore.dao;

import com.haoyan.bookstore.pojo.entity.Order;
import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
    @Autowired
    OrderDAO orderDAO;
    @Test
    void create() {
        HashMap<Long,Integer> itemList = new HashMap<>();
        itemList.put(123L,1);

        Date now = new Date();
        long timeStamp = now.getTime();
        Order order = new Order(
                12345,
                itemList,
                123,
                OrderStatusEnum.NEW,
                "fake address",
                timeStamp,
                timeStamp
        );
        assertTrue(orderDAO.create(order) > 0);
    }

    @Test
    void updateAddress() {
        long orderId = 12345;
        String address = "fake address1";
        assertTrue(orderDAO.updateAddress(orderId,address) > 0);

    }

    @Test
    void updateOrderStatus() {
        long orderId = 12345;
        OrderStatusEnum newStatue = OrderStatusEnum.SHIPPING;
        assertTrue(orderDAO.updateOrderStatus(orderId, newStatue) > 0);
    }

    @Test
    void get() {
        long orderId = 12345;
        assertNotNull(orderDAO.get(orderId));
    }
    @Test
    void delete() {
        long orderId = 12345;
        assertTrue(orderDAO.delete(orderId) > 0);
    }
}
package com.haoyan.bookstore.pojo.dto;

import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;

import java.util.HashMap;

public class OrderCreateRequest {
    private int orderId;
    private HashMap<String, Integer> itemList;
    private int userId;
    private OrderStatusEnum orderStatus;

    private String address;

    public OrderCreateRequest(int orderId, HashMap<String, Integer> itemList, int userId, OrderStatusEnum orderStatus) {
        this.orderId = orderId;
        this.itemList = itemList;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public HashMap<String, Integer> getItemList() {
        return itemList;
    }

    public void setItemList(HashMap<String, Integer> itemList) {
        this.itemList = itemList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.haoyan.bookstore.pojo.dto;

import com.alibaba.fastjson.JSONArray;
import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;

import java.util.HashMap;
import java.util.List;

public class OrderCreateRequest {
    private long orderId;
    private List<OrderItem> itemList;
    private int userId;
    private OrderStatusEnum orderStatus;
    private String address;

    public OrderCreateRequest(long orderId, List<OrderItem> itemList, int userId, OrderStatusEnum orderStatus, String address) {
        this.orderId = orderId;
        this.itemList = itemList;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.address = address;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
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

    @Override
    public String toString() {
        return "OrderCreateRequest{" +
                "orderId=" + orderId +
                ", itemList=" + itemList +
                ", userId=" + userId +
                ", orderStatus=" + orderStatus +
                ", address='" + address + '\'' +
                '}';
    }
}

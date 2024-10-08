package com.haoyan.bookstore.pojo.entity;

import com.haoyan.bookstore.pojo.dto.OrderItem;
import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;

import java.util.HashMap;
import java.util.List;

public class Order {
    private long orderId;
    private String itemList;
    private int userId;
    private OrderStatusEnum orderStatus;
    private String address;
    private long createdAt;
    private long updatedAt;

    public Order(long orderId, String itemList, int userId, OrderStatusEnum orderStatus, String address, long createdAt, long updatedAt) {
        this.orderId = orderId;
        this.itemList = itemList;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemList=" + itemList +
                ", userId=" + userId +
                ", orderStatus=" + orderStatus +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

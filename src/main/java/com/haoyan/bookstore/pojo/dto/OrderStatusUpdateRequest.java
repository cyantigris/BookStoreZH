package com.haoyan.bookstore.pojo.dto;

import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;

public class OrderStatusUpdateRequest {
    private long orderId;
    private OrderStatusEnum status;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}

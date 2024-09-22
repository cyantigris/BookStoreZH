package com.haoyan.bookstore.pojo.dto;

public class OrderDeleteRequest {
    private long orderId;

    public OrderDeleteRequest(long uesrId) {
        this.orderId = uesrId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long uesrId) {
        this.orderId = uesrId;
    }
}

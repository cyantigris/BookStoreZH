package com.haoyan.bookstore.pojo.dto;

public class OrderAddressUpdateRequest {
    private long orderId;
    private String address;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

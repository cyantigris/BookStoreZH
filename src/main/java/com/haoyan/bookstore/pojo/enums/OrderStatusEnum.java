package com.haoyan.bookstore.pojo.enums;

public enum OrderStatusEnum {
    NEW(0,"New Order"),
    PAY_BEFORE(1,"Before Payment"),
    PAY_SUCCESS(2,"Payment Success"),
    PAY_FAIL(3,"Payment Failure"),
    SHIPPING(4,"Order Shipping"),
    SUCCESS(5,"Order Success"),
    FAILURE(6,"Order Failure");
    private int state;
    private String stateInfo;
    OrderStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static OrderStatusEnum stateOf(int index) {
        for (OrderStatusEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

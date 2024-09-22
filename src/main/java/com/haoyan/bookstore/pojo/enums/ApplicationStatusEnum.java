package com.haoyan.bookstore.pojo.enums;

public enum ApplicationStatusEnum {
    SUCCESS(200, "Success"),
    INVALID_USER(200, "Invalid User"),
    INVALID_FUNCTION(200, "You are not allow to do this"),
    FAILURE(400, "Failure"),
    INNER_ERROR(500,"Inner Error");
    private int state;
    private String stateInfo;

    ApplicationStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ApplicationStatusEnum stateOf(int index) {
        for (ApplicationStatusEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

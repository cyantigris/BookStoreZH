package com.haoyan.bookstore.pojo.dto;

public class UserDeleteRequest {
    private long userId;

    public UserDeleteRequest(long uesrId) {
        this.userId = uesrId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long uesrId) {
        this.userId = uesrId;
    }
}

package com.haoyan.bookstore.pojo.entity;

import com.haoyan.bookstore.pojo.enums.RoleEnum;

public class User {
    private int userId;
    private String userName;
    private RoleEnum role;
    private String password;
    private long createdAt;
    private long updatedAt;

    public User(int userId, String userName, RoleEnum role, String password, long createdAt, long updatedAt) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setUpdatedAt(long updateAt) {
        this.updatedAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", CreatedAt=" + createdAt +'\'' +
                ", UpdateAt=" + updatedAt +
                '}';
    }
}

package com.haoyan.bookstore.pojo.dto;

import com.haoyan.bookstore.pojo.enums.RoleEnum;

public class UserCreateRequest {
    private int userId;
    private String userName;
    private RoleEnum role;
    private String password;

    public UserCreateRequest(int userId, String userName, RoleEnum role, String password) {
        this.userId = userId;
        this.userName = userName;
        this.role = role;
        this.password = password;
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
}

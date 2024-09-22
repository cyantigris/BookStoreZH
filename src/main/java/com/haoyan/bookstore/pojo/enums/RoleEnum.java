package com.haoyan.bookstore.pojo.enums;

public enum RoleEnum {
    ADMIN(0 ),
    USER(1),
    BLOCKED(2);
    private final int code;
    RoleEnum(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static RoleEnum fromCode(int code) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.getCode() == code) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + code);
    }
}

package com.haoyan.bookstore.utils;


import com.haoyan.bookstore.pojo.enums.OrderStatusEnum;
import com.haoyan.bookstore.pojo.enums.RoleEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStatusHandler implements TypeHandler<OrderStatusEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, OrderStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getState());
    }

    @Override
    public OrderStatusEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return OrderStatusEnum.stateOf(rs.getInt(columnName));
    }

    @Override
    public OrderStatusEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return OrderStatusEnum.valueOf(String.valueOf(rs.getInt(columnIndex)));
    }

    @Override
    public OrderStatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OrderStatusEnum.valueOf(String.valueOf(cs.getInt(columnIndex)));
    }
}
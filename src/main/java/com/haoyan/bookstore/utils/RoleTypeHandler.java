package com.haoyan.bookstore.utils;


import com.haoyan.bookstore.pojo.enums.RoleEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import java.sql.*;

public class RoleTypeHandler implements TypeHandler<RoleEnum> {
    @Override
    public void setParameter(PreparedStatement ps, int i, RoleEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public RoleEnum getResult(ResultSet rs, String columnName) throws SQLException {
//        System.out.println(rs.getInt(columnName));
//        System.out.println(RoleEnum.fromCode(rs.getInt(columnName)));
        return RoleEnum.fromCode(rs.getInt(columnName));
    }

    @Override
    public RoleEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return RoleEnum.valueOf(String.valueOf(rs.getInt(columnIndex)));
    }

    @Override
    public RoleEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return RoleEnum.valueOf(String.valueOf(cs.getInt(columnIndex)));
    }
}
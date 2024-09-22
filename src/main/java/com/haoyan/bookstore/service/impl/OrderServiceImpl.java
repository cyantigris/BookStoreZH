package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.dao.OrderDAO;
import com.haoyan.bookstore.dao.UserDAO;
import com.haoyan.bookstore.pojo.dto.OrderAddressUpdateRequest;
import com.haoyan.bookstore.pojo.dto.OrderCreateRequest;
import com.haoyan.bookstore.pojo.dto.OrderDeleteRequest;
import com.haoyan.bookstore.pojo.dto.OrderStatusUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Order;
import com.haoyan.bookstore.service.OrderService;
import com.haoyan.bookstore.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Override
    public boolean create(OrderCreateRequest orderCreateRequest) {
        Date now = new Date();
        long timeStamp = now.getTime();
        Order order = new Order(
                orderCreateRequest.getOrderId(),
                orderCreateRequest.getItemList().toString(),
                orderCreateRequest.getUserId(),
                orderCreateRequest.getOrderStatus(),
                orderCreateRequest.getAddress(),
                timeStamp,
                timeStamp
        );
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
            int i = orderDAO.create(order);
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean delete(OrderDeleteRequest orderDeleteRequest) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
            int i = orderDAO.delete(orderDeleteRequest.getOrderId());
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean updateAddress(OrderAddressUpdateRequest orderAddressUpdateRequest) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
            int i = orderDAO.updateAddress(
                    orderAddressUpdateRequest.getOrderId(),
                    orderAddressUpdateRequest.getAddress());
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean updateOrderStatus(OrderStatusUpdateRequest orderStatusUpdateRequest) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
            int i = orderDAO.updateOrderStatus(
                    orderStatusUpdateRequest.getOrderId(),
                    orderStatusUpdateRequest.getStatus());
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public Order getOne(long orderId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            OrderDAO orderDAO = sqlSession.getMapper(OrderDAO.class);
            Order order = orderDAO.get(orderId);
            sqlSession.commit();
            return order;
        } catch (Exception e){
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return null;
    }
}

package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.dao.UserDAO;
import com.haoyan.bookstore.pojo.dto.UserCreateRequest;
import com.haoyan.bookstore.pojo.dto.UserDeleteRequest;
import com.haoyan.bookstore.pojo.dto.UserLoginRequest;
import com.haoyan.bookstore.pojo.dto.UserModifyRequest;
import com.haoyan.bookstore.pojo.entity.User;
import com.haoyan.bookstore.service.UserService;
import com.haoyan.bookstore.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean create(UserCreateRequest ucr) {
        Date now = new Date();
        long timeStamp = now.getTime();
        User usr = new User(
                ucr.getUserId(),
                ucr.getUserName(),
                ucr.getRole(),
                ucr.getPassword(),
                timeStamp,
                timeStamp
        );
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            UserDAO usrDao = sqlSession.getMapper(UserDAO.class);
            int i = usrDao.addUser(usr);
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean login(UserLoginRequest ulr) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            UserDAO usrDao = sqlSession.getMapper(UserDAO.class);
            User user = usrDao.queryByName(ulr.getUserName());
            if(user.getPassword().equals(ulr.getPassword())){
                res = true;
            }
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean delete(UserDeleteRequest udr) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            int i = userDAO.removeUser(udr.getUserId());
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }


    @Override
    public boolean modification(UserModifyRequest umr) {
        Date now = new Date();
        long timeStamp = now.getTime();
        User usr = new User(
                umr.getUserId(),
                umr.getUserName(),
                umr.getRole(),
                umr.getPassword(),
                timeStamp,
                timeStamp
        );
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            UserDAO usrDao = sqlSession.getMapper(UserDAO.class);
            int i = usrDao.updateUser(usr);
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public User queryOne(long userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            UserDAO usrDao = sqlSession.getMapper(UserDAO.class);
            User user = usrDao.queryById(userId);
            if(user != null){
                return user;
            }
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return null;
    }
}

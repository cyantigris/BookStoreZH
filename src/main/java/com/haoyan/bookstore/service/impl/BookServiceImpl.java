package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.dao.BookDAO;
import com.haoyan.bookstore.pojo.dto.BookCreateRequest;
import com.haoyan.bookstore.pojo.dto.BookUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Book;
import com.haoyan.bookstore.service.BookService;
import com.haoyan.bookstore.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Override
    public boolean addNewBook(BookCreateRequest bcr) {
        Date now = new Date();
        long timeStamp = now.getTime();
        Book book = new Book(
                bcr.getBookId(),
                bcr.getName(),
                bcr.getDesc(),
                bcr.getStockNum(),
                bcr.getPic(),
                timeStamp,
                timeStamp
                );
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            int i = bookDAO.addBook(book);
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean removeBook(long bookId) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            int i = bookDAO.removeBook(bookId);
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean updateBook(BookUpdateRequest bur) {
        Date now = new Date();
        long timeStamp = now.getTime();
        Book book = new Book(
                bur.getBookId(),
                bur.getName(),
                bur.getDesc(),
                bur.getStockNum(),
                bur.getPic(),
                timeStamp,
                timeStamp
        );
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            int i = bookDAO.updateBook(book);
            res = i > 0;
            sqlSession.commit();
        } catch (Exception e){
            sqlSession.rollback();
        }
        return res;
    }
    @Override
    public Book queryById(long bookId) {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            System.out.println("1");
            Book book = bookDAO.queryById(bookId);
            sqlSession.commit();
            return book;
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return null;
    }

    @Override
    public List<Book> queryAll(int offset, int limit) {
        List<Book> books = null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            books = bookDAO.queryAll(offset,limit);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
        return books;
    }
}

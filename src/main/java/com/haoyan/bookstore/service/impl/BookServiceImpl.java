package com.haoyan.bookstore.service.impl;

import com.haoyan.bookstore.controller.BookController;
import com.haoyan.bookstore.dao.BookDAO;
import com.haoyan.bookstore.pojo.dto.BookCreateRequest;
import com.haoyan.bookstore.pojo.dto.BookUpdateRequest;
import com.haoyan.bookstore.pojo.entity.Book;
import com.haoyan.bookstore.service.BookService;
import com.haoyan.bookstore.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Override
    public boolean addNewBook(BookCreateRequest bcr) {
        Date now = new Date();
        long timeStamp = now.getTime();
        Book book = new Book(
                bcr.getBookId(),
                bcr.getName(),
                bcr.getDetail(),
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
            logger.error(e.toString());
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
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return res;
    }

    @Override
    public boolean updateBook(BookUpdateRequest bookUpdateRequest) {
        boolean res = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            Book targetBook = bookDAO.queryById(bookUpdateRequest.getBookId());
            //update book name if necessary
            if(!bookUpdateRequest.getName().isEmpty() && !bookUpdateRequest.getName().equals(targetBook.getName())){
                targetBook.setName(bookUpdateRequest.getName());
            }
            //update book detail if necessary
            if(!bookUpdateRequest.getDesc().isEmpty() && !bookUpdateRequest.getDesc().equals(targetBook.getDetail())){
                targetBook.setDetail(bookUpdateRequest.getDesc());
            }
            //update book picture if necessary
            if(!bookUpdateRequest.getPic().isEmpty() && !bookUpdateRequest.getPic().equals(targetBook.getPic())){
                targetBook.setPic(bookUpdateRequest.getPic());
            }
            //update book picture if necessary
            if(bookUpdateRequest.getStockNum() > 0 && bookUpdateRequest.getStockNum() != targetBook.getStockNum()){
                targetBook.setStockNum(bookUpdateRequest.getStockNum());
            }

            int i = bookDAO.updateBook(targetBook);
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
    public Book queryById(long bookId) {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
            Book book = bookDAO.queryById(bookId);
            sqlSession.commit();
            return book;
        } catch (Exception e){
            logger.error(e.toString());
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
            logger.error(e.toString());
            e.printStackTrace();
            sqlSession.rollback();
        }
        return books;
    }
}

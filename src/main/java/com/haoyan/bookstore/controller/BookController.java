package com.haoyan.bookstore.controller;


import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.entity.Book;
import com.haoyan.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.haoyan.bookstore.pojo.Constants.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    BookService bookService;
    @PostMapping("/create")
    public Response<String> create(@RequestBody BookCreateRequest bcr){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");

        if(bookService.addNewBook(bcr)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Book Creation Success");
        }

        return response;
    }
    @PostMapping("/delete")
    public Response<String> delete(@RequestBody BookDeleteRequest bdr){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");
        if(bookService.removeBook(bdr.getBookId())){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Book Delete Success");
        }
        return response;
    }
    @PostMapping("/update")
    public Response<String> update(@RequestBody BookUpdateRequest bur){
        Response<String> response = new Response<>(
                FAILURE_CODE,
                FAILURE,"");
        if(bookService.updateBook(bur)){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            logger.info("Book Update Success");
        }
        return response;
    }
    @PostMapping("/get")
    public Response<Book> get(@RequestBody BookQueryRequest bqr){
        Response<Book> response = new Response<>(
                FAILURE_CODE,
                FAILURE,
                null);

        Book book = bookService.queryById(bqr.getBookId());

        if(book != null){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            response.setPayload(book);
            logger.info("Book get Success");
        }
        return response;
    }
    @PostMapping("/list")
    public Response<List<Book>> list(@RequestBody PageQueryRequest pr){
        Response<List<Book>> response = new Response<>(
                FAILURE_CODE,
                FAILURE,
                null);

        List<Book> bookList = bookService.queryAll(pr.getOffset(),pr.getLimit());

        if(!bookList.isEmpty()){
            response.setCode(SUCCESS_CODE);
            response.setMsg(SUCCESS);
            response.setPayload(bookList);
            logger.info("Book list Success");
        }
        return response;
    }

}

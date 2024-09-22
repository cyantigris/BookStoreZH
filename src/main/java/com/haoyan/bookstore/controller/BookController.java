package com.haoyan.bookstore.controller;

import com.haoyan.bookstore.pojo.dto.*;
import com.haoyan.bookstore.pojo.entity.Book;
import com.haoyan.bookstore.pojo.enums.ApplicationStatusEnum;
import com.haoyan.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/new")
    public Response addNew(@RequestBody BookCreateRequest bcr){
        Response res = new Response(
                ApplicationStatusEnum.FAILURE.getState(),
                ApplicationStatusEnum.FAILURE.getStateInfo(),"");

        if(bookService.addNewBook(bcr)){
                res.setCode(ApplicationStatusEnum.SUCCESS.getState());
                res.setMsg(ApplicationStatusEnum.SUCCESS.getStateInfo());
        }

        return res;
    }
    @PostMapping("/delete")
    public String delete(@RequestBody BookDeleteRequest bdr){
        boolean bool = bookService.removeBook(bdr.getBookId());
        return "OK";
    }
    @PostMapping("/update")
    public String update(@RequestBody BookUpdateRequest bur){
        boolean bool = bookService.updateBook(bur);
        return "OK";
    }
    @PostMapping("/get")
    public String getOne(@RequestBody BookQueryRequest bqr){
        Book book = bookService.queryById(bqr.getBookId());
        return book.toString();
    }
    @PostMapping("/list")
    public String getAll(@RequestBody PageQueryRequest pr){
        List<Book> book = bookService.queryAll(pr.getOffset(),pr.getLimit());
        return book.toString();
    }
    @GetMapping("/test")
    public String testConnection(){
        return "OK";
    }

}

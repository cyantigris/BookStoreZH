package com.haoyan.bookstore.pojo.dto;

public class OrderItem {
    private Long bookId;
    private Integer number;

    public OrderItem(Long bookId, Integer number) {
        this.bookId = bookId;
        this.number = number;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer item) {
        this.number = item;
    }

    @Override
    public String toString() {
        return "{" +
                "bookId:" + bookId +
                ", number:" + number +
                '}';
    }
}

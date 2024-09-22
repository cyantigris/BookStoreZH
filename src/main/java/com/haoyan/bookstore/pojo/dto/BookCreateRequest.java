package com.haoyan.bookstore.pojo.dto;

public class BookCreateRequest {
    private long bookId;
    private String name;
    private String detail;
    private int stockNum;
    private String pic;

    public BookCreateRequest(long bookId, String name, String detail, int stockNum, String pic) {
        this.bookId = bookId;
        this.name = name;
        this.detail = detail;
        this.stockNum = stockNum;
        this.pic = pic;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "BookCreateRequest{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", stockNum=" + stockNum +
                ", pic='" + pic + '\'' +
                '}';
    }
}

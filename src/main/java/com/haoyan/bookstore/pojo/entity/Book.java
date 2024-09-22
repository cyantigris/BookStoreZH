package com.haoyan.bookstore.pojo.entity;

public class Book {
    private long bookId;
    private String name;
    private String detail;
    private int stockNum;
    private String pic;
    private long createdAt;
    private long updatedAt;

    public Book(long bookId, String name, String detail, int stockNum, String pic, long createdAt, long updatedAt) {
        this.bookId = bookId;
        this.name = name;
        this.detail = detail;
        this.stockNum = stockNum;
        this.pic = pic;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", desc='" + detail + '\'' +
                ", stockNum=" + stockNum +
                ", pic='" + pic + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

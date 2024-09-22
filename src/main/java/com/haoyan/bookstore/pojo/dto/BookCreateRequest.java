package com.haoyan.bookstore.pojo.dto;

public class BookCreateRequest {
    private long bookId;
    private String name;
    private String desc;
    private int stockNum;
    private String pic;

    public BookCreateRequest(long bookId, String name, String desc, int stockNum, String pic) {
        this.bookId = bookId;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
                ", desc='" + desc + '\'' +
                ", stockNum=" + stockNum +
                ", pic='" + pic + '\'' +
                '}';
    }
}

package com.baizhi.zfq.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZhaoFuqiang
 * date 2022/11/23
 * description
 */

public class Book implements Serializable {
    private String id;
    private String name;
    private String author;
    private Double price;
    private String press;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date pressDate;
    private String coverFileName;
    private Integer sale;
    private Integer stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPressDate() {
        return pressDate;
    }

    public void setPressDate(Date pressDate) {
        this.pressDate = pressDate;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", pressDate=" + pressDate +
                ", coverFileName='" + coverFileName + '\'' +
                ", sale=" + sale +
                ", stock=" + stock +
                '}';
    }

    public Book(String id, String name, String author, Double price, String press, Date pressDate, String coverFileName, Integer sale, Integer stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.pressDate = pressDate;
        this.coverFileName = coverFileName;
        this.sale = sale;
        this.stock = stock;
    }
    public Book(){

    }
}

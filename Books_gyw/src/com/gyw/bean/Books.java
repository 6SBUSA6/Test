package com.gyw.bean;

import java.sql.Date;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:53
 * @describe 实体类
 */
public class Books {
    private int id; //编号
    private String name; //名字
    private String author; //作者
    private double price; //价格
    private Date pub_date; //日期
    private int store; //库存

    //重写toStrong
    @Override
    public String toString() {
        return  id +"\t" + name + "\t"+ author + "\t" + price +"\t" + pub_date +"\t"+ store ;
    }

    public Books() {
    }

    public Books(int id, String name, String author, double price, Date pub_date, int store) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pub_date = pub_date;
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}

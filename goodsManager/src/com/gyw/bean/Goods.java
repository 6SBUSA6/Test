package com.gyw.bean;
/**
 * @author 高源蔚
 * @date 2021/8/31-10:30
 * @describe
 */
public class Goods {
    private int gid;
    private String gname;
    private int type;
    private double price;
    private String brief;
    private String typename;

    //重写toString
    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", type=" + typename +
                ", price=" + price +
                ", brief='" + brief + '\'' +
                '}';
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Goods() {
    }

    public Goods(int gid, String gname, int type, double price, String brief) {
        this.gid = gid;
        this.gname = gname;
        this.type = type;
        this.price = price;
        this.brief = brief;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}





package com.gyw.bean;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:12
 * @describe
 */
public class Fruit {
    private int fuitid; //编号
    private String typename;  //类别名称
    private String breed;  //品种
    private String area; //产地
    private String brief; //简介
    private double weight; //总重量
    private double price; //单价

    //重写toString
    @Override
    public String toString() {
        return "Fruit{" +
                "fuitid=" + fuitid +
                ", typename='" + typename + '\'' +
                ", breed='" + breed + '\'' +
                ", area='" + area + '\'' +
                ", brief='" + brief + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
    public Fruit() {
    }

    public Fruit(int fuitid, String typename, String breed, String area, String brief, double weight, double price) {
        this.fuitid = fuitid;
        this.typename = typename;
        this.breed = breed;
        this.area = area;
        this.brief = brief;
        this.weight = weight;
        this.price = price;
    }

    public int getFuitid() {
        return fuitid;
    }

    public void setFuitid(int fuitid) {
        this.fuitid = fuitid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

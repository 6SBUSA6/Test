package com.gyw.bean;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:38
 * @describe
 */
public class GoodsType {
    private int tid;
    private String tname;

    //重写toString
    @Override
    public String toString() {
        return "GoodsType{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public GoodsType() {
    }

    public GoodsType(int tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}

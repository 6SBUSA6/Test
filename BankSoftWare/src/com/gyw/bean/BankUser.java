package com.gyw.bean;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:20 PM
 * @describe
 */
public class BankUser {
    private int uid;
    private String uname;
    private int uphone;
    private String company;
    private String hometown;

    public BankUser(int uid, String uname, int uphone, String company, String hometown) {
        this.uid = uid;
        this.uname = uname;
        this.uphone = uphone;
        this.company = company;
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uphone=" + uphone +
                ", company='" + company + '\'' +
                ", hometown='" + hometown + '\'' +
                '}';
    }

    public BankUser() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUphone() {
        return uphone;
    }

    public void setUphone(int uphone) {
        this.uphone = uphone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}

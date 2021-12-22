package com.gyw.bean;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:21 PM
 * @describe
 */
public class BankManager {
    private int mid;
    private String mname;
    private String mpass;

    public BankManager(int mid, String mname, String mpass) {
        this.mid = mid;
        this.mname = mname;
        this.mpass = mpass;
    }

    public BankManager() {
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpass() {
        return mpass;
    }

    public void setMpass(String mpass) {
        this.mpass = mpass;
    }
}

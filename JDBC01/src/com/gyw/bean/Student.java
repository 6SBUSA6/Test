package com.gyw.bean;

/**
 * @author 高源蔚
 * @date 2021-08-24-5:19 PM
 * @describe
 */
public class Student {

    private int sid;
    private String snaame;
    private String ssex;
    private String classes;

    public Student() {
    }

    public Student(int sid, String snaame, String ssex, String classes) {
        this.sid = sid;
        this.snaame = snaame;
        this.ssex = ssex;
        this.classes = classes;
    }

    public int getSid() {
        return sid;
    }

    public String getSnaame() {
        return snaame;
    }

    public String getSsex() {
        return ssex;
    }

    public String getClasses() {
        return classes;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSnaame(String snaame) {
        this.snaame = snaame;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    //重写toString方法
    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", snaame='" + snaame + '\'' +
                ", ssex='" + ssex + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}

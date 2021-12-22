package com.gyw.bean;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:21 PM
 * @describe 银行卡对象
 */
public class BankCard {
    private int cid;
    private int cpassword;
    private double cmoney;
    private String ctype;
    private int uid;
    private BankUser bankUser;

    @Override
    public String toString() {
        return  cid +"\t"+ cpassword +"\t"+ cmoney +"\t"+ ctype + "\t" + uid
                +"\t"+ bankUser.getUname() +"\t"+bankUser.getUphone()+"\t"+
                bankUser.getCompany()+"\t"+bankUser.getHometown();
    }

    public BankUser getBankUser() {
        if(this.bankUser == null)
        {
            this.bankUser = new BankUser();
        }
        return this.bankUser;
    }

    public void setBankUser(BankUser bankUser) {
        this.bankUser = bankUser;
    }

    public BankCard() {
    }
    public BankCard(int cid, int cpassword, double cmoney, String ctype, int uid) {
        this.cid = cid;
        this.cpassword = cpassword;
        this.cmoney = cmoney;
        this.ctype = ctype;
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCpassword() {
        return cpassword;
    }

    public void setCpassword(int cpassword) {
        this.cpassword = cpassword;
    }

    public double getCmoney() {
        return cmoney;
    }

    public void setCmoney(double cmoney) {
        this.cmoney = cmoney;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


}

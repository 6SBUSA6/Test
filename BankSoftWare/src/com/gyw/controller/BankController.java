package com.gyw.controller;

import com.gyw.bean.BankCard;
import com.gyw.bean.BankManager;
import com.gyw.bean.BankUser;
import com.gyw.serveice.BankService;
import com.gyw.service.impl.BankServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:20 PM
 * @describe
 */
public class BankController {
    BankService bankService =  new BankServiceImpl();
    //登录功能
    public boolean managerLogin(BankManager bankManager)
    {
        return bankService.managerLogin(bankManager);
    }

    //接收主界面的请求，添加用户
    public boolean addUser(BankUser newUser)
    {
        return bankService.addUser(newUser);
    }

    //查看银行卡密码输入是否正确
    public boolean checkBankCard(BankCard bankCard)
    {
        return bankService.checkBankCard(bankCard);
    }

    //修改银行卡密码
    public boolean updateBankCardPass(BankCard bankCard)
    {
        return bankService.updateBankCardPass(bankCard);
    }

    //删除银行卡
    public boolean deleteCardByID(int Cid)
    {
        return bankService.deleteCardByID(Cid);
    }

    //展示所有银行卡信息
    public List<BankCard> showAllCard() {
        return bankService.showAllCard();
    }

    //根据手机号和银行卡类型查看银行卡信息
    public List<BankCard> findCardByPhoneAndType(int phoneNum, int typeNUm) {
        return bankService.findCardByPhoneAndType(phoneNum,typeNUm);
    }

    //展示所有用户信息
    public ArrayList<BankUser> showAllUser() {
        return bankService.showAllUser();
    }

    //删除用户信息
    public boolean deleteUserByUid(int uid) {
        return bankService.deleteUserByUid(uid);
    }

    public boolean findUserByuid(int uid) {
        return bankService.findUserByuid(uid);
    }

    public boolean addCard(BankCard bankCard) {
        return bankService.addCard(bankCard);
    }

    public boolean addUserAndCard(BankUser bankUser, BankCard bankCard) {
        return bankService.addUserAndCard(bankUser, bankCard);
    }

    public int userLogin(BankCard bankCard) {
        return bankService.userLogin(bankCard);
    }

    public boolean drawMonney(double quMoney, int cid) {
        return bankService.drawMonney(quMoney, cid);
    }

    public double getNowMoney(int cid) {
        return bankService.getNowMoney(cid);
    }

    public boolean saveMoney(double cunMoney, int cid) {
        return bankService.saveMoney(cunMoney, cid);
    }

    public boolean findCardByCid(int cid) {
        return bankService.findCardByCid(cid);
    }

    public BankCard showCardByCid(int cid)
    {
        return bankService.showCardByCid(cid);
    }

    public boolean transferMoney(int cid, int cid2, double zhuanMoney) {
        return bankService.transferMoney(cid, cid2, zhuanMoney);
    }
}

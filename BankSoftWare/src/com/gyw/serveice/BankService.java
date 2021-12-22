package com.gyw.serveice;

import com.gyw.bean.BankCard;
import com.gyw.bean.BankManager;
import com.gyw.bean.BankUser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:27 PM
 * @describe
 */
public interface BankService {

    boolean managerLogin(BankManager bankManager);

    boolean addUser(BankUser newUser);

    boolean checkBankCard(BankCard bankCard);

    boolean updateBankCardPass(BankCard bankCard);

    boolean deleteCardByID(int cid);

    List<BankCard> showAllCard();

    List<BankCard> findCardByPhoneAndType(int phoneNum, int typeNUm);

    ArrayList<BankUser> showAllUser();

    boolean deleteUserByUid(int uid);

    boolean findUserByuid(int uid);

    boolean addCard(BankCard bankCard);

    boolean addUserAndCard(BankUser bankUser, BankCard bankCard);

    int userLogin(BankCard bankCard);

    boolean drawMonney(double quMoney, int cid);

    double getNowMoney(int cid);

    boolean saveMoney(double cunMoney, int cid);

    boolean findCardByCid(int cid);

    BankCard showCardByCid(int cid);

    boolean transferMoney(int cid, int cid2, double zhuanMoney);
}

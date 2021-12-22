package com.gyw.dao;

import com.gyw.bean.BankCard;
import com.gyw.bean.BankManager;
import com.gyw.bean.BankUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:24 PM
 * @describe
 */
public interface BankDao {
    int managerLogin(BankManager bankManager) throws SQLException;

    HashMap<String, Integer> addUser(BankUser newUser) throws SQLException;

    int checkBankCard(BankCard bankCard) throws SQLException;

    int updateBankCardPass(BankCard bankCard) throws SQLException;

    int deleteCardByID(int cid) throws SQLException;

    ArrayList<BankCard> showAllCard() throws SQLException;

    ArrayList<BankCard> findCardByPhoneAndType(int phoneNum, int typeNUm) throws SQLException;

    ArrayList<BankUser> showAllUser() throws SQLException;

    int deleteUserByUid(int uid) throws SQLException;

    int findUserByuid(int uid) throws SQLException;

    int addCard(BankCard bankCard) throws SQLException;

    int userLogin(BankCard bankCard) throws SQLException;

    int drawMonney(double quMoney, int cid) throws SQLException;

    double getNowMoney(int cid) throws SQLException;

    int saveMoney(double cunMoney, int cid) throws SQLException;

    int findCardByCid(int cid) throws SQLException;

    BankCard showCardByCid(int cid) throws SQLException;
}

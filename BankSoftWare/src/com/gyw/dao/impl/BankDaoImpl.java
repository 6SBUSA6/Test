package com.gyw.dao.impl;

import com.gyw.bean.BankCard;
import com.gyw.bean.BankManager;
import com.gyw.bean.BankUser;
import com.gyw.dao.BankDao;
import com.gyw.util.ConnUtil;
import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:25 PM
 * @describe  持久化层 主要用来操作数据库
 */
public class BankDaoImpl implements BankDao {

    //管理员登录
    @Override
    public int managerLogin(BankManager bankManager) throws SQLException {
        int count = 0;
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select * from bankmanager where mname = ? and mpass = ?");
        ps.setString(1,bankManager.getMname());
        ps.setString(2,bankManager.getMpass());
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            count = rs.getInt("mid");
        }
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        return count;
    }

    //添加用户
    @Override
    public HashMap<String, Integer> addUser(BankUser newUser) throws SQLException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("insert into bankuser (uname,uphone,company,hometown)" +
                "values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,newUser.getUname());
        ps.setInt(2,newUser.getUphone());
        ps.setString(3,newUser.getCompany());
        ps.setString(4,newUser.getHometown());
        int countLine = ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        Integer uid = 0;
        while (rs.next())
        {
            uid =rs.getInt(1);
        }
        System.out.println("---Dao里的uid------"+uid);
        hashMap.put("uid",uid);
        hashMap.put("countLine",countLine);
        if (ps != null) {
            ps.close();
        }
        return hashMap;
    }

    //查看银行卡密码是否输入正确
    @Override
    public int checkBankCard(BankCard bankCard) throws SQLException {
        int count = 0;
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select * from bankcard where cid = ? and cpassword = ?");
        ps.setInt(1,bankCard.getCid());
        ps.setInt(2,bankCard.getCpassword());
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            count = rs.getInt("cid");
        }
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        return count;
    }

    //修改银行卡密码
    @Override
    public int updateBankCardPass(BankCard bankCard) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("update bankcard set cpassword = ? where cid = ?");
        ps.setInt(1,bankCard.getCpassword());
        ps.setInt(2,bankCard.getCid());
        int i = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        return i;
    }

    //删除银行卡
    @Override
    public int deleteCardByID(int cid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("delete from bankcard where cid = ?");
        ps.setInt(1,cid);
        int i = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        return i;
    }

    @Override
    public ArrayList<BankCard> showAllCard() throws SQLException {
        ArrayList<BankCard> cardList = new ArrayList<>();
        Connection conn = ConnUtil.getConnect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select bk.*, bu.uname, bu.uphone, bu.company, bu.hometown from bankcard bk, bankuser bu where bk.uid = bu.uid order by cid");
        while (rs.next())
        {
            BankCard bankCard = new BankCard();
            bankCard.setCid(rs.getInt(1));
            bankCard.setCpassword(rs.getInt(2));
            bankCard.setCmoney(rs.getInt(3));
            bankCard.setCtype(rs.getString(4));
            bankCard.setUid(rs.getInt(5));
            bankCard.getBankUser().setUid(rs.getInt(5));
            bankCard.getBankUser().setUname(rs.getString(6));
            bankCard.getBankUser().setUphone(rs.getInt(7));
            bankCard.getBankUser().setCompany(rs.getString(8));
            bankCard.getBankUser().setHometown(rs.getString(9));
            cardList.add(bankCard);
        }
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        return cardList;
    }

    //更具手机号和银行卡类型查找银行卡信息
    @Override
    public ArrayList<BankCard> findCardByPhoneAndType(int phoneNum, int typeNUm) throws SQLException {
        ArrayList<BankCard> cardList = new ArrayList<>();
        Connection conn = ConnUtil.getConnect();
        String sql = "select bk.*, bu.uname, bu.uphone, bu.company, bu.hometown from bankcard bk, bankuser bu where bk.uid = bu.uid";
        PreparedStatement ps = conn.prepareStatement(sql);
        if(phoneNum != 0 && typeNUm != 0)
        {
            sql += " and uphone = ? and ctype = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,phoneNum);
            ps.setString(2,typeNUm == 1? "储蓄卡": "信用卡");
        }
        if(phoneNum == 0 && typeNUm != 0)
        {
            sql += " and ctype = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,typeNUm == 1? "储蓄卡": "信用卡");
        }
        if(phoneNum != 0 && typeNUm == 0)
        {
            sql += " and uphone = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,phoneNum);
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            BankCard bankCard = new BankCard();
            bankCard.setCid(rs.getInt(1));
            bankCard.setCpassword(rs.getInt(2));
            bankCard.setCmoney(rs.getInt(3));
            bankCard.setCtype(rs.getString(4));
            bankCard.setUid(rs.getInt(5));
            bankCard.getBankUser().setUid(rs.getInt(5));
            bankCard.getBankUser().setUname(rs.getString(6));
            bankCard.getBankUser().setUphone(rs.getInt(7));
            bankCard.getBankUser().setCompany(rs.getString(8));
            bankCard.getBankUser().setHometown(rs.getString(9));
            cardList.add(bankCard);
        }
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        return cardList;
    }

    @Override
    public ArrayList<BankUser> showAllUser() throws SQLException {
        ArrayList<BankUser> allUserList = new ArrayList<>();
        Connection conn = ConnUtil.getConnect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from bankuser ");
        while (rs.next())
        {
            BankUser user = new BankUser();
            user.setUid(rs.getInt(1));
            user.setUname(rs.getString(2));
            user.setUphone(rs.getInt(3));
            user.setCompany(rs.getString(4));
            user.setHometown(rs.getString(5));
            allUserList.add(user);
        }
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        return allUserList;
    }

    //删除指定用户
    @Override
    public int deleteUserByUid(int uid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("delete from bankuser where uid = ?");
        ps.setInt(1,uid);
        int i = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        return i;
    }

    //根据用户id查找用户信息
    @Override
    public int findUserByuid(int uid) throws SQLException {
        int count = 0;
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select * from bankuser where uid = ?");
        ps.setInt(1,uid);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            count = rs.getInt("uid");
        }
        return count;
    }

    //添加银行卡
    @Override
    public int addCard(BankCard bankCard) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("insert into bankcard (cpassword,cmoney,ctype,uid) values " +
                "(?,?,?,?)");
        ps.setInt(1,bankCard.getCpassword());
        ps.setDouble(2,bankCard.getCmoney());
        ps.setString(3,bankCard.getCtype());
        ps.setInt(4,bankCard.getUid());
        int i = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        return i ;
    }

    //普通用户登录
    @Override
    public int userLogin(BankCard bankCard) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select cid from bankcard where cid = ? and cpassword = ?");
        ps.setInt(1,bankCard.getCid());
        ps.setInt(2,bankCard.getCpassword());
        ResultSet rs = ps.executeQuery();
        int cid = 0;
        while (rs.next())
        {
            cid = rs.getInt("cid");
        }
        return cid;
    }

    //取钱
    @Override
    public int drawMonney(double quMoney, int cid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        int nowMoney = 0; //余额
        int countLine = 0; //影响的行数
        PreparedStatement psUpdate = conn.prepareStatement("update bankcard set cmoney = cmoney - ? where cid = ?");
        psUpdate.setDouble(1,quMoney);
        psUpdate.setInt(2,cid);
        countLine = psUpdate.executeUpdate();
        return countLine;
    }

    //查看余额
    @Override
    public double getNowMoney(int cid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select * from bankcard where cid = ?");
        ps.setInt(1,cid);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            return rs.getInt("cmoney");
        }
        return 0;
    }

    //存钱
    @Override
    public int saveMoney(double cunMoney, int cid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("update bankcard set cmoney = cmoney + ? where cid =? ");
        ps.setDouble(1,cunMoney);
        ps.setInt(2,cid);
        int i = ps.executeUpdate();
        if (ps != null) {
            ps.close();
        }
        return i;
    }

    //通过卡号来查询银行卡
    @Override
    public int findCardByCid(int cid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        int count = 0;
        PreparedStatement ps = conn.prepareStatement("select count(*) from bankcard where cid = ?");
        ps.setInt(1,cid);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            count = rs.getInt("count(*)");
        }
        return count;
    }

    //展示银行卡信息
    @Override
    public BankCard showCardByCid(int cid) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select bk.*, bu.uname, bu.uphone, bu.company, bu.hometown  from bankcard bk, bankuser bu " +
                " where cid = ? and bk.uid = bu.uid");
        ps.setInt(1,cid);
        ResultSet rs = ps.executeQuery();
        BankCard bankCard = new BankCard();
        while (rs.next())
        {
            bankCard.setCid(rs.getInt(1));
            bankCard.setCpassword(rs.getInt(2));
            bankCard.setCmoney(rs.getInt(3));
            bankCard.setCtype(rs.getString(4));
            bankCard.setUid(rs.getInt(5));
            bankCard.getBankUser().setUid(rs.getInt(5));
            bankCard.getBankUser().setUname(rs.getString(6));
            bankCard.getBankUser().setUphone(rs.getInt(7));
            bankCard.getBankUser().setCompany(rs.getString(8));
            bankCard.getBankUser().setHometown(rs.getString(9));
        }
        return bankCard;
    }
}

package com.gyw.service.impl;

import com.gyw.bean.BankCard;
import com.gyw.bean.BankManager;
import com.gyw.bean.BankUser;
import com.gyw.dao.BankDao;
import com.gyw.dao.impl.BankDaoImpl;
import com.gyw.serveice.BankService;
import com.gyw.util.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:28 PM
 * @describe 业务层是实现类 主要处理事务等相关操作
 */
public class BankServiceImpl implements BankService {
    BankDao bankDao = new BankDaoImpl();

    //管理员登录
    @Override
    public boolean managerLogin(BankManager bankManager) {
        int count = 0;
        try {
            count = bankDao.managerLogin(bankManager);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //添加用户
    @Override
    public boolean addUser(BankUser newUser) {
        int count = 0;
        try {
            HashMap<String, Integer> hashMap = bankDao.addUser(newUser);
            count = hashMap.get("countLine");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //查看银行卡密码输入是否正确
    @Override
    public boolean checkBankCard(BankCard bankCard) {
        int count = 0;
        try {
            count = bankDao.checkBankCard(bankCard);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //修改银行卡密码
    @Override
    public boolean updateBankCardPass(BankCard bankCard) {
        int count = 0;
        try {
            count = bankDao.updateBankCardPass(bankCard);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //删除银行卡
    @Override
    public boolean deleteCardByID(int cid) {
        int count = 0;
        try {
            count = bankDao.deleteCardByID(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //展示所有银行卡信息
    @Override
    public List<BankCard> showAllCard() {
        ArrayList<BankCard> cardList = new ArrayList<>();
        try {
            cardList = bankDao.showAllCard();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return cardList;
    }

    //通过电话号码和类型来查找银行卡
    @Override
    public List<BankCard> findCardByPhoneAndType(int phoneNum, int typeNUm) {
        ArrayList<BankCard> bankCards = new ArrayList<>();
        try {
            bankCards = bankDao.findCardByPhoneAndType(phoneNum, typeNUm);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return bankCards;
    }

    //查看所有用户
    @Override
    public ArrayList<BankUser> showAllUser() {
        ArrayList<BankUser> allUserList = new ArrayList<>();
        try {
            allUserList = bankDao.showAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return allUserList;
    }

    //删除指定用户
    @Override
    public boolean deleteUserByUid(int uid) {
        int count = 0;
        try {
            count = bankDao.deleteUserByUid(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //根据用户id查找用户
    @Override
    public boolean findUserByuid(int uid) {
        int count = 0;
        try {
            count = bankDao.findUserByuid(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //添加银行卡
    @Override
    public boolean addCard(BankCard bankCard) {
        int count = 0;
        try {
            count = bankDao.addCard(bankCard);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //注册新用户
    @Override
    public boolean addUserAndCard(BankUser bankUser, BankCard bankCard) {
        Connection conn = null;
        int addCardLine = 0;
        try {
            conn = ConnUtil.getConnect();
            conn.setAutoCommit(false);  //关闭自动提交事务
            HashMap<String, Integer> hashMap = bankDao.addUser(bankUser);
            int uid = hashMap.get("uid");
            System.out.println("-------------uid = " + uid);
            bankCard.setUid(uid);
            addCardLine = bankDao.addCard(bankCard);
            conn.commit();  //提交事务
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); //事务回滚
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }

        return addCardLine > 0;
    }

    //用户登录
    @Override
    public int userLogin(BankCard bankCard) {
        int cid = 0;
        try {
            cid = bankDao.userLogin(bankCard);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return cid;
    }

    //取钱
    @Override
    public boolean drawMonney(double quMoney, int cid) {
        int count = 0;
        try {
            count = bankDao.drawMonney(quMoney, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //查看余额
    @Override
    public double getNowMoney(int cid) {
        try {
            return bankDao.getNowMoney(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return 0;
    }

    //存钱
    @Override
    public boolean saveMoney(double cunMoney, int cid) {
        int count = 0;
        try {
            count = bankDao.saveMoney(cunMoney, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0;
    }

    //通过卡号查找银行卡
    @Override
    public boolean findCardByCid(int cid) {
        int count = 0;
        try {
            count = bankDao.findCardByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        if (count > 0) {
            BankCard bankCard = showCardByCid(cid);
            System.out.println("你要转账的用户信息如下：");
            System.out.println(bankCard);
            return true;
        } else {
            return false;
        }

    }

    //展示银行卡信息
    @Override
    public BankCard showCardByCid(int cid) {
        try {
            return bankDao.showCardByCid(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return null;
    }

    //转账
    @Override
    public boolean transferMoney(int cid, int cid2, double zhuanMoney) {
        Connection conn = null;
        try {
            conn = ConnUtil.getConnect();
            conn.setAutoCommit(false);
            int drawCount = bankDao.drawMonney(zhuanMoney, cid);
            int saveCount = bankDao.saveMoney(zhuanMoney, cid2);
            conn.commit();
            return drawCount>0 && saveCount>0;
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                ConnUtil.closeConnect();
            }
        }
        return false;
    }
}


package com.gyw.main;

import com.gyw.bean.BankCard;
import com.gyw.bean.BankManager;
import com.gyw.bean.BankUser;
import com.gyw.controller.BankController;

import java.util.*;

/**
 * @author 高源蔚
 * @date 2021-08-25-12:18 PM
 * @describe
 */
public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankController bankController = new BankController();
        System.out.println("欢迎");
        System.out.println("1.管理员登录");
        System.out.println("2.用户登录");
        int key = sc.nextInt();
        switch (key)
        {
            case 1:
                //管理员登录
                BankManager bm = new BankManager();
                /*System.out.println("请输入用户名：");
                bm.setMname(sc.next());
                System.out.println("请输入密码");
                bm.setMpass(sc.next());
                //登录功能
                boolean loginFlag = bankController.managerLogin(bm);*/
                boolean loginFlag = true;
                if (loginFlag) //登录成功
                {
                    while (true)
                    {
                        System.out.println("欢迎"+bm.getMname()+"进入后台管理系统");
                        System.out.println("1.新增用户信息");
                        System.out.println("2.新增银行卡信息");
                        System.out.println("3.修改银行卡密码");
                        System.out.println("4.删除银行卡");
                        System.out.println("5.查看所有银行卡信息");
                        System.out.println("6.根据条件查看银行卡信息");
                        System.out.println("7.查看所有用户信息");
                        System.out.println("8.删除指定用户");
                        System.out.println("0.退出");
                        System.out.println("请输入你的选择：");
                        int key2 = sc.nextInt();
                        switch(key2)
                        {
                            case 1:
                                //新增用户信息
                                BankUser newUser = new BankUser();
                                System.out.println("请输入用户的姓名：");
                                newUser.setUname(sc.next());
                                System.out.println("请输入用户的电话号码：");
                                newUser.setUphone(sc.nextInt());
                                System.out.println("请输入用户的单位：");
                                newUser.setCompany(sc.next());
                                System.out.println("请输入用户的籍贯：");
                                newUser.setHometown(sc.next());
                                boolean addFlag = bankController.addUser(newUser);
                                if(addFlag)
                                {
                                    System.out.println("添加成功!");
                                }else
                                {
                                    System.out.println("添加失败");
                                }
                                break;
                            case 2:
                                //新增银行卡信息
                                System.out.println("请输入你的选择 1.开户 2.注册新用户");
                                int key3 = sc.nextInt();
                                if(key3 == 1) //开户
                                {
                                    System.out.println("请输入用户的id");
                                    int uid = sc.nextInt();
                                    boolean findUserFlag = bankController.findUserByuid(uid); //判断用户是否存在
                                    if(findUserFlag)  //用户存在
                                    {
                                        //添加银行卡
                                        BankCard bankCard = new BankCard();
                                        bankCard.setUid(uid);
                                        while(true)
                                        {
                                            System.out.println("请输入你的银行卡密码：");
                                            int pass = sc.nextInt();
                                            System.out.println("请再次输入你的银行卡密码");
                                            int pass2 = sc.nextInt();
                                            if(pass == pass2)
                                            {
                                                bankCard.setCpassword(pass);
                                                System.out.println("请输入你预存金额：");
                                                bankCard.setCmoney(sc.nextInt());
                                                System.out.println("请选择卡类型： 1.储蓄卡 2.信用卡");
                                                bankCard.setCtype(sc.nextInt()==1?"储蓄卡":"信用卡");
                                                break;
                                            }else
                                            {
                                                System.out.println("两次密码不一致请重新输入!");
                                            }
                                        }
                                        boolean addCardFlag =  bankController.addCard(bankCard);
                                        if(addCardFlag)
                                        {
                                            System.out.println("添加成功！");
                                        }else
                                        {
                                            System.out.println("添加失败！");
                                        }
                                    }else
                                    {
                                        //用户不存在跳转到注册新用户
                                        System.out.println("用户未在本行注册过！");
                                        key3 = 2;
                                    }
                                }
                                if(key3 == 2)
                                {
                                    //注册新用户
                                    BankUser bankUser = new BankUser();
                                    System.out.println("请输入姓名：");
                                    bankUser.setUname(sc.next());
                                    System.out.println("请输入电话：");
                                    bankUser.setUphone(sc.nextInt());
                                    System.out.println("请输入单位：");
                                    bankUser.setCompany(sc.next());
                                    System.out.println("请输入籍贯：");
                                    bankUser.setHometown(sc.next());
                                    BankCard bankCard = new BankCard();
                                    while(true)
                                    {
                                        System.out.println("请输入你的银行卡密码：");
                                        int pass = sc.nextInt();
                                        System.out.println("请再次输入你的银行卡密码");
                                        int pass2 = sc.nextInt();
                                        if(pass == pass2)
                                        {
                                            bankCard.setCpassword(pass);
                                            System.out.println("请输入你预存金额：");
                                            bankCard.setCmoney(sc.nextInt());
                                            System.out.println("请选择卡类型： 1.储蓄卡 2.信用卡");
                                            bankCard.setCtype(sc.nextInt()==1?"储蓄卡":"信用卡");
                                            break;
                                        }else
                                        {
                                            System.out.println("两次密码不一致请重新输入!");
                                        }
                                    }
                                    boolean addUserAndCardFlag = bankController.addUserAndCard(bankUser, bankCard );
                                    if(addUserAndCardFlag)
                                    {
                                        System.out.println("注册成功");
                                    }else
                                    {
                                        System.out.println("注册失败！");
                                    }
                                }
                                break;
                            case 3:
                                //修改银行卡密码
                                BankCard bankCard = new BankCard();
                                System.out.println("请银行卡号");
                                bankCard.setCid(sc.nextInt());
                                System.out.println("请输入原密码");
                                bankCard.setCpassword(sc.nextInt());
                                boolean checkFlag = bankController.checkBankCard(bankCard);
                                if(checkFlag) //密码输入成功
                                {
                                    while(true)  //循环输入新密码
                                    {
                                        System.out.println("请输入新密码：");
                                        int newPass = sc.nextInt();
                                        System.out.println("再次输入新密码");
                                        int newPass2 = sc.nextInt();
                                        if(newPass == newPass2) //两次输入的新密码相同
                                        {
                                            bankCard.setCpassword(newPass);
                                            boolean updateFlag = bankController.updateBankCardPass(bankCard);
                                            if(updateFlag) //修改成功
                                            {
                                                System.out.println("修改成功!");
                                            }else //修改失败
                                            {
                                                System.out.println("修改失败!");
                                            }
                                            break;
                                        }else //两次输入的密码不通过
                                        {
                                            System.out.println("两次密码不同请重输入");
                                        }
                                    }

                                }else //卡号或密码输入错误
                                {
                                    System.out.println("卡号或密码输入错误!");
                                }
                                break;
                            case 4:
                                //删除银行卡
                                System.out.println("请输入你要删除的银行卡号：");
                                int deleteCid = sc.nextInt();
                                boolean deleteCardFlag = bankController.deleteCardByID(deleteCid);
                                if (deleteCardFlag) //删除成功
                                {
                                    System.out.println("删除成功!");
                                }else
                                {
                                    System.out.println("删除失败!");
                                }
                                break;
                            case 5:
                                //查看所有银行卡信息
                                List<BankCard> bankCardList = new ArrayList<>();
                                bankCardList = bankController.showAllCard();
                                for (BankCard card : bankCardList) {
                                    System.out.println(card);
                                }
                                break;
                            case 6:
                                //根据条件查看银行卡信息
                                List<BankCard> bankCards = new ArrayList<BankCard>();
                                System.out.println("手机号 输入0为跳过");
                                int phoneNum = sc.nextInt();
                                System.out.println("类型 1.储蓄卡 2.信用卡 0.跳过");
                                int typeNUm = sc.nextInt();
                                bankCards = bankController.findCardByPhoneAndType(phoneNum,typeNUm);
                                for (BankCard card : bankCards) {
                                    System.out.println(card);
                                }
                                break;
                            case 7:
                                //查看所有用户信息
                                ArrayList<BankUser> allUserList = new ArrayList<>();
                                allUserList = bankController.showAllUser();
                                for (BankUser user : allUserList) {
                                    System.out.println(user);
                                }
                                break;
                            case 8:
                                //删除指定用户
                                System.out.println("请输入你要删除的用户的id");
                                int uid2 = sc.nextInt();
                                boolean deleteUserFlag =  bankController.deleteUserByUid(uid2);
                                if(deleteUserFlag)
                                {
                                    System.out.println("删除成功");
                                }else
                                {
                                    System.out.println("删除失败!");
                                }
                                break;
                            default :
                                System.exit(0); //退出
                                break;
                        }//switch结束
                        System.out.println("请问还要继续吗？y/n");
                        if("n".equalsIgnoreCase(sc.next()))
                        {
                            break;
                        }
                    }//while结束
                }else //登录失败
                {
                    System.out.println("登录失败");
                }
                break;
            case 2:
                //用户登录
                BankCard bankCard = new BankCard();
                System.out.println("请输入银行卡号：");
                bankCard.setCid(sc.nextInt());
                System.out.println("请输入银行卡密码：");
                bankCard.setCpassword(sc.nextInt());
                int cid = bankController.userLogin(bankCard);
                if(cid>0)
                {
                    while(true)
                    {
                        System.out.println("欢迎进入银行ATM系统");
                        System.out.println("1.取钱功能");
                        System.out.println("2.存钱功能");
                        System.out.println("3.转账功能");
                        System.out.println("4.查看银行卡信息");
                        System.out.println("0.退出");
                        System.out.println("请输入你的选择:");
                        int key4 = sc.nextInt();
                        switch(key4)
                        {
                            case 1:
                                //取钱功能
                                double nowMoney = bankController.getNowMoney(cid);
                                System.out.println("银行卡余额为："+nowMoney);
                                System.out.println("请输入取钱金额：");
                                double quMoney = sc.nextDouble();
                                if(nowMoney > quMoney)
                                {
                                    boolean drawFlag = bankController.drawMonney(quMoney, cid);
                                    if(drawFlag)
                                    {
                                        System.out.println("取钱成功!");
                                        System.out.println("银行卡余额为："+(nowMoney-quMoney));
                                    }else
                                    {
                                        System.out.println("取钱失败!");
                                    }
                                }else
                                {
                                    //余额不足
                                    System.out.println("余额补不足");
                                }
                                break;
                            case 2:
                                //存钱功能
                                System.out.println("请输入你要存的金额：");
                                double cunMoney = sc.nextDouble();
                                boolean saveFlag= bankController.saveMoney(cunMoney, cid);
                                if(saveFlag)
                                {
                                    System.out.println("存成功!");
                                }else
                                {
                                    System.out.println("存失败！");
                                }
                                break;
                            case 3:
                                //转账功能
                                while (true)
                                {
                                    System.out.println("请输入你要转帐的卡号：");
                                    int cid2 = sc.nextInt();
                                    boolean findCardFlag =bankController.findCardByCid(cid2);
                                    if (findCardFlag)//银行卡存在，开始转账
                                    {

                                        double nowMoney1 = bankController.getNowMoney(cid);
                                        System.out.println("银行卡余额为："+nowMoney1);
                                        System.out.println("请输入你要转账的金额：");
                                        double zhuanMoney = sc.nextDouble();
                                        if(nowMoney1>zhuanMoney) //余额充足
                                        {
                                            boolean transferMoneyFlag = bankController.transferMoney(cid, cid2, zhuanMoney);
                                            if(transferMoneyFlag)
                                            {
                                                System.out.println("转账成功!");
                                            }else
                                            {
                                                System.out.println("转账失败！");
                                            }
                                            break;
                                        }else //余额不足
                                        {
                                            System.out.println("余额不足！转账失败！");
                                            break;
                                        }
                                    }else //银行卡不存在
                                    {
                                        System.out.println("该银行卡不存在,请重新输入");
                                    }
                                }
                                break;
                            case 4:
                                //查看银行卡信息
                                System.out.println(bankController.findCardByCid(cid));
                                break;
                            default :
                                //退出
                                System.exit(0);
                                break;
                        }//switch结束
                        System.out.println("继续否 y/n");
                        if("n".equalsIgnoreCase(sc.next()))
                        {
                            break;
                        }
                    }//while结束
                }else
                {
                    System.out.println("登录失败！");
                }
                break;
            default:
                System.exit(0);
                break;
        }


    }
}

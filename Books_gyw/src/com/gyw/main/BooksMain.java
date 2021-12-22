package com.gyw.main;

import com.gyw.bean.Books;
import com.gyw.controller.BooksController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:54
 * @describe 启动界面
 */
public class BooksMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BooksController booksController = new BooksController();
        while(true)
        {
            System.out.println("请输入你的选择：1.查询全部图书， 2.新增图书， 3.图书入库， 4.图书出库， 5.退出");
            System.out.println("请输入你的选择:");
            int key = sc.nextInt();
            switch(key)
            {
                case 1:
                    //查询全部图书
                    List<Books> list = booksController.showAllBooks();
                    System.out.println("书号\t 书名\t 作者\t 价格\t 发布日期\t  库存数量\t");
                    for (Books books : list) {
                        System.out.println(books);
                    }
                    break;
                case 2:
                    //新增图书
                    Books newBooks = new Books();
                    System.out.println("请输入你要新增的书名：");
                    newBooks.setName(sc.next());
                    System.out.println("请输入你要新增的作者：");
                    newBooks.setAuthor(sc.next());
                    System.out.println("请输入你要新增的价格：");
                    newBooks.setPrice(sc.nextDouble());

                    System.out.println("请输入你要新增的发布日期：");
                    String dateString = sc.next(); //String类型的日期
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//新建SimpleDateFormate对象
                    java.sql.Date date = null;
                    try {
                        simpleDateFormat.parse(dateString);
                        Date parse = simpleDateFormat.parse(dateString); //将String转化成UtilDate
                        long time = parse.getTime(); //获取总时长
                        date = new java.sql.Date(time); //把UtilDate转化为sqlDate
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    newBooks.setPub_date(date);

                    System.out.println("请输入你要新增的库存数量：");
                    newBooks.setStore(sc.nextInt());
                    boolean addFlag = booksController.addBook(newBooks);
                    if(addFlag)
                    {
                        //添加成功
                        System.out.println("添加成功！");
                    }else
                    {
                        //添加失败
                        System.out.println("添加失败!");
                    }
                    break;
                case 3:
                    //图书入库
                    System.out.println("请输入图书的ID:");
                    int id = sc.nextInt();
                    Books findBooks = booksController.findBookById(id); //查找并返回一个Books对象
                    if(findBooks.getId()>0) //书号是否大于0，判断找没找到书
                    {
                        //找到书
                        System.out.println("书的信息如下:");
                        System.out.println("书号\t 书名\t 作者\t 价格\t 发布日期\t  库存数量\t");
                        System.out.println(findBooks);
                        System.out.println("请输入入库数量：");
                        int inputNum = sc.nextInt();
                        boolean inputFlage = booksController.inputStore(id, inputNum);
                        if (inputFlage)
                        {
                            //修改成功
                            System.out.println("入库成功！");
                        }else
                        {
                            //修改失败
                            System.out.println("入库失败！");
                        }
                    }else
                    {
                        //没有找到
                        System.out.println("没有此书！");
                    }
                    break;
                case 4:
                    //图书出库
                    System.out.println("请输入图书的ID:");
                    int outId = sc.nextInt();
                    Books findBooks2 = booksController.findBookById(outId); //查找并返回一个Books对象
                    if(findBooks2.getId()>0) //书号是否大于0，判断找没找到书
                    {
                        //找到了
                        System.out.println("书的信息如下:");
                        System.out.println("书号\t 书名\t 作者\t 价格\t 发布日期\t  库存数量\t");
                        System.out.println(findBooks2);
                        System.out.println("请输入入库数量：");
                        int outputNum = sc.nextInt();
                        if(outputNum > findBooks2.getStore()) //判断库存够不够
                        {
                            //库存不够
                            System.out.println("库存不够！");
                        }else
                        {
                            //库存够
                            boolean outputFlage = booksController.outputStore(outId, outputNum);//出库
                            if (outputFlage)
                            {
                                //修改成功
                                System.out.println("出库成功！");
                            }else
                            {
                                //修改失败
                                System.out.println("出库失败！");
                            }
                        }
                    }else
                    {
                        //没找到
                        System.out.println("没找到书！");
                    }
                    break;
                default :
                    //退出出
                    System.exit(0);
                    break;
            }//switch结束
            System.out.println("继续否? y/n");
            String flag = sc.next();
            if("n".equalsIgnoreCase(flag))
            {
                break;
            }
        }//while结束
    }

}

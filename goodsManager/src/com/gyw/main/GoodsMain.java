package com.gyw.main;

import com.gyw.bean.Goods;
import com.gyw.bean.GoodsType;
import com.gyw.controller.GoodsController;

import java.util.List;
import java.util.Scanner;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:30
 * @describe
 */
public class GoodsMain {
    public static void main(String[] args) {
        GoodsController goodsController = new GoodsController();
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("1.查看所有商品信息");
            System.out.println("2.新增商品信息");
            System.out.println("3.修改商品信息");
            System.out.println("请输入你的选择：");
            int key = sc.nextInt();
            switch(key)
            {
                case 1:
                    //查看所有商品信息
                    List<Goods> list = goodsController.showAllGoods();
                    for (Goods goods : list) {
                        System.out.println(goods);
                    }
                    break;
                case 2:
                    //新增商品信息
                    Goods goods = new Goods();
                    System.out.println("请输入商品名称：");
                    goods.setGname(sc.next());
                    List<GoodsType> goodsTypes = goodsController.showAllType();
                    for (GoodsType goodsType : goodsTypes) {
                        System.out.println(goodsType);
                    }
                    System.out.println("请选择商品类型：");
                    goods.setType(sc.nextInt());
                    System.out.println("请输入商品的价格:");
                    goods.setPrice(sc.nextDouble());
                    System.out.println("请输入商品的简介：");
                    goods.setBrief(sc.next());
                    boolean addFlag = goodsController.addGoods(goods);
                    if (addFlag)
                    {
                        System.out.println("添加成功!");
                    }else
                    {
                        System.out.println("添加失败!");
                    }
                    break;
                case 3:
                    //修改商品信息
                    System.out.println("请输入你要修改的ID:");
                    int id = sc.nextInt();
                    Goods goods2 = goodsController.findGoodsById(id);
                    System.out.print("商品名称为：("+goods2.getGname()+")"+"请输入商品新名称:");
                    goods2.setGname(sc.next());
                    System.out.println();
                    System.out.print("商品类型为：("+goods2.getTypename()+")"+"请选择商品新类型:");
                    for (GoodsType goodsType : goodsController.showAllType()) {
                        System.out.print(goodsType + " ");
                    }
                    System.out.println();
                    goods2.setType(sc.nextInt());
                    System.out.print("商品价格为：("+goods2.getPrice()+")"+"请输入商品新价格:");
                    goods2.setPrice(sc.nextDouble());
                    System.out.print("商品简介为：("+goods2.getBrief()+")"+"请输入商品新简介:");
                    goods2.setBrief(sc.next());
                    Boolean upateFlag = goodsController.updateGoods(goods2);
                    if (upateFlag)
                    {
                        System.out.println("修改成功!");
                    }else
                    {
                        System.out.println("修改失败!");
                    }
                    break;
                default :
                    System.exit(0);
                    break;
            }//switch结束
            System.out.println("继续否？ y/n");
            if("n".equalsIgnoreCase(sc.next()))
            {
                break;
            }
        }//while结束
    }

}

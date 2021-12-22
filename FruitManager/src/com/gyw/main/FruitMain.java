package com.gyw.main;

import com.gyw.bean.Fruit;
import com.gyw.contriller.FruitController;

import java.util.List;
import java.util.Scanner;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:17
 * @describe
 */
public class FruitMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FruitController fruitController = new FruitController();
        while (true)
        {
            System.out.println("--------水果库存管理系统--------");
            System.out.println("1.添加水果");
            System.out.println("2.水果出库");
            System.out.println("3.显示所有的水果信息");
            System.out.println("0.退出");
            System.out.println("请输入你的选择:");
            int key = sc.nextInt();
            switch(key)
            {
                case 1:
                    //添加水果
                    Fruit fruit2 = new Fruit();
                    System.out.println("请输入类别：");
                    fruit2.setTypename(sc.next());
                    System.out.println("请输入品种：");
                    fruit2.setBreed(sc.next());
                    System.out.println("请输入产地：");
                    fruit2.setArea(sc.next());
                    System.out.println("请输入总重量：");
                    fruit2.setWeight(sc.nextDouble());
                    System.out.println("请输入单价：");
                    fruit2.setPrice(sc.nextDouble());
                    System.out.println("请输入简介：");
                    fruit2.setBrief(sc.next());
                    boolean addFlag =  fruitController.addFruit(fruit2);
                    if (addFlag)
                    {
                        System.out.println("添加成功！");
                    }else
                    {
                        System.out.println("添加失败！");
                    }
                    break;
                case 2:
                    //水果出库
                    System.out.println("请输入出库水果编号：");
                    int id = sc.nextInt();
                    boolean findFlag = fruitController.findFruitBy(id);
                    if(findFlag)
                    {
                        //找到了
                        Fruit fruit = new Fruit();
                        fruit = fruitController.findFruit(id);
                        System.out.println(fruit);
                        System.out.println("请输入要出库的重量:");
                        double chukuWeight = sc.nextDouble();
                        double nowWeight = fruitController.findWeightById(id);
                        if( nowWeight >  chukuWeight)
                        {
                            //库存够
                            boolean chukuFlag = fruitController.chuKu(id, chukuWeight);
                            if (chukuFlag)
                            {
                                System.out.println("出库成功!");
                            }
                            else
                            {
                                System.out.println("出库失败！");
                            }
                        }else
                        {
                            System.out.println("库存不足");
                        }
                    }else
                    {
                        System.out.println("没找到！");
                    }
                    break;
                case 3:
                    //显示所有的水果信息
                    List<Fruit> list =  fruitController.showAllFruit();
                    for (Fruit fruit : list) {
                        System.out.println(fruit);
                    }
                    break;
                default :
                    //退出
                    System.exit(0);
                    break;
            }//switch结束
        }
    }
}

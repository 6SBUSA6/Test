package com.gyw.test;

import com.gyw.bean.Student;
import com.gyw.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

/**
 * @author 高源蔚
 * @date 2021-08-24-5:20 PM
 * @describe
 */
public class Main {
    public static void main(String[] args) {
        StudentDao sdo = new StudentDao();
        Scanner sc = new Scanner(System.in);
       /* StudentDao studao = new StudentDao();
        List<Student> stuList = studao.showAllStudent();
        for (Student student : stuList) {
            System.out.println(student);
        }*/

       /* StudentDao sdo = new StudentDao();
        System.out.println("请输入你要查找的性别:");
        String sex = sc.next();
        List<Student> list = sdo.findStuBySex(sex);
        for (Student student : list) {
            System.out.println(student);
        }*/

        /*StudentDao sdo = new StudentDao();
        Student stu = new Student(10, "王柳", "女", "5033");
        int i = sdo.addStudent(stu);
        if(i>0)
        {
            System.out.println("添加成功");
            List<Student> list = sdo.showAllStudent();
            for (Student student : list) {
                System.out.println(student);
            }
        }*/

        /*System.out.println("请输入你要删除的学号：");
        int sno = sc.nextInt();
        int i = sdo.deleteStuBySno(sno);
        if(i>0)
        {
            System.out.println("删除了"+i+"行");
            List<Student> list = sdo.showAllStudent();
            for (Student student : list) {
                System.out.println("student = " + student);
            }
        }*/

        Student stu = new Student(103, "八嘎", "男", "53001");
        int i = sdo.updateStu(stu);
        if(i > 0)
        {
            System.out.println("修改了"+i+"个学生");
            for (Student student : sdo.showAllStudent()) {
                System.out.println("student = " + student);
            }
        }

    }
}

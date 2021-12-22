package com.gyw.dao.impl;

import com.gyw.bean.Fruit;
import com.gyw.dao.FruitDao;
import com.gyw.service.FruitService;
import com.gyw.util.ConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:14
 * @describe
 */
public class FruitDaoImpl implements FruitDao {

    //展示所有水果
    @Override
    public List<Fruit> showAllFruit() throws SQLException {
        List<Fruit> fruitList = new ArrayList<>();
        Connection conn = ConnUtil.getConnect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from fruit");
        while(rs.next())
        {
            Fruit fruit = new Fruit();
            fruit.setFuitid(rs.getInt(1));
            fruit.setTypename(rs.getString(2));
            fruit.setBreed(rs.getString(3));
            fruit.setArea(rs.getString(4));
            fruit.setBrief(rs.getString(5));
            fruit.setWeight(rs.getDouble(6));
            fruit.setPrice(rs.getDouble(7));
            fruitList.add(fruit);
        }
        return fruitList;
    }

    //添加新水果
    @Override
    public int addFruit(Fruit fruit) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("insert into fruit (typename,breed,area,brief,weight,price) " +
                "values (?,?,?,?,?,?)");
        ps.setString(1,fruit.getTypename());
        ps.setString(2,fruit.getBreed());
        ps.setString(3,fruit.getArea());
        ps.setString(4,fruit.getBrief());
        ps.setDouble(5,fruit.getWeight());
        ps.setDouble(6,fruit.getPrice());
        return ps.executeUpdate();
    }

    //找水果
    @Override
    public int findFruitBy(int id) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        int count = 0;
        PreparedStatement ps = conn.prepareStatement("select count(*) from fruit where fruitid = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
        {
            count = rs.getInt(1);
        }
        return count;
    }

    //显示单个水果
    @Override
    public Fruit findFruit(int id) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select * from fruit where fruitid = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Fruit fruit = new Fruit();
        while (rs.next())
        {
            fruit.setFuitid(rs.getInt(1));
            fruit.setTypename(rs.getString(2));
            fruit.setBreed(rs.getString(3));
            fruit.setArea(rs.getString(4));
            fruit.setBrief(rs.getString(5));
            fruit.setWeight(rs.getDouble(6));
            fruit.setPrice(rs.getDouble(7));
        }
        return fruit;
    }

    //找现有库存
    @Override
    public double findWeightById(int id) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        int nowWeight = 0;
        PreparedStatement ps = conn.prepareStatement("select weight from fruit where fruitid = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            nowWeight = rs.getInt(1);
        }
        return nowWeight;
    }


    //出库
    @Override
    public int chuKu(int id, double chukuWeight) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("update fruit set weight = weight - ? where fruitid = ?");
        ps.setDouble(1,chukuWeight);
        ps.setInt(2,id);
        int i = ps.executeUpdate();
        return i;
    }


}

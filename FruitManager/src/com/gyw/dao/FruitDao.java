package com.gyw.dao;

import com.gyw.bean.Fruit;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:14
 * @describe
 */
public interface FruitDao {
    List<Fruit> showAllFruit() throws SQLException;

    int addFruit(Fruit fruit) throws SQLException;

    int findFruitBy(int id) throws SQLException;

    Fruit findFruit(int id) throws SQLException;

    double findWeightById(int id) throws SQLException;

    int chuKu(int id, double chukuWeight) throws SQLException;
}

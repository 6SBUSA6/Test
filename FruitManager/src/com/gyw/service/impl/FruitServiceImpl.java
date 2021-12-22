package com.gyw.service.impl;

import com.gyw.bean.Fruit;
import com.gyw.dao.FruitDao;
import com.gyw.dao.impl.FruitDaoImpl;
import com.gyw.service.FruitService;
import com.gyw.util.ConnUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:15
 * @describe
 */
public class FruitServiceImpl implements FruitService {
    FruitDaoImpl fruitDao = new FruitDaoImpl();

    //展示所有水果
    @Override
    public List<Fruit> showAllFruit() {
        List<Fruit> fruitList = null;
        try {
            fruitList = fruitDao.showAllFruit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return fruitList;
    }

    //添加新水果
    @Override
    public boolean addFruit(Fruit fruit) {
        int count = 0;
        try {
            count = fruitDao.addFruit(fruit);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count>0;
    }

    @Override
    public boolean findFruitBy(int id) {
        int count = 0;
        try {
            count = fruitDao.findFruitBy(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count>0;
    }


    //显示单个水果
    @Override
    public Fruit findFruit(int id) {
        Fruit fruit = new Fruit();
        try {
            fruit = fruitDao.findFruit(id);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return fruit;
    }

    //返回现有库存
    @Override
    public double findWeightById(int id) {
        double nowWeight = 0;
        try {
            nowWeight = fruitDao.findWeightById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return nowWeight;
    }

    @Override
    public boolean chuKu(int id, double chukuWeight) {
        int count = 0;
        try {
            count = fruitDao.chuKu(id, chukuWeight);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count>0;
    }


}

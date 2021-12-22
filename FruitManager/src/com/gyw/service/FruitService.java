package com.gyw.service;

import com.gyw.bean.Fruit;

import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:16
 * @describe
 */
public interface FruitService {

    List<Fruit> showAllFruit();

    boolean addFruit(Fruit fruit);

    boolean findFruitBy(int id);

    Fruit findFruit(int id);

    double findWeightById(int id);

    boolean chuKu(int id, double chukuWeight);
}

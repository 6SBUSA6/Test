package com.gyw.contriller;

import com.gyw.bean.Fruit;
import com.gyw.service.impl.FruitServiceImpl;

import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/30-14:13
 * @describe
 */
public class FruitController {
    FruitServiceImpl fruitService = new FruitServiceImpl();
    public List<Fruit> showAllFruit() {
        return fruitService.showAllFruit();
    }

    public boolean addFruit(Fruit fruit) {
        return fruitService.addFruit(fruit);
    }

    public boolean findFruitBy(int id) {
        return fruitService.findFruitBy(id);
    }

    public Fruit findFruit(int id) {
        return fruitService.findFruit(id);
    }

    public double findWeightById(int id) {
        return fruitService.findWeightById(id);
    }

    public boolean chuKu(int id, double chukuWeight) {
        return fruitService.chuKu(id, chukuWeight);
    }
}

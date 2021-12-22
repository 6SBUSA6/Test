package com.gyw.service;

import com.gyw.bean.Goods;
import com.gyw.bean.GoodsType;

import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:31
 * @describe
 */
public interface GoodsService {
    List<Goods> showAllGoods();

    List<GoodsType> showAllType();

    boolean addGoods(Goods goods);

    Goods findGoodsById(int id);

    Boolean updateGoods(Goods goods2);
}

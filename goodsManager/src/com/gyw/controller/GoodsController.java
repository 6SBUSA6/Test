package com.gyw.controller;

import com.gyw.bean.Goods;
import com.gyw.bean.GoodsType;
import com.gyw.service.GoodsService;
import com.gyw.service.impl.GoodsServiceImpl;

import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:31
 * @describe
 */
public class GoodsController {
    GoodsServiceImpl goodsService = new GoodsServiceImpl();

    public List<Goods> showAllGoods() {
        return goodsService.showAllGoods();
    }

    public List<GoodsType> showAllType() {
        return goodsService.showAllType();
    }

    public boolean addGoods(Goods goods) {
        return goodsService.addGoods(goods);
    }

    public Goods findGoodsById(int id) {
        return goodsService.findGoodsById(id);
    }

    public Boolean updateGoods(Goods goods2) {
        return goodsService.updateGoods(goods2);
    }
}

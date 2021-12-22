package com.gyw.service.impl;

import com.gyw.bean.Goods;
import com.gyw.bean.GoodsType;
import com.gyw.dao.impl.GoodsDaoImpl;
import com.gyw.service.GoodsService;
import com.gyw.util.ConnUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:32
 * @describe
 */
public class GoodsServiceImpl implements GoodsService {
    GoodsDaoImpl goodsDao = new GoodsDaoImpl();

    //查看所有商品信息
    @Override
    public List<Goods> showAllGoods() {
        List<Goods> list = new ArrayList<>();
        try {
            list = goodsDao.showAllGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return list;
    }

    //展示所有商品类型
    @Override
    public List<GoodsType> showAllType() {
        List<GoodsType> goodsTypeList = new ArrayList<>();
        try {
            goodsTypeList = goodsDao.showAllType();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return goodsTypeList;
    }

    //添加商品信息
    @Override
    public boolean addGoods(Goods goods) {
        int count = 0;
        try {
            count = goodsDao.addGoods(goods);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return count>0;
    }

    //查看一个商品信息
    @Override
    public Goods findGoodsById(int id) {
        Goods goods = new Goods();
        try {
            goods = goodsDao.findGoodsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return goods;
    }

    //修改商品信息
    @Override
    public Boolean updateGoods(Goods goods2) {
        int count = 0;
        try {
            count = goodsDao.updateGoods(goods2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConn();
        }
        return count>0;
    }
}














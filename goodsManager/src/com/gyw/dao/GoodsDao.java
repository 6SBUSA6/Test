package com.gyw.dao;

import com.gyw.bean.Goods;
import com.gyw.bean.GoodsType;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:32
 * @describe
 */
public interface GoodsDao {
    List<Goods> showAllGoods() throws SQLException;

    List<GoodsType> showAllType() throws SQLException;

    int addGoods(Goods goods) throws SQLException;

    Goods findGoodsById(int id) throws SQLException;

    int updateGoods(Goods goods2) throws SQLException;
}

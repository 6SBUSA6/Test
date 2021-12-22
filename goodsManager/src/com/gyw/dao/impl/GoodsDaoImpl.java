package com.gyw.dao.impl;

import com.gyw.bean.Goods;
import com.gyw.bean.GoodsType;
import com.gyw.dao.GoodsDao;
import com.gyw.util.ConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:34
 * @describe
 */
public class GoodsDaoImpl implements GoodsDao {

    //查看所有商品信息
    @Override
    public List<Goods> showAllGoods() throws SQLException {
        Connection conn = ConnUtil.getConn();
        ArrayList<Goods> goodsList = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from goods g, goodstype t where g.type = t.tid ");
        while (rs.next())
        {
            Goods goods = new Goods();
            goods.setGid(rs.getInt(1));
            goods.setGname(rs.getString(2));
            goods.setTypename(rs.getString("tname"));
            goods.setPrice(rs.getDouble(4));
            goods.setBrief(rs.getString(5) == null ? "无" : rs.getString(5));
            goodsList.add(goods);
        }
        return goodsList;
    }

    //展示所有商品类型
    @Override
    public List<GoodsType> showAllType() throws SQLException {
        Connection conn = ConnUtil.getConn();
        List<GoodsType> goodsTypeList = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from goodstype ");
        while (rs.next())
        {
            GoodsType goodsType = new GoodsType();
            goodsType.setTid(rs.getInt(1));
            goodsType.setTname(rs.getString(2));
            goodsTypeList.add(goodsType);
        }
        return goodsTypeList;
    }

    //添加商品信息
    @Override
    public int addGoods(Goods goods) throws SQLException {
        Connection conn = ConnUtil.getConn();
        PreparedStatement ps = conn.prepareStatement("insert into goods(gname, type, price, brief) values (?,?,?,?)");
        ps.setString(1,goods.getGname());
        ps.setInt(2,goods.getType());
        ps.setDouble(3,goods.getPrice());
        ps.setString(4,goods.getBrief());
        return ps.executeUpdate();
    }

    //展示一个商品信息
    @Override
    public Goods findGoodsById(int id) throws SQLException {
        Connection conn = ConnUtil.getConn();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from goods g, goodstype t where g.type = t.tid ");
        Goods goods = new Goods();
        while (rs.next())
        {
            goods.setGid(rs.getInt(1));
            goods.setGname(rs.getString(2));
            goods.setType(rs.getInt(3));
            goods.setTypename(rs.getString("tname"));
            goods.setPrice(rs.getDouble(4));
            goods.setBrief(rs.getString(5) == null ? "无" : rs.getString(5));
        }
        return goods;
    }

    //修改商品信息
    @Override
    public int updateGoods(Goods goods2) throws SQLException {
        Connection conn = ConnUtil.getConn();
        PreparedStatement ps = conn.prepareStatement("update goods set gname = ?, type = ?, price = ?, brief = ? where gid = ?");
        ps.setString(1,goods2.getGname());
        ps.setInt(2,goods2.getType());
        ps.setDouble(3,goods2.getPrice());
        ps.setString(4,goods2.getBrief());
        ps.setInt(5,goods2.getGid());
        return ps.executeUpdate();
    }


}

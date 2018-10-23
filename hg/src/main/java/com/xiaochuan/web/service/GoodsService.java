package com.xiaochuan.web.service;

import com.xiaochuan.web.entity.Goods;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface GoodsService {
    int addGoods(Goods goods);
    int updateGoods(Goods goods);
    Goods getGoodsById(int id);
    List<Goods> getAllGoods();
    void deleteGoods(int id);
}

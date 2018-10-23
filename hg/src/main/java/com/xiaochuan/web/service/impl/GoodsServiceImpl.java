package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.GoodsMapper;
import com.xiaochuan.web.entity.Goods;
import com.xiaochuan.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
@CacheConfig(cacheNames = "goods")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    @Override
    @Cacheable(key="#id")
    public Goods getGoodsById(int id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.selectList(null);
    }

    @Override
    @CacheEvict(key="#id")
    public void deleteGoods(int id) {
        goodsMapper.deleteById(id);
    }
}

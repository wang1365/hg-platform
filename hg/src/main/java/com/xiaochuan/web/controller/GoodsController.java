package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.entity.Goods;
import com.xiaochuan.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/web/goods/addGoods", method = RequestMethod.POST)
    TraceResponse<Goods> addGoods(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        return TraceResponse.success(goods);
    }

    @RequestMapping(value = "/web/goods/updateGoods", method = RequestMethod.POST)
    TraceResponse<Goods> updateGoods(@RequestBody Goods goods) {
        goodsService.updateGoods(goods);
        return TraceResponse.success(goods);
    }

    @RequestMapping(value = "/web/goods/deleteGoods", method = RequestMethod.POST)
    TraceResponse deleteGoods(@RequestParam int id) {
        goodsService.deleteGoods(id);
        return TraceResponse.success();
    }

    @RequestMapping(value = "/web/goods/getGoodsList", method = RequestMethod.GET)
    TraceResponse<List<Goods>> getGoodsList() {
        return TraceResponse.success(goodsService.getAllGoods());
    }
}

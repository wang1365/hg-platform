package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.GoodsDTO;
import com.hg.web.dto.GoodsInboundDto;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsInbound;
import com.hg.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goods/addGoods", method = RequestMethod.POST)
    HgResponse<Goods> addGoods(@RequestBody Goods goods) {
        goodsService.save(goods);
        return HgResponse.success(goods);
    }

    @RequestMapping(value = "/goods/updateGoods", method = RequestMethod.POST)
    HgResponse<Goods> updateGoods(@RequestBody Goods goods) {
        goodsService.updateById(goods);
        return HgResponse.success(goods);
    }

    @RequestMapping(value = "/goods/deleteGoods", method = RequestMethod.POST)
    HgResponse deleteGoods(@RequestParam long id) {

        goodsService.removeById(id);
        return HgResponse.success();
    }

    @RequestMapping(value = "/goods/getGoodsList", method = RequestMethod.GET)
    HgResponse<List<GoodsDTO>> getGoodsList() {
        return HgResponse.success(goodsService.listGoodsDetail());
    }

    @RequestMapping(value = "/goods/getGoodsByBarCode")
    HgResponse<GoodsDTO> getGoodsByBarCode(@RequestParam String barCode) {
        GoodsDTO dto = goodsService.selectByBarCode(barCode);
        return HgResponse.success(dto);
    }

}

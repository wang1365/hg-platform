package com.hg.web.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hg.web.common.HgResponse;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsBrand;
import com.hg.web.service.GoodsBrandService;
import com.hg.web.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:44
 * @description:
 */
@RestController
@RequestMapping("/web/goods")
public class GoodsBrandController {
    @Autowired
    private GoodsBrandService goodsBrandService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("getGoodsBrandList")
    HgResponse getGoodsBrandList() {
        return HgResponse.success(goodsBrandService.list(null));
    }

    @PostMapping("addGoodsBrand")
    HgResponse addGoodsBrand(@RequestBody GoodsBrand goodsBrand) {
        goodsBrandService.save(goodsBrand);
        return HgResponse.success();
    }

    @PostMapping("updateGoodsBrand")
    HgResponse updateGoodsBrand(@RequestBody GoodsBrand goodsBrand) {
        goodsBrandService.updateById(goodsBrand);
        return HgResponse.success();
    }

    @PostMapping("deleteGoodsBrand")
    HgResponse deleteGoodsBrand(int id) {
        Goods goods = new Goods();
        goods.setBrandId(id);
        if (goodsService.getOne(new QueryWrapper<>(goods)) != null) {
            return HgResponse.fail("当前商品品牌已被使用，无法删除!");
        }
        goodsBrandService.removeById(id);
        return HgResponse.success();
    }
}
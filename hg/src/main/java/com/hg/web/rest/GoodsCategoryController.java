package com.hg.web.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hg.web.common.HgResponse;
import com.hg.web.entity.Goods;
import com.hg.web.entity.GoodsCategory;
import com.hg.web.service.GoodsCategoryService;
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
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("getGoodsCategoryList")
    HgResponse getGoodsCategoryList() {
        return HgResponse.success(goodsCategoryService.list(null));
    }

    @PostMapping("addGoodsCategory")
    HgResponse addGoodsCategory(@RequestBody GoodsCategory goodsCategory) {
        goodsCategoryService.save(goodsCategory);
        return HgResponse.success();
    }

    @PostMapping("updateGoodsCategory")
    HgResponse updateGoodsCategory(@RequestBody GoodsCategory goodsCategory) {
        goodsCategoryService.updateById(goodsCategory);
        return HgResponse.success();
    }

    @PostMapping("deleteGoodsCategory")
    HgResponse deleteGoodsCategory(int id) {
        Goods goods = new Goods();
        goods.setCatId(id);
        if (goodsService.getOne(new QueryWrapper<>(goods)) != null) {
            return HgResponse.fail("当前分类已被使用，无法删除!");
        }

        goodsCategoryService.removeById(id);
        return HgResponse.success();
    }
}
package com.hg.web.controller;

import com.hg.web.common.HgResponse;
import com.hg.web.entity.GoodsCategory;
import com.hg.web.service.GoodsCategoryService;
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
        goodsCategoryService.removeById(id);
        return HgResponse.success();
    }
}
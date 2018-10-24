package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.HgResponse;
import com.xiaochuan.web.service.GoodsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/24 10:44
 * @description:
 */
@RestController
@RequestMapping("/goodsCategory/")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @GetMapping("getGoodsCategoryList")
    HgResponse getGoodsCategoryList() {
        return HgResponse.success(goodsCategoryService.list(null));
    }
}
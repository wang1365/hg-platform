package com.hg.promotion.rest;

import com.hg.promotion.entity.Promotion;
import com.hg.promotion.service.PromotionService;
import com.hg.web.common.HgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:45
 * @description:
 */
@RestController
@RequestMapping("/web/promotion")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("getPromotionList")
    HgResponse<List<Promotion>> getPromotionList() {
        return HgResponse.success(promotionService.list(null));
    }
}
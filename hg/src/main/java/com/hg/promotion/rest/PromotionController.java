package com.hg.promotion.rest;

import com.hg.promotion.dto.PromotionDTO;
import com.hg.promotion.entity.Promotion;
import com.hg.promotion.service.PromotionService;
import com.hg.web.common.HgResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("addPromotion")
    HgResponse addPromotion(@RequestBody PromotionDTO promotionDTO) {
        promotionService.addPromotionDetail(promotionDTO);
        return HgResponse.success();
    }

    @PostMapping("updatePromotion")
    HgResponse updatePromotion(@RequestBody PromotionDTO promotionDTO) {
        promotionService.updateById(promotionDTO);
        return HgResponse.success();
    }

    @PostMapping("deletePromotionByIdAndRuleType")
    HgResponse deletePromotionByIdAndRuleType(@RequestParam int id, @RequestParam int ruleType) {
        promotionService.removeByIdAndRuleType(id, ruleType);
        return HgResponse.success();
    }
}
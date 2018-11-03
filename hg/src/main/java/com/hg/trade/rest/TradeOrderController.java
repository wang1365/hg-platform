package com.hg.trade.rest;

import com.hg.web.common.HgResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/3 15:54
 * @description: 订单服务
 */
@RestController
@RequestMapping("/api/v1.0/")
public class TradeOrderController {

    /**
     * 用户下单
     * @return
     */
    @PostMapping("placeOrder")
    HgResponse placeOrder() {
        return null;
    }
}
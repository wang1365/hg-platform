package com.hg.trade.rest;

import com.hg.web.common.HgResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/3 15:57
 * @description: 用户服务
 */
@RestController
@RequestMapping("/api/v1.0")
public class TradeUserController {
    /**
     * 用户注册
     * @return
     */
    @PostMapping("register")
    HgResponse register() {
        return null;
    }
}
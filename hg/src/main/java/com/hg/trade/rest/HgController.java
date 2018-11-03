package com.hg.trade.rest;

import com.hg.web.common.HgResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/3 15:56
 * @description: 货柜控制服务
 */
@RestController
@RequestMapping("/web/v1.0/hg")
public class HgController {
    /**
     * 货柜开门
     * @param hgCode 货柜代码
     * @return
     */
    @PostMapping("open")
    HgResponse open(@RequestBody String hgCode) {
        return null;
    }
}
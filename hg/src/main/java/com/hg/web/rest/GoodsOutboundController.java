package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.GoodsOutboundDto;
import com.hg.web.entity.GoodsOutbound;
import com.hg.web.service.GoodsOutboundService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/goods")
public class GoodsOutboundController {

    @Autowired
    private GoodsOutboundService goodsOutboundService;


    // 应该由配送人员提交出库操作
    @PostMapping("/outbound")
    HgResponse outbound(@RequestBody GoodsOutboundDto goodsOutboundDto) {
        return HgResponse.success(goodsOutboundService.outbound(goodsOutboundDto));
    }

    @GetMapping("/getGoodsOutboundList")
    HgResponse<List<GoodsOutbound>> getGoodsOutboundList() {
        return HgResponse.success(goodsOutboundService.list(null));
    }

}
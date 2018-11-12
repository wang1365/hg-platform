package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.GoodsInboundDetailDto;
import com.hg.web.dto.GoodsInboundDto;
import com.hg.web.entity.GoodsInbound;
import com.hg.web.service.GoodsInboundDetailService;
import com.hg.web.service.GoodsInboundService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/goods")
public class GoodsInboundController {
    @Autowired
    private GoodsInboundService goodsInboundService;

    @Autowired
    private GoodsInboundDetailService goodsInboundDetailService;

    // 应该由配送人员提交入库操作
    @PostMapping("/inbound")
    HgResponse inbound(@RequestBody GoodsInboundDto goodsInboundDto) {
        return HgResponse.success(goodsInboundService.inbound(goodsInboundDto));
    }

    @GetMapping("/getGoodsInboundList")
    HgResponse<List<GoodsInbound>> getGoodsInboundList() {
        return HgResponse.success(goodsInboundService.list(null));
    }

    @GetMapping("/getGoodsInboundDetail")
    HgResponse<List<GoodsInboundDetailDto>> getGoodsInboundDetail(long id) {
        return HgResponse.success(goodsInboundDetailService.listDetailsById(id));
    }
}
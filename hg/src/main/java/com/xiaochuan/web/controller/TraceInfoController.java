package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.dto.TraceInfoDTO;
import com.xiaochuan.web.service.TraceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/8 10:55
 * @description:
 */
@RestController
@RequestMapping("/api/v1.0/")
public class TraceInfoController {
    @Autowired
    TraceInfoService traceInfoService;

    /**
     * @param orderId 订单ID
     * @return
     */
    @GetMapping("/trace/getTraceInfoByOrder")
    TraceResponse<TraceInfoDTO> getTraceInfoByOrder(int orderId) {
        TraceResponse res;
        if (orderId <= 0) {
            res = TraceResponse.fail("Invalid order id");
        } else {
            TraceInfoDTO traceInfoDTO = traceInfoService.getTraceInfoByOrder(orderId);
            res = TraceResponse.success(traceInfoDTO);
        }

        return res;
    }
}
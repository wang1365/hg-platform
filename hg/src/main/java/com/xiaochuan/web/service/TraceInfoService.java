package com.xiaochuan.web.service;

import com.xiaochuan.web.dto.TraceInfoDTO;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/8 10:55
 * @description:
 */
public interface TraceInfoService {
    TraceInfoDTO getTraceInfoByOrder(int orderId);
}

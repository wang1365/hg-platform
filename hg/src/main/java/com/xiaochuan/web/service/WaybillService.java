package com.xiaochuan.web.service;

import com.xiaochuan.web.entity.Waybill;

import java.util.List;

/**
 * @author gaorongjun
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
public interface WaybillService {
    int addWaybill(Waybill waybill);
    int updateWaybill(Waybill waybill);
    List<Waybill> getAllWaybills();
    void deleteWaybill(int id);
}

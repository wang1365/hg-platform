package com.xiaochuan.web.controller;

import com.xiaochuan.web.common.TraceResponse;
import com.xiaochuan.web.entity.Waybill;
import com.xiaochuan.web.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaorongjun
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@RestController
@RequestMapping("/web/waybill/")
public class WaybillController {

    @Autowired
    private WaybillService waybillService;

    @GetMapping("getWaybillList")
    public TraceResponse<List<Waybill>> getWaybillList() {
        return TraceResponse.success(waybillService.getAllWaybills());
    }

    @PostMapping("addWaybill")
    public TraceResponse<Waybill> addWaybill(@RequestBody Waybill waybill) {
        waybillService.addWaybill(waybill);
        return TraceResponse.success(waybill);
    }

    @PostMapping("updateWaybill")
    public TraceResponse updateWaybill(@RequestBody Waybill waybill) {
        return TraceResponse.success(waybillService.updateWaybill(waybill));
    }

    @PostMapping("deleteWaybill")
    public TraceResponse deleteWaybill(@RequestParam int id) {
        waybillService.deleteWaybill(id);
        return TraceResponse.success();
    }
}

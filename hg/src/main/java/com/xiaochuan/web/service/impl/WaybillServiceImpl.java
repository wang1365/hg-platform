package com.xiaochuan.web.service.impl;

import com.xiaochuan.web.repository.WaybillMapper;
import com.xiaochuan.web.entity.Waybill;
import com.xiaochuan.web.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaorongjun
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Service
public class WaybillServiceImpl implements WaybillService {

    @Autowired
    private WaybillMapper waybillMapper;

    @Override
    public int addWaybill(Waybill waybill) {
        return waybillMapper.insert(waybill);
    }

    @Override
    public int updateWaybill(Waybill waybill) {
        return waybillMapper.updateById(waybill);
    }

    @Override
    public List<Waybill> getAllWaybills() {
        return waybillMapper.selectList(null);
    }

    @Override
    public void deleteWaybill(int id) {
        waybillMapper.deleteById(id);
    }
}

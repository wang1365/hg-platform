package com.hg.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.web.dto.VendingMachineDto;
import com.hg.web.entity.VendingMachine;
import java.util.List;

public interface VendingMachineService extends IService<VendingMachine> {
    List<VendingMachineDto> listVendingMachines();
}

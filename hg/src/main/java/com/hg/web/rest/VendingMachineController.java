package com.hg.web.rest;

import com.hg.web.common.HgResponse;
import com.hg.web.dto.VendingMachineDto;
import com.hg.web.entity.VendingMachine;
import com.hg.web.service.VendingMachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/vm/")
public class VendingMachineController {

    @Autowired
    private VendingMachineService vmService;

    @GetMapping("/getVms")
    public HgResponse<List<VendingMachineDto>> getVendingMachines() {
        return HgResponse.success(vmService.listVendingMachines());
    }

    @PostMapping("/updateVm")
    public HgResponse<VendingMachineDto> updateArea(@RequestBody VendingMachineDto machineDto) {
        vmService.updateById(machineDto);
        return HgResponse.success(machineDto);
    }

    @PostMapping("/{machineId}/enable")
    public HgResponse enableVendingMachine(@PathVariable Long machineId, @RequestParam Boolean enabled) {
        VendingMachine machine = vmService.getById(machineId);
        machine.setEnabled(enabled);
        return HgResponse.success(vmService.updateById(machine));
    }

    @PostMapping("/addVm")
    public HgResponse addVeningMachine(@RequestBody VendingMachineDto machineDto) {
        return HgResponse.success(vmService.save(machineDto));
    }

}

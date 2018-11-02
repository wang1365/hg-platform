package com.hg.web.dto;

import com.hg.web.entity.VendingMachine;
import lombok.Data;

@Data
public class VendingMachineDto extends VendingMachine {

    private String areaName;
    private String headName;
    private String distributionName;
}

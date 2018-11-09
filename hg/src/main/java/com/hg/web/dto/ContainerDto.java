package com.hg.web.dto;

import com.hg.web.entity.Container;
import lombok.Data;

@Data
public class ContainerDto extends Container {

    private String areaName;
    private String headName;
    private String distributionName;
}

package com.hg.web.dto;

import java.util.Map;
import lombok.Data;

@Data
public class InstockDto {

    private Long areaId;
    private Long vmId;
    private Map<String, Integer> goods;


}

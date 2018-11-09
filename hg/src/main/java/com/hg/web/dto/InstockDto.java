package com.hg.web.dto;

import java.util.Map;
import lombok.Data;

@Data
public class InstockDto {

    // 配送人员ID
    private Long personId;
    // 入库货柜的片区ID
    private Long areaId;
    private Long vmId;
    private Map<String, Integer> goods;

}

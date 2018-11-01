package com.hg.web.dto;

import com.hg.web.entity.Area;
import lombok.Data;

@Data
public class AreaDto extends Area {

    private String companyName;

    private String headName;
    private String headPhone;

}

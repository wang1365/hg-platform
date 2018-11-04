package com.hg.web.entity;

import lombok.Data;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 16:28
 */
@Data
public class Region extends BaseEntity {
    private String name;
    private String shortName;
    /**
     * 行政地区编号
     */
    private String code;
    /**
     * 地区父id
     */
    private Long parentId;
    /**
     * 地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县
     */
    private Integer level;
}
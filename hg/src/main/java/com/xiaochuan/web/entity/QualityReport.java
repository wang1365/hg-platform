package com.xiaochuan.web.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 16:28
 */
@Getter
@Setter
public class QualityReport {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;

    String title;
    /**
     * 检验的商品
     */
    private Integer goodsId;


    /**
     * 上传后的质检报告的静态资源路径
     */
    private String path;

    /**
     * 检验商品的产地
     */
    private String origin;

    /**
     * 检测机构名称
     */
    private String orgName;

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 质检日期
     */
    private Date reportDate;

    private String description;
}

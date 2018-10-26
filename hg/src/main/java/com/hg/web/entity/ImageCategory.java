package com.hg.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 11:07
 * @description:
 */
@Data
public class ImageCategory {
    @TableId(value = "id", type= IdType.AUTO)
    private Integer id;
    private String name;
    private String localPath;
    private String urlPath;
    private String description;
    /**
     * 0: online 1:dev
     */
    private Integer profileType;
}
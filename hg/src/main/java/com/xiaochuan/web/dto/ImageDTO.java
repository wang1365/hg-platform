package com.xiaochuan.web.dto;

import com.xiaochuan.web.entity.Image;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/4 10:48
 * @description:
 */
@Data
public class ImageDTO extends Image {
    private String catName;
}
package com.xiaochuan.web.dto;

import com.xiaochuan.web.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/3 21:22
 * @description:
 */
@Data
@AllArgsConstructor
public class GoodsQrcode {
    private Goods goods;
    private String qrcodeUrl;
}
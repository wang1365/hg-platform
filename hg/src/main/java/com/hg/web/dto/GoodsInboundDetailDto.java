package com.hg.web.dto;

import com.hg.web.entity.GoodsInboundDetail;
import lombok.Data;


@Data
public class GoodsInboundDetailDto extends GoodsInboundDetail {

    private String goodsName;
    private String goodsBarCode;

}

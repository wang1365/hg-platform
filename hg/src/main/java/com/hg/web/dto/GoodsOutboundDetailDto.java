package com.hg.web.dto;

import com.hg.web.entity.GoodsOutboundDetail;
import lombok.Data;


@Data
public class GoodsOutboundDetailDto extends GoodsOutboundDetail {

    private String goodsName;
    private String goodsBarCode;

}

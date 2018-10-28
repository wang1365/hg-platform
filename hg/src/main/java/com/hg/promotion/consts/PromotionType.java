package com.hg.promotion.consts;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/28 12:25
 * @description:
 */
public enum PromotionType {
    /**
     * 促销类型
     */
    FIRST_REDUCTION(1, "首单立减"),
    FULL_REDUCTION(2, "商品满减"),
    RANDOM_REDUCTION(3, "随机立减"),
    DISCOUNT(4, "优惠折扣");

    private int code;
    private String message;

    PromotionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

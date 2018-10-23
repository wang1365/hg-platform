package com.xiaochuan.consts;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/7 11:10
 * @description:
 */
public enum  PlantItemActionType {
    /**
     * 种植详情条目类型
     */
    PICK(8, "采摘"),
    ;
    private int code;
    private String name;

    PlantItemActionType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
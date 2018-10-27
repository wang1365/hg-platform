package com.hg.web.common;


import lombok.Getter;

import java.util.Date;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Getter
@SuppressWarnings("unchecked")
public class HgResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;
    private final Date timestamp;

    private HgResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = new Date(System.currentTimeMillis());
    }

    public static HgResponse fail() {
        return new HgResponse(false, "", null);
    }

    public static HgResponse fail(String message) {
        return new HgResponse<>(false, message, null);
    }

    public static <T> HgResponse<T> fail(String message, T data) {
        return new HgResponse<>(false, message, data);
    }

    public static HgResponse success() {
        return new HgResponse<>(true, "", null);
    }

    public static <T> HgResponse<T> success(T data) {
        return new HgResponse(true, "", data);
    }

    public static <T> HgResponse<T> success(String message, T data) {
        return new HgResponse<>(true, message, data);
    }
}

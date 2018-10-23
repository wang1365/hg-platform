package com.xiaochuan.web.common;


import lombok.Getter;

import java.util.Date;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:53
 */
@Getter
@SuppressWarnings("unchecked")
public class TraceResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;
    private final Date timestamp;

    private TraceResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = new Date(System.currentTimeMillis());
    }

    public static TraceResponse fail() {
        return new TraceResponse(false, "", null);
    }

    public static TraceResponse fail(String message) {
        return new TraceResponse(false, message, null);
    }

    public static <T> TraceResponse fail(String message, T data) {
        return new TraceResponse(false, message, data);
    }

    public static TraceResponse success() {
        return new TraceResponse(true, "", null);
    }

    public static <T> TraceResponse success(T data) {
        return new TraceResponse(true, "", data);
    }

    public static <T> TraceResponse success(String message, T data) {
        return new TraceResponse(true, message, data);
    }
}

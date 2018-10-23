package com.xiaochuan.web.service.impl;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 15:12
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.hg.web.service.impl;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 15:11
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

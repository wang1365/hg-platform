package com.hg.utils;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/10/5 10:44
 * @description:
 */
public final class OsUtil {
    private static final boolean IS_LINUX;
    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            IS_LINUX = false;
        } else {
            IS_LINUX = true;
        }
    }

    public static boolean isLinux() {
        return IS_LINUX;
    }
}
package com.hg.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/22 9:43
 */
@Slf4j
public class DatetimeUtil {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    public static LocalDate parseToLocalDate(String s) {
        return LocalDate.parse(s, formatter);
    }
    public static Date parseToDate(String s) {
        Date date = null;
        try {
            date =  dateFormatter.parse(s);
        } catch (ParseException e) {
            log.error("Invalid date format: {}", s);
        }
        return date;
    }
    public static String formatDate(Date date) { return new SimpleDateFormat("yyyy-MM-dd").format(date);}
    public static String formatDateTime(Date dt) { return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);}
}

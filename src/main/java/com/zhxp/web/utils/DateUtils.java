package com.zhxp.web.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhh on 2017/4/20.
 */
public class DateUtils {
    /**
     * 获取当前时间
     * @return		当前时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public static String getCurTime() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

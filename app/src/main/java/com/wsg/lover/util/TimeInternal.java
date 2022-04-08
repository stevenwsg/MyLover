package com.wsg.lover.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create on 2022/4/8.
 *
 * @author wangshengguo.
 */
public class TimeInternal {

    /**
     * 计算两个时间点的时间间隔
     */
    public static int daysBetween(String date1str, String date2str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(date1str);
        Date date2 = format.parse(date2str);
        int a = (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
        return a;
    }
}

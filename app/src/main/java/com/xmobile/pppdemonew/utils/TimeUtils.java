package com.xmobile.pppdemonew.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * time :2019/8/14 17:14
 * version:1.0
 * 黄卫华(wayhua@126.com)
 */
public class TimeUtils {

    private static final ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        } catch (ParseException var3) {
            return null;
        }

    }

    public static String toStr(Date date) {
        return dateFormater.get().format(date);
    }

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM/dd");
        }
    };
    private final static ThreadLocal<SimpleDateFormat> dateFormater3 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm");
        }
    };

    public static String friendly_time(Date time) {
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {

            ftime = dateFormater3.get().format(time);
        }

        else {
            ftime = dateFormater2.get().format(time);
        }
        return ftime;
    }

}

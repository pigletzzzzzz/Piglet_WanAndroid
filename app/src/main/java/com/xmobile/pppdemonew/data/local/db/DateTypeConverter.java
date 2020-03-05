package com.xmobile.pppdemonew.data.local.db;




import com.xmobile.pppdemonew.utils.TimeUtils;

import java.util.Date;

import androidx.room.TypeConverter;


public class DateTypeConverter {

    @TypeConverter
    public static Date toDate(String ts) {
        return ts == null ? null : TimeUtils.toDate(ts);
    }

    @TypeConverter
    public static String toTimestamp(Date date) {
        return date == null ? null : TimeUtils.toStr(date);
    }
}


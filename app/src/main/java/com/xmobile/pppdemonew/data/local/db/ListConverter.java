package com.xmobile.pppdemonew.data.local.db;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xmobile.xretrofit.gson.GsonUtils;

import java.util.List;

import androidx.room.TypeConverter;

/**
 * Created by 黄卫华(wayhua@126.com) on 2018/2/5.
 */

public class ListConverter {


    static Gson gson = GsonUtils.getGson();

    @TypeConverter
    public static List<String> toList(String ts) {
        return gson.fromJson(ts, new TypeToken<List<String>>() {
        }.getType());
    }

    @TypeConverter
    public static String toGson(List<String> list) {
        return list == null ? null : gson.toJson(list);
    }
}

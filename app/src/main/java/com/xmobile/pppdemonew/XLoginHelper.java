package com.xmobile.pppdemonew;

import android.content.Context;
import android.text.TextUtils;

import com.xmobile.xframework.utils.SharedPreferencesUtils;


/**
 * Created by 黄卫华(wayhua@126.com) on 2019/11/1 0001.
 */
public class XLoginHelper {
    private static final String REFRESH_TOKEN = "Refresh_Token";

    public static String getRefresh_token(Context context) {
        String result = SharedPreferencesUtils.getT(context.getApplicationContext(), REFRESH_TOKEN, "");
        return result;

    }

    public static void setRefresh_token(Context context, String refresh_token) {
        if (TextUtils.isEmpty(refresh_token)) {
            SharedPreferencesUtils.remove(context.getApplicationContext(), REFRESH_TOKEN);
        } else {
            SharedPreferencesUtils.putT(context.getApplicationContext(), REFRESH_TOKEN, refresh_token);
        }

    }
}

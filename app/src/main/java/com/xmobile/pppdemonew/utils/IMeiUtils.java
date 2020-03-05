package com.xmobile.pppdemonew.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.xmobile.xframework.utils.SharedPreferencesUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by 黄卫华(wayhua@126.com) on 2019/10/8 0008.
 */
public class IMeiUtils {
    public static String getIMei(Context context) {
        String imei = "";
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                imei = tm.getDeviceId();
            } else {
                Method method = tm.getClass().getMethod("getImei");
                imei = (String) method.invoke(tm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (TextUtils.isEmpty(imei)) {
            String android_id = Settings.System.getString(
                    context.getContentResolver(), Settings.Secure.ANDROID_ID);
            imei = android_id;
        }

        if ("9774d56d682e549c".equals(imei)) {

            String sid = SharedPreferencesUtils.getT(context.getApplicationContext(), "IMEI", "");
            if (TextUtils.isEmpty(sid)) {

                sid = UUID.randomUUID().toString();
                SharedPreferencesUtils.putT(context.getApplicationContext(), "IMEI", sid);
            }
            imei = sid;

        }

        if (TextUtils.isEmpty(imei)) {
            String sid = SharedPreferencesUtils.getT(context.getApplicationContext(), "IMEI", "");
            if (TextUtils.isEmpty(sid)) {

                sid = UUID.randomUUID().toString();
                SharedPreferencesUtils.putT(context.getApplicationContext(), "IMEI", sid);
            }
            imei = sid;
        }

        return imei;
    }
}

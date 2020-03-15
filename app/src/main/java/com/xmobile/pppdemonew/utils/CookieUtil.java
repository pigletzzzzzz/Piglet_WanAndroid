package com.xmobile.pppdemonew.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/9
 */
public class CookieUtil {
    public static void clear(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            CookieSyncManager.createInstance(context);
            CookieManager.getInstance().removeAllCookie();
            CookieSyncManager.getInstance().sync();
        } else {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
        }
    }

    public static void setCookie(Context context, boolean immediately, String url, Map<String, String> values) {
        Set<Map.Entry<String, String>> entries = values.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            list.add(key + "=" + value + ";");
        }
        setCookie(context, immediately, url, list);
    }

    public static void setCookieMaxAge(Context context, boolean immediately, String url, String key, String value, int maxAge) {
        setCookie(context, immediately, url, key, value, maxAge, "", "", false, false);
    }

    public static void setCookieDomain(Context context, boolean immediately, String url, String key, String value, String domain) {
        setCookie(context, immediately, url, key, value, 0, domain, "", false, false);
    }

    public static void setCookiePath(Context context, boolean immediately, String url, String key, String value, String path) {
        setCookie(context, immediately, url, key, value, 0, "", path, false, false);
    }

    public static void setCookieSecure(Context context, boolean immediately, String url, String key, String value, boolean secure) {
        setCookie(context, immediately, url, key, value, 0, "", "", secure, false);
    }

    public static void setCookieHttpOnly(Context context, boolean immediately, String url, String key, String value, boolean HttpOnly) {
        setCookie(context, immediately, url, key, value, 0, "", "", false, HttpOnly);
    }

    public static void setCookie(Context context, boolean immediately, String url, String key, String value, int maxAge,
                                 @Nullable String domain, String path, boolean secure, boolean httponly) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(key).append("=").append(value).append(";");
        if (maxAge > 0) {
            sb.append("max-age=").append(maxAge).append(";");
        }
        if (!TextUtils.isEmpty(domain)) {
            sb.append("domain=").append(domain).append(";");
        }
        if (!TextUtils.isEmpty(path)) {
            sb.append("path=").append(path).append(";");
        }
        if (secure) {
            sb.append("secure;");
        }
        if (httponly) {
            sb.append("httponly;");
        }
        list.add(sb.toString());
        setCookie(context, immediately, url, list);
    }

    private static void setCookie(Context context, boolean immediately, String url, List<String> list) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            CookieSyncManager.createInstance(context);
            setCookie(immediately, url, list);
            CookieSyncManager.getInstance().sync();
        } else {
            setCookie(immediately, url, list);
        }
    }

    private static void setCookie(boolean immediately, String url, List<String> list) {
        final CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.setAcceptCookie(true);// 允许接受 Cookie,默认开启 无视
        for (String entry : list) {
            if (entry == null) {
                continue;
            }
            String[] split = entry.split(";");
            if (check(split)) {
                cookieManager.setCookie(url, entry);
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (immediately) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        cookieManager.flush();
                    }
                });
            }
        }
    }

    private static boolean check(String[] split) {
        int normalValue = 0;
        int length = split.length;
        for (String s : split) {
            String[] result = s.split("=");
            if (result.length == 2 && (result[0].equalsIgnoreCase("max-age")
                    || result[0].equalsIgnoreCase("expires")
                    || result[0].equalsIgnoreCase("domain"))) {
                if (length > 1) {
                    continue;
                } else {
                    return false;
                }
            }
            if (result.length == 2 && result[0].equalsIgnoreCase("path") && result[1].startsWith("/")) {
                if (length > 1) {
                    continue;
                } else {
                    return false;
                }
            }
            if (result.length == 1 && (result[0].equalsIgnoreCase("httponly")
                    || result[0].equalsIgnoreCase("secure"))) {
                if (length > 1) {
                    continue;
                } else {
                    return false;
                }
            }
            normalValue++;
            if (normalValue > 1) {
                return false;
            }
        }
        return true;
    }

    public static String getCookie(String url) {
        CookieManager instance = CookieManager.getInstance();
        return instance.getCookie(url);
    }
}

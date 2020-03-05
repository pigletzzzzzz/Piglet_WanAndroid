package com.xmobile.pppdemonew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.xmobile.pppdemonew.ui.login.LoginV2Activity;

import com.xmobile.pppdemonew.ui.main.MainActivity;
import com.xmobile.xbiz.SessionManage;
import com.xmobile.xbizv2.SessionManageV2;
import com.xmobile.xframework.ui.BaseActivity;
import com.xmobile.xlogger.XLogger;

/**
 * Created by 黄卫华(wayhua@126.com) on 2018/1/15.
 */

public class JumpUtils {

    public static String ACCOUNT = "ACCOUNT";
    public static String REALNAME = "REALNAME";
    public static String USER = "USER";
    public static String TOKEN = "TOKEN";
    public static String PACKAGENAME = "PACKAGENAME";

    public static void dojump(Context context) {
        Intent intent = null;

        if (BuildConfig.Type == 0)//app
        {
            intent = new Intent(context, LoginV2Activity.class);

        } else if (BuildConfig.Type == 1) {

            if (BuildConfig.DEBUG) {
                //如果登录过了就不再登录


                intent = new Intent(context, LoginV2Activity.class);


            } else {
                intent = mainIntent(context);//new Intent(context, MainActivity.class);
            }
        }

        context.startActivity(intent);
    }

    public static Intent mainIntent(Context activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        return intent;
    }

    public static void jumpMain(Activity activity) {
        Intent intent = mainIntent(activity);
        jump(activity, intent);
    }

    public static void jump(Activity activity, Intent intent) {
        if (intent == null) {
            XLogger.e("无法跳转，intent为空");
            return;
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.abc_grow_fade_in_from_bottom,
                R.anim.abc_shrink_fade_out_from_bottom);
        activity.finish();
    }


    //暂时就写这么多，以后再添加
    public static void getInfoFromPlatform(BaseActivity activity) {

        Bundle localBundle = activity.getIntent().getExtras();
        SessionManage.setUId(localBundle.getString(ACCOUNT));
        SessionManage.setRealName(localBundle.getString(REALNAME));

        Host.PackageName = localBundle.getString(PACKAGENAME);
        SessionManageV2.token = localBundle.getString(TOKEN);

        String host = localBundle.getString("HOST", "");
        if (!host.contains("http://")) {
            host = "http://" + host;
        }

        SessionManage.setBaseUrl(host);

    }
}

package com.xmobile.pppdemonew;

import android.content.Context;

import com.xmobile.pppdemonew.data.local.LocalDb;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xbiz.SessionManage;
import com.xmobile.xframework.BaseApplication;
import com.xmobile.xretrofit.RetrofitUtil;


/**
 * Created by 黄卫华(wayhua@126.com) on 2019-10-10 14:36
 */
public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LocalDb.init(this);
//        XSecuredPrefrence.init(this);


        RepositoryFactory.init(this);
        SessionManage.setContext(this);

        //SessionManage.setBaseUrl(BuildConfig.API_HOST);
        RetrofitUtil.init(this);

    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }
    @Override
    protected boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}

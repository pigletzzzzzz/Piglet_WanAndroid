package com.xmobile.pppdemonew.data.repository.v2.remote;


import com.xmobile.xbiz.SessionManage;
import com.xmobile.xretrofit.RetrofitUtil;

import retrofit2.Retrofit;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/8/1.
 */

public class RemoteDataV2 {

    public static IServiceV2 getService() {
        Retrofit retrofit = RetrofitUtil.getRetrofit("https://www.wanandroid.com/");
        IServiceV2 service = retrofit.create(IServiceV2.class);
        return service;
    }


}

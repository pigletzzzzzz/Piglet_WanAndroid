package com.xmobile.pppdemonew.data.repository;

import android.content.Context;


import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.bean.Articles;
import com.xmobile.pppdemonew.data.bean.BannerBean;
import com.xmobile.pppdemonew.data.bean.BaseResponse;
import com.xmobile.pppdemonew.data.bean.LoginBean;
import com.xmobile.pppdemonew.data.bean.LoginYZM;

import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.pppdemonew.data.bean.NavigationBean;
import com.xmobile.pppdemonew.data.bean.RankingBean;
import com.xmobile.pppdemonew.data.bean.ReposiLoginBean;
import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.pppdemonew.data.bean.Tab;
import com.xmobile.pppdemonew.data.bean.User;
import com.xmobile.pppdemonew.data.bean.UserInfoBean;
import com.xmobile.xframework.mvvm.data.Resource;


import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * 时间 : 2019/9/24 13:36
 * 版本 : 1.0
 * 黄卫华(wayhua@126.com)
 */
public interface IRepository {
    void init(Context context);


//    LiveData<Resource> login(Context context, String username, String password, String... params);
//    LiveData quicklogin(Context context);
//
//
//    LiveData<Resource<LoginYZM>> getYzm(Context context);
//
//    LiveData<Resource<List<User>>> getTestUser();
//
//    //获取当前登录用户
//    LiveData getCurrentUser();

    LiveData<Resource<LoginBean>> login(String username,String password);

    LiveData<Resource<LoginBean>> register(String username,String password,String repassword);

    LiveData<Resource<UserInfoBean>> getUserInfo(String username, String password);

    LiveData<Resource<List<MyLevelBean>>> getMyLevel(int page);

    LiveData<Resource<List<RankingBean>>> getRanking(int page);

    LiveData<Resource<List<Tab>>> getWxTabs();

    LiveData<Resource<List<BannerBean>>> getBanner();

    LiveData<Resource<List<Article>>> getarticles(int page);

    LiveData<Resource<List<Article>>> getSquareItem(int page);

    LiveData<Resource<List<Article>>> getWechatAuthorItem(int id,int page);

    LiveData<Resource<List<SystemBean>>> getSystemItem();

    LiveData<Resource<List<NavigationBean>>> getNavigation();

    LiveData<Resource<List<SystemBean>>> getProjectItem();

    LiveData<Resource<List<Article>>> getProjectAuthorItem(int page,int id);

    LiveData<Resource<List<Article>>> getSystemAuthorItem(int page,int id);

}

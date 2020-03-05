package com.xmobile.pppdemonew.data.repository.v2.remote;


import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.bean.Articles;
import com.xmobile.pppdemonew.data.bean.BannerBean;
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
import com.xmobile.pppdemonew.data.repository.v2.remote.req.LoginReqV2;
import com.xmobile.pppdemonew.data.repository.v2.remote.res.LoginResV2;
import com.xmobile.pppdemonew.data.repository.v2.remote.res.XResponseV1;
import com.xmobile.xbizv2.XRequestV2;
import com.xmobile.xbizv2.XResponseV2;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;

import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * time :2019/9/17 15:38
 * version:1.0
 * 黄卫华(wayhua@126.com)
 */
public interface IServiceV2 {


//    @Headers("Cache-Control: max-age=5")
//    @GET("/core/api/user/v1/user/getjuser")
//    Observable<XResponseV2<User>> getCurrentUser(@Header("PLAY_SESSION") String token);

    //登录
    @POST("user/login")
    Observable<XResponseV1<LoginBean>> login(@Query("username") String username,
                                             @Query("password") String password);

    //注册
    @POST("user/login")
    Observable<XResponseV1<LoginBean>> register(@Query("username") String username,
                                                @Query("password") String password,
                                                @Query("repassword") String repassword);

    //获取个人信息
    @GET("lg/coin/userinfo/json")
    Observable<XResponseV1<UserInfoBean>> getUserinfo(@Query("username") String username,
                                                      @Query("password") String password);

    //获取个人积分
    @GET("lg/coin/list/{page}/json")
    Observable<XResponseV1<Articles<MyLevelBean>>> getMyLevel(@Path("page") int page);

    //获取积分排行
    @GET("coin/rank/{page}/json")
    Observable<XResponseV1<Articles<RankingBean>>> getRanking(@Path("page") int page);

    //获取微信teb列表数据
    @Headers("Cache-Control: max-age=5")
    @GET("wxarticle/chapters/json")
    Observable<XResponseV1<List<Tab>>> getTab();

    //获取首页轮播图
    @Headers("Cache-Control: max-age=5")
    @GET("banner/json")
    Observable<XResponseV1<List<BannerBean>>> getBanner();

    //获取首页列表数据
    @Headers("Cache-Control: max-age=5")
    @GET("article/list/{page}/json")
    Observable<XResponseV1<Articles<Article>>> getArticles(@Path("page") int page);

    //获取公众号作者数据列表
    @Headers("Cache-Control: max-age=5")
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<XResponseV1<Articles<Article>>> getWechatAuthorItem(@Path("id") int id,@Path("page") int page);

    //获取广场列表
    @Headers("Cache-Control: max-age=5")
    @GET("user_article/list/{page}/json")
    Observable<XResponseV1<Articles<Article>>> getSquareItem(@Path("page") int page);

    //获取体系列表
    @Headers("Cache-Control: max-age=5")
    @GET("tree/json")
    Observable<XResponseV1<List<SystemBean>>> getSystemItem();

    //获取导航列表
    @Headers("Cache-Control: max-age=5")
    @GET("navi/json")
    Observable<XResponseV1<List<NavigationBean>>> getNavigation();

    //获取项目列表
    @Headers("Cache-Control: max-age=5")
    @GET("project/tree/json")
    Observable<XResponseV1<List<SystemBean>>> getProjectItem();

    //获取单个项目类别数据列表
    @Headers("Cache-Control: max-age=5")
    @GET("project/list/{page}/json")
    Observable<XResponseV1<Articles<Article>>> getProjectAuthorItem(@Path("page") int page,@Query("cid") int id);

    //获取体系某个类别数据列表
    @Headers("Cache-Control: max-age=5")
    @GET("article/list/{page}/json")
    Observable<XResponseV1<Articles<Article>>> getSystemAuthorItem(@Path("page") int page,@Query("cid") int id);

}


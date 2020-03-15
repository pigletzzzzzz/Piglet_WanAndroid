package com.xmobile.pppdemonew.data.repository.v2;

import android.content.Context;
import android.content.pm.PackageManager;

import com.xmobile.pppdemonew.AppConstants;
import com.xmobile.pppdemonew.BuildConfig;
import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.XLoginHelper;
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
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.v2.remote.RemoteDataV2;
import com.xmobile.pppdemonew.data.repository.v2.remote.req.LoginReqV2;
import com.xmobile.pppdemonew.data.repository.v2.remote.res.LoginResV2;
import com.xmobile.pppdemonew.data.repository.v2.remote.res.XResponseV1;
import com.xmobile.pppdemonew.data.repository.v2.remote.res.XResponseV2JSONDeserializerNew;
import com.xmobile.pppdemonew.data.resource.SimpleNetworkResource;
import com.xmobile.pppdemonew.utils.CookieUtil;
import com.xmobile.pppdemonew.utils.SharedPreferencesUtils;
import com.xmobile.xbiz.SessionManage;
import com.xmobile.xbiz.XDevice;
import com.xmobile.xbizv2.SessionManageV2;
import com.xmobile.xbizv2.XRequestV2;
import com.xmobile.xbizv2.XResponseV2;
import com.xmobile.xbizv2.gson.XRequestV2JsonSerializer;
import com.xmobile.xbizv2.gson.XResponseV2JSONDeserializer;
import com.xmobile.xframework.mvvm.data.Resource;

import com.xmobile.xlogger.XLogger;
import com.xmobile.xretrofit.RetrofitCookie;
import com.xmobile.xretrofit.RetrofitUtil;
import com.xmobile.xretrofit.gson.GsonUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.Observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import okhttp3.Request;

/**
 * 时间 : 2019/9/24 13:38
 * 版本 : 1.0
 * 黄卫华(wayhua@126.com)
 */


public class RepositoryV2 implements IRepository {
    private Context context;
    @Override
    public void init(Context context) {
        SessionManage.setSessionManage(new SessionManageV2());
        GsonUtils.initStrDate();
        GsonUtils.registerTypeAdapter(XRequestV2.class, new XRequestV2JsonSerializer());
        GsonUtils.registerTypeAdapter(XResponseV2.class, new XResponseV2JSONDeserializerNew());
        this.context = context;

    }

    @Override
    public LiveData<Resource<LoginBean>> login(String username, String password) {
        return new SimpleNetworkResource<LoginBean>() {
            @NonNull
            @Override
            protected Observable<LoginBean> createCall() {
                return RemoteDataV2.getService().login(username, password)
                        .map(new Function<XResponseV1<LoginBean>, LoginBean>() {
                            @Override
                            public LoginBean apply(XResponseV1<LoginBean> loginBeanXResponseV1) throws Exception {
                                return loginBeanXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<LoginBean>> register(String username, String password, String repassword) {
        return new SimpleNetworkResource<LoginBean>() {
            @NonNull
            @Override
            protected Observable<LoginBean> createCall() {
                return RemoteDataV2.getService().register(username, password, repassword)
                        .map(new Function<XResponseV1<LoginBean>, LoginBean>() {
                            @Override
                            public LoginBean apply(XResponseV1<LoginBean> loginBeanXResponseV1) throws Exception {
                                return loginBeanXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<UserInfoBean>> getUserInfo(String username, String password) {
        return new SimpleNetworkResource<UserInfoBean>() {
            @NonNull
            @Override
            protected Observable<UserInfoBean> createCall() {
                return RemoteDataV2.getService().getUserinfo(username, password)
                        .map(new Function<XResponseV1<UserInfoBean>, UserInfoBean>() {
                            @Override
                            public UserInfoBean apply(XResponseV1<UserInfoBean> userInfoBeanXResponseV1) throws Exception {
                                return userInfoBeanXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<MyLevelBean>>> getMyLevel(int page) {
        return new SimpleNetworkResource<List<MyLevelBean>>() {
            @NonNull
            @Override
            protected Observable<List<MyLevelBean>> createCall() {
                String cookie = SharedPreferencesUtils.getT(context, AppConstants.COOKIE,"");
                return RemoteDataV2.getService().getMyLevel(cookie,page)
                        .map(new Function<XResponseV1<Articles<MyLevelBean>>, List<MyLevelBean>>() {
                            @Override
                            public List<MyLevelBean> apply(XResponseV1<Articles<MyLevelBean>> articlesXResponseV1) throws Exception {
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<RankingBean>>> getRanking(int page) {
        return new SimpleNetworkResource<List<RankingBean>>() {
            @NonNull
            @Override
            protected Observable<List<RankingBean>> createCall() {
                return RemoteDataV2.getService().getRanking(page)
                        .map(new Function<XResponseV1<Articles<RankingBean>>, List<RankingBean>>() {
                            @Override
                            public List<RankingBean> apply(XResponseV1<Articles<RankingBean>> articlesXResponseV1) throws Exception {
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<Tab>>> getWxTabs() {
        return new SimpleNetworkResource<List<Tab>>() {
            @NonNull
            @Override
            protected Observable<List<Tab>> createCall() {
                return RemoteDataV2.getService().getTab()
                        .map(new Function<XResponseV1<List<Tab>>, List<Tab>>() {
                            @Override
                            public List<Tab> apply(XResponseV1<List<Tab>> listXResponseV1) throws Exception {
                                return listXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<BannerBean>>> getBanner() {
        return new SimpleNetworkResource<List<BannerBean>>() {
            @NonNull
            @Override
            protected Observable<List<BannerBean>> createCall() {
                return RemoteDataV2.getService().getBanner()
                        .map(new Function<XResponseV1<List<BannerBean>>, List<BannerBean>>() {
                            @Override
                            public List<BannerBean> apply(XResponseV1<List<BannerBean>> listXResponseV1) throws Exception {
                                return listXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<Article>>> getarticles(int page) {
        return new SimpleNetworkResource<List<Article>>() {
            @NonNull
            @Override
            protected Observable<List<Article>> createCall() {
                return RemoteDataV2.getService().getArticles(page)
                        .map(new Function<XResponseV1<Articles<Article>>, List<Article>>() {
                            @Override
                            public List<Article> apply(XResponseV1<Articles<Article>> articlesXResponseV1) throws Exception {
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<Article>>> getSquareItem(int page) {
        return new SimpleNetworkResource<List<Article>>() {
            @NonNull
            @Override
            protected Observable<List<Article>> createCall() {
                return RemoteDataV2.getService().getSquareItem(page)
                        .map(new Function<XResponseV1<Articles<Article>>, List<Article>>() {
                            @Override
                            public List<Article> apply(XResponseV1<Articles<Article>> articlesXResponseV1) throws Exception {
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<Article>>> getWechatAuthorItem(int id, int page) {
        return new SimpleNetworkResource<List<Article>>() {
            @NonNull
            @Override
            protected Observable<List<Article>> createCall() {
                return RemoteDataV2.getService().getWechatAuthorItem(id,page)
                        .map(new Function<XResponseV1<Articles<Article>>, List<Article>>() {
                            @Override
                            public List<Article> apply(XResponseV1<Articles<Article>> articlesXResponseV1) throws Exception {
                                XLogger.e("mCurrentItemCount"+"XResponseV1,"+articlesXResponseV1.getErrorCode()+","+articlesXResponseV1.getData().getDatas().size());
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<SystemBean>>> getSystemItem() {
        return new SimpleNetworkResource<List<SystemBean>>() {
            @NonNull
            @Override
            protected Observable<List<SystemBean>> createCall() {
                return RemoteDataV2.getService().getSystemItem()
                        .map(new Function<XResponseV1<List<SystemBean>>, List<SystemBean>>() {
                            @Override
                            public List<SystemBean> apply(XResponseV1<List<SystemBean>> listXResponseV1) throws Exception {
                                return listXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<NavigationBean>>> getNavigation() {
        return new SimpleNetworkResource<List<NavigationBean>>() {
            @NonNull
            @Override
            protected Observable<List<NavigationBean>> createCall() {
                return RemoteDataV2.getService().getNavigation()
                        .map(new Function<XResponseV1<List<NavigationBean>>, List<NavigationBean>>() {
                            @Override
                            public List<NavigationBean> apply(XResponseV1<List<NavigationBean>> listXResponseV1) throws Exception {
                                return listXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<SystemBean>>> getProjectItem() {
        return new SimpleNetworkResource<List<SystemBean>>() {
            @NonNull
            @Override
            protected Observable<List<SystemBean>> createCall() {
                return RemoteDataV2.getService().getProjectItem()
                        .map(new Function<XResponseV1<List<SystemBean>>, List<SystemBean>>() {
                            @Override
                            public List<SystemBean> apply(XResponseV1<List<SystemBean>> listXResponseV1) throws Exception {
                                return listXResponseV1.getData();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<Article>>> getProjectAuthorItem(int page,int id) {
        return new SimpleNetworkResource<List<Article>>() {
            @NonNull
            @Override
            protected Observable<List<Article>> createCall() {
                return RemoteDataV2.getService().getProjectAuthorItem(page,id)
                        .map(new Function<XResponseV1<Articles<Article>>, List<Article>>() {
                            @Override
                            public List<Article> apply(XResponseV1<Articles<Article>> articlesXResponseV1) throws Exception {
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

    @Override
    public LiveData<Resource<List<Article>>> getSystemAuthorItem(int page, int id) {
        return new SimpleNetworkResource<List<Article>>() {
            @NonNull
            @Override
            protected Observable<List<Article>> createCall() {
                return RemoteDataV2.getService().getSystemAuthorItem(page,id)
                        .map(new Function<XResponseV1<Articles<Article>>, List<Article>>() {
                            @Override
                            public List<Article> apply(XResponseV1<Articles<Article>> articlesXResponseV1) throws Exception {
                                return articlesXResponseV1.getData().getDatas();
                            }
                        });
            }
        }.getAsLiveData();
    }

//    @Override
//    public LiveData<Resource> quicklogin(Context context) {
//        return new SimpleNetworkResource() {
//
//            @NonNull
//            @Override
//            protected Observable createCall() {
//
//                //  return null;
//                LoginReqV2 req = new LoginReqV2();
//
//                req.setDevice(XDevice.instance());
//
//                XRequestV2<LoginReqV2> request = new XRequestV2<>();
//                request.setData(req);
//
//                String refresh_token = XLoginHelper.getRefresh_token(context);
//
//
//                return RemoteDataV2.getService()
//                        .quicklogin(refresh_token, request)
//                        .map(new Function<XResponseV2<LoginResV2>, Resource>() {
//                            @Override
//                            public Resource apply(XResponseV2<LoginResV2> loginResV2XResponseV2) throws Exception {
//
//                                if (loginResV2XResponseV2.getCode() != 200) {
//                                    throw new RuntimeException(loginResV2XResponseV2.getMsg());
//                                }
//                                SessionManageV2.token = loginResV2XResponseV2.getData().getToken();
//                                return Resource.success();
//                            }
//                        });
//            }
//        }.getAsLiveData();
//    }
//
//    @Override
//    public LiveData<Resource> login(Context context, String username, String password, String... params) {
//        return new SimpleNetworkResource() {
//
//            @NonNull
//            @Override
//            protected Observable createCall() {
//
//                LoginReqV2 req = new LoginReqV2();
//                req.setAccount(username);
//                req.setPassword(password);
//                if (params.length > 0) {
//                    req.setVerCode(params[0]);
//                }
//
//                if (params.length > 1) {
//                    req.setVerCodeValue(params[1]);
//                }
//                req.setDevice(XDevice.instance());
//
//                XRequestV2<LoginReqV2> request = new XRequestV2<>();
//                request.setData(req);
//                return RemoteDataV2.getService()
//                        .login(request)
//                        .map(new Function<XResponseV2<LoginResV2>, Resource>() {
//                            @Override
//                            public Resource apply(XResponseV2<LoginResV2> loginResV2XResponseV2) throws Exception {
//
//                                if (loginResV2XResponseV2.getCode() != 200) {
//                                    throw new RuntimeException(loginResV2XResponseV2.getMsg());
//
//                                }
//                                XLoginHelper.setRefresh_token(context, loginResV2XResponseV2.getData().getRefreshToken());
//                                SessionManageV2.token = loginResV2XResponseV2.getData().getToken();
//                                return Resource.success();
//                            }
//                        });
//            }
//        }.getAsLiveData();
//    }
//
//    @Override
//    public LiveData<Resource<LoginYZM>> getYzm(Context context) {
//        return new SimpleNetworkResource<LoginYZM>() {
//
//
//            @NonNull
//            @Override
//            protected Observable<LoginYZM> createCall() {
//                return RemoteDataV2.getService().getYzm()
//                        .map(new Function<XResponseV2<LoginYZM>, LoginYZM>() {
//                            @Override
//                            public LoginYZM apply(XResponseV2<LoginYZM> loginYZMXResponseV2) throws Exception {
//                                return loginYZMXResponseV2.getData();
//                            }
//                        });
//
//            }
//        }.getAsLiveData();
//    }
//
//    @Override
//    public LiveData<Resource<List<User>>> getTestUser() {
//        return new SimpleNetworkResource<List<User>>() {
//
//            @NonNull
//            @Override
//            protected Observable<List<User>> createCall() {
//                return Observable.create(new ObservableOnSubscribe<List<User>>() {
//
//                    @Override
//                    public void subscribe(ObservableEmitter<List<User>> emitter) throws Exception {
//                        List<User> result = new ArrayList<>();
//
//                        User u1 = new User();
//                        u1.setRealname("张三");
//
//                        result.add(u1);
//
//                        User u2 = new User();
//                        u2.setRealname("李四");
//
//                        result.add(u2);
//
//                        User u3 = new User();
//                        u3.setRealname("王五");
//
//                        result.add(u3);
//
//                        User u4 = new User();
//                        u4.setRealname("赵六");
//                        result.add(u4);
//
//                        emitter.onNext(result);
//                        emitter.onComplete();
//                    }
//                });
//            }
//        }.getAsLiveData();
//    }
//
//    @Override
//    public LiveData getCurrentUser() {
//        return new SimpleNetworkResource() {
//
//            @NonNull
//            @Override
//            protected Observable createCall() {
//                return RemoteDataV2.getService().getCurrentUser(SessionManageV2.token)
//                        .map(new Function<XResponseV2<User>, Resource>() {
//                            @Override
//                            public Resource apply(XResponseV2<User> userXResponseV2) throws Exception {
//
//                                if (userXResponseV2.getCode() == 200) {
//                                    setMyself(userXResponseV2.getData());
//                                    return Resource.success();
//
//                                } else {
//                                    return Resource.error(userXResponseV2.getMsg());
//                                }
//                            }
//                        });
//            }
//        }.getAsLiveData();
//    }


    protected void setMyself(User user) {

        SessionManage.setUId(user.getAccount());
        SessionManage.setMyself(user);
        SessionManage.setRealName(user.getRealname());
    }


}

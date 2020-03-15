package com.xmobile.pppdemonew.ui.login;


import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tbruyelle.rxpermissions2.RxPermissions;

import com.xmobile.pppdemonew.AppConstants;
import com.xmobile.pppdemonew.BuildConfig;
import com.xmobile.pppdemonew.JumpUtils;
import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.LoginBean;
import com.xmobile.pppdemonew.data.bean.LoginYZM;
import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.pppdemonew.data.bean.ReposiLoginBean;
import com.xmobile.pppdemonew.data.bean.UserInfoBean;
import com.xmobile.pppdemonew.databinding.ActivityLoginV2Binding;
import com.xmobile.pppdemonew.ui.my.MyOpenActivity;
import com.xmobile.pppdemonew.ui.my.mylevel.MyLevelViewModel;
import com.xmobile.pppdemonew.utils.CookieUtil;
import com.xmobile.pppdemonew.utils.IMeiUtils;
import com.xmobile.pppdemonew.utils.ImageDecode;
import com.xmobile.xbiz.SessionManage;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.tools.dialog.DialogUtils;
import com.xmobile.xframework.tools.toast.ToastUtils;
import com.xmobile.xframework.ui.BaseActivity;
import com.xmobile.xframework.ui.click.RxViews;
import com.xmobile.xframework.utils.FocusUtil;
import com.xmobile.xframework.utils.NightModelUtils;
import com.xmobile.xframework.utils.SharedPreferencesUtils;
import com.xmobile.xlogger.XLogger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import io.reactivex.functions.Consumer;
import okhttp3.Cookie;

public class LoginV2Activity extends BaseActivity {
    ActivityLoginV2Binding binding;
    LoginViewModel loginViewModel;

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_v2);
        loginViewModel = new LoginViewModel();
        ShowOrHidePWD();

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });
        binding.forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginV2Activity.this, RegisterV2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void ShowOrHidePWD(){
        binding.showHide.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        binding.loginEditPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        binding.showHide.setBackgroundResource(R.mipmap.inputsee);
                        break;
                    case MotionEvent.ACTION_UP:
                        binding.loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        binding.showHide.setBackgroundResource(R.mipmap.inputhide);
                        break;
                }
                return true;
            }
        });
    }

    private void goLogin(){
        String username = binding.loginEditAccount.getText().toString();
        String password = binding.loginEditPwd.getText().toString();
        loginViewModel.login(username,password).observe(this, new Observer<Resource<LoginBean>>() {
            @Override
            public void onChanged(Resource<LoginBean> loginBeanResource) {
                if (loginBeanResource.status == Status.SUCCESS){
                    XLogger.e("登录"+loginBeanResource.data.getUsername());
                    LoginBean loginBean = loginBeanResource.data;
                    LiveEventBus.get().with("loginBean").post(loginBean);

                    SharedPreferencesUtils.putT(LoginV2Activity.this, AppConstants.USERNAME,username);
                    SharedPreferencesUtils.putT(LoginV2Activity.this, AppConstants.PASSWORK,password);
                    getUserInfo();

                    Map<String,String> userName = new HashMap<>();
                    userName.put("loginUserName",username);
                    Map<String,String> userPass = new HashMap<>();
                    userPass.put("loginUserPassword",password);
//                    CookieUtil.setCookie(LoginV2Activity.this,false,BuildConfig.API_HOST,userName);
//                    CookieUtil.setCookie(LoginV2Activity.this,false,BuildConfig.API_HOST,userPass);
                    CookieUtil.setCookieMaxAge(LoginV2Activity.this,true,BuildConfig.API_HOST,"loginUserName",username,60 * 60);
                    CookieUtil.setCookieMaxAge(LoginV2Activity.this,true,BuildConfig.API_HOST,"loginUserPassword",password,60 * 60);
                    SharedPreferencesUtils.putT(LoginV2Activity.this,AppConstants.COOKIE,CookieUtil.getCookie(BuildConfig.API_HOST));

                }else if (loginBeanResource.status == Status.ERROR){
                    ToastUtils.error(LoginV2Activity.this,loginBeanResource.message);
                }
            }
        });
    }

    private void getUserInfo(){
        loginViewModel.getUserInfo(SharedPreferencesUtils.getT(LoginV2Activity.this,AppConstants.USERNAME,"")
        ,SharedPreferencesUtils.getT(LoginV2Activity.this,AppConstants.PASSWORK,""))
                .observe(this, new Observer<Resource<UserInfoBean>>() {
                    @Override
                    public void onChanged(Resource<UserInfoBean> userInfoBeanResource) {
                        if (userInfoBeanResource.status == Status.SUCCESS){
                            UserInfoBean userInfoBean = userInfoBeanResource.data;
                            SharedPreferencesUtils.putT(LoginV2Activity.this, AppConstants.LEVEL,userInfoBean.getLevel()+"");
                            SharedPreferencesUtils.putT(LoginV2Activity.this, AppConstants.USERID,userInfoBean.getUserId()+"");
                            SharedPreferencesUtils.putT(LoginV2Activity.this, AppConstants.RANK,userInfoBean.getRank()+"");
                            SharedPreferencesUtils.putT(LoginV2Activity.this, AppConstants.COINCOUNT,userInfoBean.getCoinCount()+"");
                            LiveEventBus.get().with("userInfo").post(true);
                            finish();
                        }else if (userInfoBeanResource.status == Status.ERROR){
                            ToastUtils.error(LoginV2Activity.this,"用户名或密码错误！");
                        }
                    }
                });
    }
}

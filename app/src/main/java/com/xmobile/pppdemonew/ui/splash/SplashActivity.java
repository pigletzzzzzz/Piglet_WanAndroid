package com.xmobile.pppdemonew.ui.splash;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;

import com.xmobile.pppdemonew.BuildConfig;
import com.xmobile.pppdemonew.JumpUtils;
import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.XLoginHelper;
import com.xmobile.pppdemonew.databinding.ActivitySplashBinding;
import com.xmobile.pppdemonew.ui.login.LoginV2Activity;
import com.xmobile.xbiz.SessionManage;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.ui.BaseActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;


public class SplashActivity extends BaseActivity {

    ActivitySplashBinding binding;
    public static final int SPLASH_DURATION = 1;
    SplashViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        if (BuildConfig.Type == 0)//app
        {
            SessionManage.setBaseUrl(BuildConfig.API_HOST);
        } else if (BuildConfig.Type == 1) {

            if (BuildConfig.DEBUG) {
                SessionManage.setBaseUrl(BuildConfig.API_HOST);
            } else {
                JumpUtils.getInfoFromPlatform(this);
            }
        }


    }


    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_splash);

        viewModel = new SplashViewModel();
        showSplash();

    }

    public void showSplash() {

        Glide.with(this).load(R.mipmap.splash)//.crossFade(1500)
//                .animate(R.anim.splash_anim)
                .into(binding.splash);
        startAppDelay();
    }

    private void startAppDelay() {

        binding.splash.postDelayed(new Runnable() {
            @Override
            public void run() {
                doJumpActivity();
                finish();
            }
        }, SPLASH_DURATION);

    }

    private void doJumpActivity() {
        //  JumpUtils.dojump(this);


        if (BuildConfig.Type == 0)//app
        {
            //如果是APP，直接进入登录，这个暂时没使用
            jumpToLogin();
            return;
        }


        //以下是插件情况，只在第一次或refreshtoken超时才会出现登录。
        //如果要切换帐号，直接将插件删除重新来过。

        if (BuildConfig.DEBUG) {
            //如果登录过了就不再登录

            doDebugLogin();


        } else {
            jumpToMain();

        }


    }

    private void jumpToMain() {
        Intent intent;
        intent = JumpUtils.mainIntent(this);
        startActivity(intent);
    }

    private void doDebugLogin() {

        String rt = XLoginHelper.getRefresh_token(this);

        if (TextUtils.isEmpty(rt)) {
            //第一次直接进入登录界面
            jumpToLogin();
            return;
        }


        //验证refreshToken

        viewModel.quicklogin(this)
                .observe(this, new Observer<Resource>() {
                    @Override
                    public void onChanged(Resource resource) {
                        if (resource.status == Status.SUCCESS) {
                            jumpToMain();

                        } else if (resource.status == Status.ERROR) {
                            jumpToLogin();

                        }
                    }
                });


    }

    private void jumpToLogin() {
        Intent intent;
        intent = new Intent(this, LoginV2Activity.class);
        startActivity(intent);
    }


}

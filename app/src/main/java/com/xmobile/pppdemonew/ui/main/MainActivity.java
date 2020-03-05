package com.xmobile.pppdemonew.ui.main;


import android.os.Bundle;
import android.view.View;

import com.xmobile.pppdemonew.aidl.XAidl;

import com.xmobile.pppdemonew.data.bean.User;
import com.xmobile.pppdemonew.ui.main.fragment.FragmentMain;

import com.xmobile.xframework.immersionbar.XImmersionBar;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;

import com.xmobile.xframework.ui.BaseActivityToolbarWithFragment;
import com.xmobile.xframework.ui.BaseActivityWithFragment;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xlogger.XLogger;
import com.xuexiang.xui.XUI;

import androidx.lifecycle.Observer;

public class MainActivity extends BaseActivityWithFragment<FragmentMain> {

    MainViewModel viewModel = new MainViewModel();

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        XAidl.bind(this);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
    }
}

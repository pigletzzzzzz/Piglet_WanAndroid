package com.xmobile.pppdemonew.ui.main;


import android.os.Bundle;
import android.view.View;

import com.xmobile.pppdemonew.aidl.XAidl;

import com.xmobile.pppdemonew.ui.main.fragment.FragmentMain;
import com.xmobile.xframework.ui.BaseActivityWithFragment;

public class MainActivity extends BaseActivityWithFragment<FragmentMain> {


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

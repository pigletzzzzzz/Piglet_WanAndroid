package com.xmobile.pppdemonew.ui.my.mylevel;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/1
 */
public class MyLevelAdapter extends SimpleBaseAdapter<MyLevelViewHolder, MyLevelBean> {
    public MyLevelAdapter(LifecycleOwner owner, IRecycleViewCallback<MyLevelBean> callback) {
        super(owner, callback);
    }
}

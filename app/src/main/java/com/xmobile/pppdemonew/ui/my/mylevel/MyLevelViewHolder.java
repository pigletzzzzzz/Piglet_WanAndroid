package com.xmobile.pppdemonew.ui.my.mylevel;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.pppdemonew.databinding.MyLevelItemBinding;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewholder.XViewHolder;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/1
 */
public class MyLevelViewHolder extends XViewHolder<MyLevelItemBinding, MyLevelBean> {
    public MyLevelViewHolder(LifecycleOwner owner, BaseAdapter adapter, MyLevelItemBinding binding, IRecycleViewCallback<MyLevelBean> callback) {
        super(owner, adapter, binding, callback);
    }

    @Override
    public void onBind(MyLevelBean myLevelBean) {
        binding.setData(myLevelBean);
    }

    @Override
    protected MyLevelBean getCurrentT() {
        return binding.getData();
    }
}

package com.xmobile.pppdemonew.ui.my.mylevel;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.xmobile.pppdemonew.AppConstants;
import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.pppdemonew.databinding.FragmentMyLevelBinding;
import com.xmobile.pppdemonew.utils.SharedPreferencesUtils;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;
import com.xmobile.xframework.ui.BaseRecycleFragmentT;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/1
 */
public class MyLevelFragment extends BaseRecycleFragmentT<FragmentMyLevelBinding,MyLevelBean> {

    @Override
    protected BaseListViewModel<MyLevelBean> createViewModel() {
        return null;
    }

    @Override
    protected void setbindingResouce(Resource<List<MyLevelBean>> resource) {

    }

    @Override
    protected BaseAdapter createAdapter() {
        return null;
    }

    @Override
    public void onModelClicked(MyLevelBean myLevelBean, View view) {

    }

    @Override
    protected FragmentMyLevelBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return null;
    }
}

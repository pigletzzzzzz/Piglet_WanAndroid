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
import com.xmobile.xframework.ui.BaseRecycleFragment;
import com.xmobile.xframework.ui.BaseRecycleFragmentT;
import com.xmobile.xframework.ui.BaseRecyclePagedFragment;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/1
 */
public class MyLevelFragment extends BaseRecyclePagedFragment<MyLevelBean> {

    @Override
    protected BaseListViewModel<MyLevelBean> createViewModel() {
        return new MyLevelViewModel();
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new MyLevelAdapter(this,this);
    }

    @Override
    public void onModelClicked(MyLevelBean myLevelBean, View view) {

    }
}

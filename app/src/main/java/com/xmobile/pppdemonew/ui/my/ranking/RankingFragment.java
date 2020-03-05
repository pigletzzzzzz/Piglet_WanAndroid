package com.xmobile.pppdemonew.ui.my.ranking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.xmobile.pppdemonew.data.bean.RankingBean;
import com.xmobile.pppdemonew.databinding.FragmentRankingBinding;
import com.xmobile.pppdemonew.databinding.FragmentRankingItemBinding;
import com.xmobile.xframework.immersionbar.XImmersionBar;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;
import com.xmobile.xframework.ui.BaseRecycleFragment;
import com.xmobile.xframework.ui.BaseRecycleFragmentT;
import com.xmobile.xframework.ui.BaseRecyclePagedFragment;
import com.xmobile.xframework.ui.BaseRecyclePagedFragmentT;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/3
 */
public class RankingFragment extends BaseRecyclePagedFragment<RankingBean> {

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        showToolBar(true);
        XImmersionBar.immersion(this);
    }

    @Override
    protected BaseListViewModel<RankingBean> createViewModel() {
        return new RankingViewModel();
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new RankingAdapter(this,this);
    }

    @Override
    public void onModelClicked(RankingBean rankingBean, View view) {

    }
}

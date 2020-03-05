package com.xmobile.pppdemonew.ui.my.ranking;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.RankingBean;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/3
 */
public class RankingAdapter extends SimpleBaseAdapter<RankingViewHolder, RankingBean> {
    public RankingAdapter(LifecycleOwner owner, IRecycleViewCallback<RankingBean> callback) {
        super(owner, callback);
    }
}

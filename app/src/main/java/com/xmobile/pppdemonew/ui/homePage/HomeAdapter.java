package com.xmobile.pppdemonew.ui.homePage;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/19
 */
public class HomeAdapter extends SimpleBaseAdapter<HomeViewHolder, Article> {
    public HomeAdapter(LifecycleOwner owner, IRecycleViewCallback<Article> callback) {
        super(owner, callback);
    }
}

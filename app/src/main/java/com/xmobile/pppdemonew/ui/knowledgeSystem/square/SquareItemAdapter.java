package com.xmobile.pppdemonew.ui.knowledgeSystem.square;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/22
 */
public class SquareItemAdapter extends SimpleBaseAdapter<SquareItemViewHolder, Article> {
    public SquareItemAdapter(LifecycleOwner owner, IRecycleViewCallback<Article> callback) {
        super(owner, callback);
    }
}

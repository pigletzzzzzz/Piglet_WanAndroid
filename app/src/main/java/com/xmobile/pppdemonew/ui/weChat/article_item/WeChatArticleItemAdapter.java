package com.xmobile.pppdemonew.ui.weChat.article_item;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.ui.homePage.HomeViewHolder;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/22
 */
public class WeChatArticleItemAdapter extends SimpleBaseAdapter<WeChatArticleItemViewHolder, Article> {
    public WeChatArticleItemAdapter(LifecycleOwner owner, IRecycleViewCallback<Article> callback) {
        super(owner, callback);
    }
}

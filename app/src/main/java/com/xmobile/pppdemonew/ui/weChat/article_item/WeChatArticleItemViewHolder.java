package com.xmobile.pppdemonew.ui.weChat.article_item;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.databinding.BaseItemBinding;
import com.xmobile.pppdemonew.databinding.HomeItemBinding;
import com.xmobile.pppdemonew.databinding.WechatProjectItemBinding;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewholder.XViewHolder;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/22
 */
public class WeChatArticleItemViewHolder extends XViewHolder<BaseItemBinding, Article> {


    public WeChatArticleItemViewHolder(LifecycleOwner owner, BaseAdapter adapter, BaseItemBinding binding, IRecycleViewCallback<Article> callback) {
        super(owner, adapter, binding, callback);
    }

    @Override
    public void onBind(Article article) {
        binding.setData(article);
    }

    @Override
    protected Article getCurrentT() {
        return binding.getData();
    }
}

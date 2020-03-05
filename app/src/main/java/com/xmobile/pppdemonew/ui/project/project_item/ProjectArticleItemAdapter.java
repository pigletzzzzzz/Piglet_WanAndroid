package com.xmobile.pppdemonew.ui.project.project_item;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/24
 */
public class ProjectArticleItemAdapter extends SimpleBaseAdapter<ProjectArticleItemViewHolder, Article> {
    public ProjectArticleItemAdapter(LifecycleOwner owner, IRecycleViewCallback<Article> callback) {
        super(owner, callback);
    }
}

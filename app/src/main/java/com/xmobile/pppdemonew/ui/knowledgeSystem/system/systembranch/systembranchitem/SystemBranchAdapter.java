package com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch.systembranchitem;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.SimpleBaseAdapter;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/25
 */
public class SystemBranchAdapter extends SimpleBaseAdapter<SystemBranchViewHolder, Article> {
    public SystemBranchAdapter(LifecycleOwner owner, IRecycleViewCallback<Article> callback) {
        super(owner, callback);
    }
}

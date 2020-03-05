package com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch.systembranchitem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.ui.project.project_item.ProjectArticleItemFragment;
import com.xmobile.pppdemonew.ui.webview.WebViewActivity;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;
import com.xmobile.xframework.ui.BaseRecyclePagedFragment;
import com.xmobile.xlogger.XLogger;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/25
 */
public class SystemBranchItemFragment extends BaseRecyclePagedFragment<Article> {

    private int id;

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        toolbar.setVisibility(View.GONE);
    }

    @Override
    protected BaseListViewModel<Article> createViewModel() {
        getData();
        return new SystemBranchViewModel(id);
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new SystemBranchAdapter(this,this);
    }


    /**
     * 获取数据
     */
    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getInt("id", -1);
            XLogger.e("mCurrentItemCount"+"getData,"+id);
        }
    }

    public static Fragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        Fragment fragment= new SystemBranchItemFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onModelClicked(Article article, View view) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("link",article.getLink());
        intent.putExtra("title",article.getTitle());
        getActivity().startActivity(intent);
    }
}

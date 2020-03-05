package com.xmobile.pppdemonew.ui.knowledgeSystem.square;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.ui.webview.WebViewActivity;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;
import com.xmobile.xframework.ui.BaseRecyclePagedFragment;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/22
 */
public class SquareItemFragment extends BaseRecyclePagedFragment<Article> {

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        toolbar.setVisibility(View.GONE);
    }

    @Override
    protected BaseListViewModel<Article> createViewModel() {
        return new SquareItemViewModel();
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new SquareItemAdapter(this,this);
    }

    @Override
    public void onModelClicked(Article article, View view) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("link",article.getLink());
        intent.putExtra("title",article.getTitle());
        getActivity().startActivity(intent);
    }
}

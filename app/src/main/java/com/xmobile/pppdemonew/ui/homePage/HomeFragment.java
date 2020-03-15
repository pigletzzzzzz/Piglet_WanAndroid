package com.xmobile.pppdemonew.ui.homePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.databinding.FragmentHomeBinding;
import com.xmobile.pppdemonew.ui.webview.WebViewActivity;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xframework.ui.BaseRecycleFragment;
import com.xmobile.xframework.ui.BaseRecyclePagedFragment;

public class HomeFragment extends BaseRecyclePagedFragment<Article> {

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        toolbar.setVisibility(View.GONE);

    }

    @Override
    protected BaseListViewModel<Article> createViewModel() {
        return new HomeViewModel();
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new HomeAdapter(this,this);
    }

    @Override
    public void onModelClicked(Article article, View view) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("link",article.getLink());
        intent.putExtra("title",article.getTitle());
        getActivity().startActivity(intent);
    }

}

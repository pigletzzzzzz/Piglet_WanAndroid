package com.xmobile.pppdemonew.ui.weChat.article_item;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.databinding.FragmentWechatarticleItemBinding;
import com.xmobile.pppdemonew.ui.webview.WebViewActivity;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xframework.ui.BaseRecyclePagedFragment;
import com.xmobile.xlogger.XLogger;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/20
 */
public class WeChatArticleItemFragment extends BaseRecyclePagedFragment<Article> {

    private int mId;

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        toolbar.setVisibility(View.GONE);
    }

    @Override
    protected BaseListViewModel<Article> createViewModel() {
        getData();
        XLogger.e("mCurrentItemCount"+"createViewModel,"+mId);
         return new WeChatArticleItemViewModel(mId);
    }

    @Override
    protected BaseAdapter createAdapter() {
        return new WeChatArticleItemAdapter(this,this);
    }

    /**
     * 获取数据
     */
    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mId = bundle.getInt("id", -1);
            XLogger.e("mCurrentItemCount"+"getData,"+mId);
        }
    }

    public static Fragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        Fragment fragment= new WeChatArticleItemFragment();
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

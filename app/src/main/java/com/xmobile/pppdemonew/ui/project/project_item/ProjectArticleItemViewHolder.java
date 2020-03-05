package com.xmobile.pppdemonew.ui.project.project_item;

import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.LifecycleOwner;

import com.bumptech.glide.Glide;
import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.databinding.FragmentProjectarticleItemBinding;
import com.xmobile.pppdemonew.utils.GlideUtils;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewholder.XViewHolder;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/24
 */
public class ProjectArticleItemViewHolder extends XViewHolder<FragmentProjectarticleItemBinding, Article> {
    public ProjectArticleItemViewHolder(LifecycleOwner owner, BaseAdapter adapter, FragmentProjectarticleItemBinding binding, IRecycleViewCallback<Article> callback) {
        super(owner, adapter, binding, callback);
    }

    @Override
    public void onBind(Article article) {
        binding.setData(article);
        if (!TextUtils.isEmpty(article.getEnvelopePic())){
            binding.ivImg.setVisibility(View.VISIBLE);
        }
        GlideUtils.glide(binding.ivImg.getContext(),binding.ivImg, article.getEnvelopePic(), R.mipmap.image_holder);
        if (article.getTags() != null && article.getTags().size() > 0){
            binding.tvTag.setText(article.getTags().get(0).getName());
        }
    }

    @Override
    protected Article getCurrentT() {
        return binding.getData();
    }
}

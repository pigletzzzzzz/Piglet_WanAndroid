package com.xmobile.pppdemonew.ui.my.ranking;

import android.view.View;

import androidx.lifecycle.LifecycleOwner;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.RankingBean;
import com.xmobile.pppdemonew.databinding.FragmentRankingItemBinding;
import com.xmobile.xframework.mvvm.IRecycleViewCallback;
import com.xmobile.xframework.mvvm.adapter.BaseAdapter;
import com.xmobile.xframework.mvvm.viewholder.XViewHolder;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/3
 */
public class RankingViewHolder extends XViewHolder<FragmentRankingItemBinding, RankingBean> {
    public RankingViewHolder(LifecycleOwner owner, BaseAdapter adapter, FragmentRankingItemBinding binding, IRecycleViewCallback<RankingBean> callback) {
        super(owner, adapter, binding, callback);
    }

    @Override
    public void onBind(RankingBean rankingBean) {
        binding.setData(rankingBean);
        if (rankingBean.getRank() == 1){
            binding.rankText.setVisibility(View.GONE);
            binding.rankImg.setVisibility(View.VISIBLE);
            binding.rankImg.setImageResource(R.mipmap.rank_one);
        }else if (rankingBean.getRank() == 2){
            binding.rankText.setVisibility(View.GONE);
            binding.rankImg.setVisibility(View.VISIBLE);
            binding.rankImg.setImageResource(R.mipmap.rank_two);
        }else if (rankingBean.getRank() == 3){
            binding.rankText.setVisibility(View.GONE);
            binding.rankImg.setVisibility(View.VISIBLE);
            binding.rankImg.setImageResource(R.mipmap.rank_three);
        }
    }

    @Override
    protected RankingBean getCurrentT() {
        return binding.getData();
    }
}

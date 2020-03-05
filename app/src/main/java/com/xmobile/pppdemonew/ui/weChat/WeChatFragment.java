package com.xmobile.pppdemonew.ui.weChat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.google.android.material.tabs.TabLayout;
import com.xmobile.pppdemonew.data.bean.Tab;
import com.xmobile.pppdemonew.databinding.FragmentWechatBinding;
import com.xmobile.pppdemonew.ui.adapter.TabAdapter;
import com.xmobile.pppdemonew.ui.main.MainViewModel;
import com.xmobile.pppdemonew.ui.weChat.article_item.WeChatArticleItemFragment;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xlogger.XLogger;

import java.util.ArrayList;
import java.util.List;


public class WeChatFragment extends BaseFragmentBing<FragmentWechatBinding> {

    private MainViewModel mainViewModel;
    private int mCurrentItemCount;
    private List<String> tabName = new ArrayList<>();
    private List<Integer> tabIdList = new ArrayList<>();
    private List<Tab> tabList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected FragmentWechatBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        mainViewModel = new MainViewModel();
        mainViewModel.getTab().observe(this, new Observer<Resource<List<Tab>>>() {
            @Override
            public void onChanged(Resource<List<Tab>> listResource) {
                if (listResource.status == Status.SUCCESS){
                    XLogger.e("mCurrentItemCount,"+listResource.data.size());
                    mCurrentItemCount = listResource.data.size();
                    tabList = listResource.data;
                    for (Tab tab : listResource.data){
                        tabName.add(tab.getName());
                        tabIdList.add(tab.getId());
                    }
                    for(int i=0;i<mCurrentItemCount;i++){
                        XLogger.e("mCurrentItemCount,"+mCurrentItemCount);
                        fragmentList.add(WeChatArticleItemFragment.newInstance(tabIdList.get(i)));
                    }
                    TabAdapter adapter = new TabAdapter(getChildFragmentManager(),fragmentList,tabName);
                    binding.vp.setAdapter(adapter);
                    binding.tabSpl.setViewPager(binding.vp);
                }
            }
        });


    }
}

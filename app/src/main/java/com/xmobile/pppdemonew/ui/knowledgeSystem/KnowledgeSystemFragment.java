package com.xmobile.pppdemonew.ui.knowledgeSystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xmobile.pppdemonew.databinding.FragmentKnowledgesystemBinding;
import com.xmobile.pppdemonew.ui.adapter.TabAdapter;
import com.xmobile.pppdemonew.ui.homePage.HomeFragment;
import com.xmobile.pppdemonew.ui.knowledgeSystem.navigation.NavigationFragment;
import com.xmobile.pppdemonew.ui.knowledgeSystem.square.SquareItemFragment;
import com.xmobile.pppdemonew.ui.knowledgeSystem.system.SystemItemFragment;
import com.xmobile.xframework.ui.BaseFragment;
import com.xmobile.xframework.ui.BaseFragmentBing;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeSystemFragment extends BaseFragmentBing<FragmentKnowledgesystemBinding> {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private TabAdapter adapter;

    @Override
    protected FragmentKnowledgesystemBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        initTab();
    }

    private void initTab(){
        mFragmentList.clear();
        titles.clear();

        mFragmentList.add(new SquareItemFragment());
        mFragmentList.add(new SystemItemFragment());
        mFragmentList.add(new NavigationFragment());

        titles.add("广场");
        titles.add("体系");
        titles.add("导航");

        adapter = new TabAdapter(getFragmentManager(),mFragmentList,titles);
        binding.vp.setAdapter(adapter);
        binding.tab.setupWithViewPager(binding.vp);
    }

}

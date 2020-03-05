package com.xmobile.pppdemonew.ui.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.pppdemonew.data.bean.Tab;
import com.xmobile.pppdemonew.databinding.FragmentProjectBinding;
import com.xmobile.pppdemonew.ui.adapter.TabAdapter;
import com.xmobile.pppdemonew.ui.main.MainViewModel;
import com.xmobile.pppdemonew.ui.project.project_item.ProjectArticleItemFragment;
import com.xmobile.pppdemonew.ui.weChat.article_item.WeChatArticleItemFragment;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.ui.BaseFragmentBing;

import java.util.ArrayList;
import java.util.List;

public class ProjectFragment extends BaseFragmentBing<FragmentProjectBinding> {

    private MainViewModel mainViewModel;
    private int mCurrentItemCount;
    private List<String> pjName = new ArrayList<>();
    private List<Integer> pjIdList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected FragmentProjectBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        mainViewModel = new MainViewModel();
        mainViewModel.getProjectItem().observe(this, new Observer<Resource<List<SystemBean>>>() {
            @Override
            public void onChanged(Resource<List<SystemBean>> listResource) {
                if (listResource.status == Status.SUCCESS){
                    mCurrentItemCount = listResource.data.size();
                    for (SystemBean systemBean : listResource.data){
                        pjName.add(systemBean.getName());
                        pjIdList.add(systemBean.getId());
                    }
                    for(int i=0;i<mCurrentItemCount;i++){
                        fragmentList.add(ProjectArticleItemFragment.newInstance(pjIdList.get(i)));
                    }
                    TabAdapter adapter = new TabAdapter(getChildFragmentManager(),fragmentList,pjName);
                    binding.vp.setAdapter(adapter);
                    binding.tabSpl.setViewPager(binding.vp);
                }
            }
        });
    }
}

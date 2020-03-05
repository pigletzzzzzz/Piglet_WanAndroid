package com.xmobile.pppdemonew.ui.knowledgeSystem.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.bean.NavigationBean;
import com.xmobile.pppdemonew.databinding.FragmentSystemItemBinding;
import com.xmobile.pppdemonew.ui.knowledgeSystem.system.SystemItemViewModel;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xlogger.XLogger;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/23
 */
public class NavigationFragment extends BaseFragmentBing<FragmentSystemItemBinding> {

    private SystemItemViewModel systemItemViewModel;
    private NavigationAdapter navigationAdapter;

    @Override
    protected FragmentSystemItemBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        systemItemViewModel = new SystemItemViewModel();
        systemItemViewModel.getNavigation().observe(this, new Observer<Resource<List<NavigationBean>>>() {
            @Override
            public void onChanged(Resource<List<NavigationBean>> listResource) {
                if (listResource.status == Status.SUCCESS){
                    XLogger.e("NavigationFragment"+listResource.data.size());
                    binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
                    binding.rv.setItemViewCacheSize(listResource.data.size());
                    navigationAdapter = new NavigationAdapter(getContext(),listResource.data);
                    navigationAdapter.setOnItemClickListener(new NavigationAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(Article bean, int pos) {
                            XLogger.e("SystemItemFragment"+bean.getTitle()+","+pos);
                        }
                    });
                    binding.rv.setAdapter(navigationAdapter);
                }
            }
        });
    }
}

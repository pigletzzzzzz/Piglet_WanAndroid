package com.xmobile.pppdemonew.ui.knowledgeSystem.system;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.pppdemonew.databinding.FragmentSystemItemBinding;
import com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch.SystemBranchActivity;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xlogger.XLogger;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/22
 */
public class SystemItemFragment extends BaseFragmentBing<FragmentSystemItemBinding> {

    private SystemItemViewModel systemItemViewModel;
    private SystemItemAdapter systemItemAdapter;

    @Override
    protected FragmentSystemItemBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        systemItemViewModel = new SystemItemViewModel();
        systemItemViewModel.getSystemItem().observe(this, new Observer<Resource<List<SystemBean>>>() {
            @Override
            public void onChanged(Resource<List<SystemBean>> listResource) {
                if (listResource.status == Status.SUCCESS){
                    binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
                    binding.rv.setItemViewCacheSize(listResource.data.size());
                    systemItemAdapter = new SystemItemAdapter(getContext(),listResource.data);
                    systemItemAdapter.setOnItemClickListener(new SystemItemAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(SystemBean bean, int pos) {
//                            SystemBranchFragment.newInstance(bean,pos);
                            Intent intent = new Intent(getActivity(), SystemBranchActivity.class);
                            intent.putExtra("pos",pos);
                            intent.putExtra("datas",bean);
                            getActivity().startActivity(intent);
                            XLogger.e("SystemItemFragment"+bean+","+pos);
                        }
                    });
                    binding.rv.setAdapter(systemItemAdapter);
                }
            }
        });

    }
}

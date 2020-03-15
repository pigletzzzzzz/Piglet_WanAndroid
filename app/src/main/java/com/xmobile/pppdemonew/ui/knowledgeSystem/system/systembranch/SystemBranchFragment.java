package com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.pppdemonew.databinding.FragmentSystemBranchBinding;
import com.xmobile.pppdemonew.databinding.FragmentWechatBinding;
import com.xmobile.pppdemonew.ui.adapter.TabAdapter;
import com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch.systembranchitem.SystemBranchItemFragment;
import com.xmobile.pppdemonew.ui.weChat.article_item.WeChatArticleItemFragment;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xlogger.XLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/25
 */
public class SystemBranchFragment extends BaseFragmentBing<FragmentSystemBranchBinding> {

    private int mCurrentItemCount;
    private List<String> tabName = new ArrayList<>();
    private List<Integer> tabIdList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private int pos;
    private SystemBean datas;

    @Override
    protected FragmentSystemBranchBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pos = ((SystemBranchActivity)context).getPos();
        datas = ((SystemBranchActivity)context).getSystemBean();
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        XLogger.e("mCurrentItemCount"+datas.getChildren().size()+","+pos);
        if (pos != -1 && datas != null){
            List<SystemBean> childs = datas.getChildren();
            mCurrentItemCount = childs.size();
            for (SystemBean bean : childs){
                tabName.add(bean.getName());
                tabIdList.add(bean.getId());
            }
            for(int i=0;i<mCurrentItemCount;i++){
                XLogger.e("SystemBranchViewModel,ItemCount,"+i);
                fragmentList.add(SystemBranchItemFragment.newInstance(tabIdList.get(i)));
            }

            TabAdapter adapter = new TabAdapter(getChildFragmentManager(),fragmentList,tabName);
            binding.vp.setAdapter(adapter);
            binding.tabSpl.setViewPager(binding.vp);
            if (pos != -1 && pos > 0){
                binding.tabSpl.setCurrentTab(pos);
            }
        }

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

//    /**
//     * 获取数据
//     */
//    private void getData() {
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            pos = bundle.getInt("pos", -1);
//            datas = (SystemBean) bundle.getSerializable("datas");
//            XLogger.e("mCurrentItemCount"+datas.getChildren().size()+","+pos);
//        }
//    }
//
//    public static Fragment newInstance(SystemBean bean, int pos) {
//        Bundle bundle = new Bundle();
//        bundle.putInt("pos", pos);
//        bundle.putSerializable("data",bean);
//        Fragment fragment= new SystemBranchFragment();
//        fragment.setArguments(bundle);
//        return fragment;
//    }
}

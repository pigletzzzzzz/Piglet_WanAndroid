package com.xmobile.pppdemonew.ui.main.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.xmobile.pppdemonew.R;
import com.xmobile.pppdemonew.data.bean.BannerBean;
import com.xmobile.pppdemonew.databinding.FragmentMainBinding;

import com.xmobile.pppdemonew.ui.homePage.HomeFragment;
import com.xmobile.pppdemonew.ui.knowledgeSystem.KnowledgeSystemFragment;
import com.xmobile.pppdemonew.ui.main.MainViewModel;
import com.xmobile.pppdemonew.ui.my.MyFragment;
import com.xmobile.pppdemonew.ui.project.ProjectFragment;
import com.xmobile.pppdemonew.ui.weChat.WeChatFragment;
import com.xmobile.pppdemonew.utils.GlideUtils;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.data.Status;
import com.xmobile.xframework.ui.BaseFragment;
import com.xmobile.xframework.ui.BaseFragmentBing;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;


public class FragmentMain extends BaseFragmentBing<FragmentMainBinding> implements View.OnClickListener {

    private MainViewModel viewModel;
    private int mPreFragmentPosition = 0;//上一个被选中的Fragment位置
    private Fragment[] mFragments;
    private List<BannerBean> bannerBeans;
    private List<String> urls = new ArrayList<>();
    @Override
    protected FragmentMainBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater, viewGroup, false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);
        viewModel = new MainViewModel();
        iniBanner();
        binding.banner.setVisibility(View.VISIBLE);

        mFragments = new BaseFragment[5];
        if (savedInstanceState == null) {
            mFragments[0] = new HomeFragment();//首页
            mFragments[1] = new KnowledgeSystemFragment();//知识体系
            mFragments[2] = new WeChatFragment();//公众号
            mFragments[3] = new ProjectFragment();//项目
            mFragments[4] = new MyFragment();//我
            loadMultipleFragment(R.id.frameContain, 0, mFragments);
        }else {
             //屏幕翻转后回到当前页面
            mFragments[0] = findFragmentByTag(HomeFragment.class.getName());
            mFragments[1] = findFragmentByTag(KnowledgeSystemFragment.class.getName());
            mFragments[2] = findFragmentByTag(WeChatFragment.class.getName());
            mFragments[3] = findFragmentByTag(ProjectFragment.class.getName());
            mFragments[4] = findFragmentByTag(MyFragment.class.getName());
        }

        initBottomNavigationView();

    }

    private void iniBanner(){
        viewModel.getBanner().observe(this, new Observer<Resource<List<BannerBean>>>() {
            @Override
            public void onChanged(Resource<List<BannerBean>> listResource) {
                if (listResource.status == Status.SUCCESS){
                    bannerBeans = listResource.data;
                    for (BannerBean bean : bannerBeans){
                        urls.add(bean.getImagePath());
                    }
                    if (urls != null){
                        binding.banner.setData(urls,null);
                        binding.banner.loadImage(new XBanner.XBannerAdapter() {
                            @Override
                            public void loadBanner(XBanner banner, Object model, View view, int position) {
                                Picasso.with(getActivity()).load(urls.get(position)).into((ImageView) view);
                            }
                        });
                    }
                    binding.banner.setPageTransformer(Transformer.Default);

                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    private void initBottomNavigationView() {
        binding.BottomBnv.setItemIconTintList(null);
        binding.BottomBnv.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.homeItem:
                    showAndHideFragment(mFragments[0], mFragments[mPreFragmentPosition]);
                    mPreFragmentPosition = 0;
                    binding.banner.setVisibility(View.VISIBLE);
                    break;
                case R.id.systemItem:
                    showAndHideFragment(mFragments[1], mFragments[mPreFragmentPosition]);
                    mPreFragmentPosition = 1;
                    binding.banner.setVisibility(View.GONE);
                    binding.toolbar.setVisibility(View.GONE);
                    break;
                case R.id.wxItem:
                    showAndHideFragment(mFragments[2], mFragments[mPreFragmentPosition]);
                    mPreFragmentPosition = 2;
                    binding.banner.setVisibility(View.GONE);
                    break;
                case R.id.projectItem:
                    showAndHideFragment(mFragments[3], mFragments[mPreFragmentPosition]);
                    mPreFragmentPosition = 3;
                    binding.banner.setVisibility(View.GONE);
                    break;
                case R.id.personItem:
                    showAndHideFragment(mFragments[4], mFragments[mPreFragmentPosition]);
                    mPreFragmentPosition = 4;
                    binding.banner.setVisibility(View.GONE);
                    binding.toolbar.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
            return true;
        });
    }


    /**
     * 根据tag找到fragment实例
     */
    private Fragment findFragmentByTag(String tag) {
        return getFragmentManager().findFragmentByTag(tag);
    }

    /**
     * 显示和隐藏fragment
     */
    private void showAndHideFragment(Fragment show, Fragment hide) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (show != hide)
            transaction.show(show).hide(hide).commitAllowingStateLoss();
    }

    /**
     * 装载Fragments
     */
    private void loadMultipleFragment(int containerId, int showFragment, Fragment... fragments) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            Fragment fragment = fragments[i];
            //最后一个参数为tag,add的时候添加一个tag来可以通过findFragmentByTag来查找fragment的实例
            transaction.add(containerId, fragment,fragment.getClass().getName());
            if (i != showFragment) {
                transaction.hide(fragment);
            }
        }
        transaction.commitAllowingStateLoss();
    }


}

package com.xmobile.pppdemonew.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.xmobile.pppdemonew.AppConstants;
import com.xmobile.pppdemonew.data.bean.LoginBean;
import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.pppdemonew.data.bean.UserInfoBean;
import com.xmobile.pppdemonew.databinding.FragmentMyBinding;
import com.xmobile.pppdemonew.ui.login.LoginV2Activity;
import com.xmobile.pppdemonew.ui.my.mylevel.MyLevelActivity;
import com.xmobile.pppdemonew.ui.my.mylevel.MyLevelViewModel;
import com.xmobile.pppdemonew.ui.my.ranking.RankingActivity;
import com.xmobile.pppdemonew.utils.SharedPreferencesUtils;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.ui.BaseFragmentBing;
import com.xmobile.xlogger.XLogger;

import java.util.List;

public class MyFragment extends BaseFragmentBing<FragmentMyBinding> {
    @Override
    protected FragmentMyBinding getInflate(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return binding.inflate(layoutInflater,viewGroup,false);
    }

    @Override
    public void initViews(View view, @Nullable Bundle savedInstanceState) {
        super.initViews(view, savedInstanceState);

        if (!TextUtils.isEmpty(SharedPreferencesUtils.getT(getActivity(),AppConstants.USERNAME,""))){
            String username = SharedPreferencesUtils.getT(getActivity(),AppConstants.USERNAME,"");
            String level = SharedPreferencesUtils.getT(getActivity(),AppConstants.LEVEL,"");
            String userid = SharedPreferencesUtils.getT(getActivity(),AppConstants.USERID,"");
            String rank = SharedPreferencesUtils.getT(getActivity(),AppConstants.RANK,"");
            XLogger.e("MyFragment"+","+username+","+userid+","+level+","+rank);
            binding.username.setText(username);
            binding.userId.setText(userid);
            binding.userLevel.setText("等级"+level);
            binding.userRanking.setText(rank);
        }else {
            binding.username.setText("请登录");
            binding.userId.setText("-");
            binding.userLevel.setText("等级0");
            binding.userRanking.setText("-");
        }

        LiveEventBus.get().with("userInfo", Boolean.class)
        .observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    String username = SharedPreferencesUtils.getT(getActivity(),AppConstants.USERNAME,"");
                    String level = SharedPreferencesUtils.getT(getActivity(),AppConstants.LEVEL,"");
                    String userid = SharedPreferencesUtils.getT(getActivity(),AppConstants.USERID,"");
                    String rank = SharedPreferencesUtils.getT(getActivity(),AppConstants.RANK,"");
                    binding.username.setText(username);
                    binding.userId.setText(userid);
                    binding.userLevel.setText("等级"+level);
                    binding.userRanking.setText(rank);
                }
            }
        });

        binding.rlInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(SharedPreferencesUtils.getT(getActivity(), AppConstants.USERNAME,""))){
                    return;
                }
                Intent intent = new Intent(getActivity(), LoginV2Activity.class);
                getActivity().startActivity(intent);
            }
        });

        binding.tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.putT(getActivity(),AppConstants.USERNAME,"");
                SharedPreferencesUtils.putT(getActivity(),AppConstants.PASSWORK,"");
                SharedPreferencesUtils.putT(getActivity(),AppConstants.RANK,"");
                SharedPreferencesUtils.putT(getActivity(),AppConstants.USERID,"");
                SharedPreferencesUtils.putT(getActivity(),AppConstants.LEVEL,"");

                binding.username.setText("请登录");
                binding.userId.setText("-");
                binding.userLevel.setText("等级0");
                binding.userRanking.setText("-");
            }
        });

        binding.llMyPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyLevelActivity.class);
                getActivity().startActivity(intent);
            }
        });

        binding.llMyIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankingActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

}

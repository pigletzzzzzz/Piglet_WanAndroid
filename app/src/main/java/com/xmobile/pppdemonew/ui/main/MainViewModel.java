package com.xmobile.pppdemonew.ui.main;


import com.xmobile.pppdemonew.data.bean.BannerBean;
import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.pppdemonew.data.bean.Tab;
import com.xmobile.pppdemonew.data.bean.User;
import com.xmobile.pppdemonew.data.repository.IRepository;

import com.xmobile.pppdemonew.data.repository.RepositoryFactory;

import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseViewModel;

import androidx.lifecycle.LiveData;

import java.util.List;


public class MainViewModel extends BaseViewModel

{
    IRepository repository = RepositoryFactory.createOrgetRepository();

    //获取用户信息，只在Debug时有用，Main里面一定要加上，不然无法使用
    //        SessionManage.myself
//    public LiveData<Resource<User>> getCurrentUser() {
//        return repository.getCurrentUser();
//    }

    public LiveData<Resource<List<Tab>>> getTab(){
        return repository.getWxTabs();
    }

    public LiveData<Resource<List<SystemBean>>> getProjectItem(){
        return repository.getProjectItem();
    }

    public LiveData<Resource<List<BannerBean>>> getBanner(){
        return repository.getBanner();
    }

}

package com.xmobile.pppdemonew.ui.login;


import android.content.Context;


import com.xmobile.pppdemonew.data.bean.LoginBean;
import com.xmobile.pppdemonew.data.bean.LoginYZM;
import com.xmobile.pppdemonew.data.bean.ReposiLoginBean;
import com.xmobile.pppdemonew.data.bean.UserInfoBean;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.pppdemonew.data.viewmodel.XBaseViewModel;
import com.xmobile.xframework.mvvm.data.Resource;

import androidx.lifecycle.LiveData;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/8/9.
 */

public class LoginViewModel extends XBaseViewModel {

    IRepository repository = RepositoryFactory.createOrgetRepository();

    public LiveData<Resource<LoginBean>> login(String username, String password){
        return repository.login(username, password);
    }

    public LiveData<Resource<LoginBean>> register(String username,String password,String repassword){
        return repository.register(username, password, repassword);
    }

    public LiveData<Resource<UserInfoBean>> getUserInfo(String username, String password){
        return repository.getUserInfo(username, password);
    }
}

package com.xmobile.pppdemonew.ui.my.mylevel;

import androidx.lifecycle.LiveData;

import com.xmobile.pppdemonew.AppConstants;
import com.xmobile.pppdemonew.data.bean.MyLevelBean;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.pppdemonew.utils.SharedPreferencesUtils;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListPagedViewModel;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/1
 */
public class MyLevelViewModel extends BaseListPagedViewModel<MyLevelBean> {

    private IRepository repository= RepositoryFactory.createOrgetRepository();
    private String username;
    private String password;


    @Override
    public LiveData<Resource<List<MyLevelBean>>> getModels() {
        return repository.getMyLevel(page+1);
    }
}

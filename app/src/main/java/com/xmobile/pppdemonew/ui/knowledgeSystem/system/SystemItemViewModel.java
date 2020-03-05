package com.xmobile.pppdemonew.ui.knowledgeSystem.system;

import android.view.View;

import androidx.lifecycle.LiveData;

import com.chad.library.adapter.base.BaseViewHolder;
import com.xmobile.pppdemonew.data.bean.NavigationBean;
import com.xmobile.pppdemonew.data.bean.SystemBean;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseViewModel;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/22
 */
public class SystemItemViewModel extends BaseViewModel {

    private IRepository repository= RepositoryFactory.createOrgetRepository();

    public LiveData<Resource<List<SystemBean>>> getSystemItem(){
        return repository.getSystemItem();
    }

    public LiveData<Resource<List<NavigationBean>>> getNavigation(){
        return repository.getNavigation();
    }

}

package com.xmobile.pppdemonew.data.viewmodel;


import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.viewmodel.BaseViewModel;

/**
 * time :2019/8/14 14:47
 * version:1.0
 * 黄卫华(wayhua@126.com)
 */
public class XBaseViewModel extends BaseViewModel {
    protected IRepository repository = RepositoryFactory.createOrgetRepository();

}

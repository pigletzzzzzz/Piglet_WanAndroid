package com.xmobile.pppdemonew.data.viewmodel;


import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.viewmodel.BaseListViewModel;

/**
 * time :2019/8/14 16:29
 * version:1.0
 * 黄卫华(wayhua@126.com)
 */
public abstract   class XBaseListViewModel<T> extends BaseListViewModel<T> {
    protected IRepository repository = RepositoryFactory.createOrgetRepository();

}

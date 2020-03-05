package com.xmobile.pppdemonew.ui.homePage;

import androidx.lifecycle.LiveData;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListPagedViewModel;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/19
 */
public class HomeViewModel extends BaseListPagedViewModel<Article> {

    private IRepository repository= RepositoryFactory.createOrgetRepository();

    @Override
    public LiveData<Resource<List<Article>>> getModels() {
        return repository.getarticles(page-1);
    }
}

package com.xmobile.pppdemonew.ui.project.project_item;

import androidx.lifecycle.LiveData;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListPagedViewModel;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/24
 */
public class ProjectArticleItemViewModel extends BaseListPagedViewModel<Article> {

    private IRepository repository= RepositoryFactory.createOrgetRepository();
    private int id;

    public ProjectArticleItemViewModel(int id) {
        this.id = id;
    }

    @Override
    public LiveData<Resource<List<Article>>> getModels() {
        return repository.getProjectAuthorItem(page,id);
    }
}

package com.xmobile.pppdemonew.ui.knowledgeSystem.system.systembranch.systembranchitem;

import androidx.lifecycle.LiveData;

import com.xmobile.pppdemonew.data.bean.Article;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListPagedViewModel;
import com.xmobile.xlogger.XLogger;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/25
 */
public class SystemBranchViewModel extends BaseListPagedViewModel<Article> {

    private IRepository repository= RepositoryFactory.createOrgetRepository();
    private int id;

    public SystemBranchViewModel(int id) {
        this.id = id;
    }

    @Override
    public LiveData<Resource<List<Article>>> getModels() {
        XLogger.e("SystemBranchViewModel,"+page+"/"+id);
        return repository.getSystemAuthorItem(page-1,id);
    }
}

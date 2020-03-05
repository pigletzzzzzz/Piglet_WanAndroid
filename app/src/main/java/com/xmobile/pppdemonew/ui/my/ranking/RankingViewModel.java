package com.xmobile.pppdemonew.ui.my.ranking;

import androidx.lifecycle.LiveData;

import com.xmobile.pppdemonew.data.bean.RankingBean;
import com.xmobile.pppdemonew.data.repository.IRepository;
import com.xmobile.pppdemonew.data.repository.RepositoryFactory;
import com.xmobile.xframework.mvvm.data.Resource;
import com.xmobile.xframework.mvvm.viewmodel.BaseListPagedViewModel;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/3
 */
public class RankingViewModel extends BaseListPagedViewModel<RankingBean> {

    private IRepository repository= RepositoryFactory.createOrgetRepository();

    @Override
    public LiveData<Resource<List<RankingBean>>> getModels() {
        return repository.getRanking(page);
    }
}

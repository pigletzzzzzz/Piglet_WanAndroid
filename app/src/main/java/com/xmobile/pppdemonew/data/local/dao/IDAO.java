package com.xmobile.pppdemonew.data.local.dao;


import java.util.List;

import androidx.lifecycle.LiveData;

public interface IDAO<T> {

    LiveData<List<T>> loadEntities();
    List<T> loadEntitiesList();

    void save(List<T> entities);
    void save(T entity);

    void delete(List<T> entities);
    void delete(T entity);
}

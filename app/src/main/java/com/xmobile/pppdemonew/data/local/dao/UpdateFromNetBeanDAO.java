package com.xmobile.pppdemonew.data.local.dao;



import com.xmobile.pppdemonew.data.bean.UpdateFromNetBean;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by 黄卫华(wayhua@126.com) on 2018/1/3.
 */
@Dao
public interface UpdateFromNetBeanDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(UpdateFromNetBean action);

    @Delete
    void delete(UpdateFromNetBean action);

    @Query("SELECT * FROM " + UpdateFromNetBean.TABLENAME + " WHERE tablename=:tablename  order by id desc   limit 1")
    LiveData<UpdateFromNetBean> load(String tablename);

    @Query("SELECT * FROM " + UpdateFromNetBean.TABLENAME + " WHERE tablename=:tablename  order by id desc   limit 1")
    UpdateFromNetBean loadbyname(String tablename);


}

package com.xmobile.pppdemonew.data.local.db;



import com.xmobile.pppdemonew.BuildConfig;
import com.xmobile.pppdemonew.data.bean.UpdateFromNetBean;
import com.xmobile.pppdemonew.data.local.dao.UpdateFromNetBeanDAO;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


/**
 * Created by 黄卫华(wayhua@126.com) on 2017/8/17.
 */
@Database(entities = {
  UpdateFromNetBean.class

}
        , version = BuildConfig.dbVesion
        , exportSchema = false)
@TypeConverters({DateTypeConverter.class
        , ListConverter.class

})
public abstract class PPPDatabase extends RoomDatabase {


    public abstract UpdateFromNetBeanDAO updateFromNetBeanDAO();

}


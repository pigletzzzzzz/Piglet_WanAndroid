package com.xmobile.pppdemonew.data.local;

import android.content.Context;


import com.xmobile.pppdemonew.data.local.dao.UpdateFromNetBeanDAO;
import com.xmobile.pppdemonew.data.local.db.PPPDatabase;

import androidx.room.Room;


/**
 * Created by 黄卫华(wayhua@126.com) on 2017/8/17.
 */

public class LocalDb {
    private static PPPDatabase database;

    public static void init(Context context) {
        database = Room.databaseBuilder(context.getApplicationContext(),
                PPPDatabase.class, "pppv8plugindb.db")
                .fallbackToDestructiveMigration()
                // .allowMainThreadQueries()
                // .addMigrations()
                .build();
    }


    public static UpdateFromNetBeanDAO updateFromNetBeanDAO() {
        return database.updateFromNetBeanDAO();
    }



}





package com.xmobile.pppdemonew.data.repository;


import android.content.Context;

import com.xmobile.pppdemonew.BuildConfig;
import com.xmobile.pppdemonew.data.repository.v2.RepositoryV2;

/**
 * time :2019/8/13 18:02
 * version:1.0
 * 黄卫华(wayhua@126.com)
 */
public class RepositoryFactory {




    private static IRepository repositoryv2 = null;

    public static IRepository createOrgetRepository( ) {
        //这里可以定义多个不同的Repository


                if (repositoryv2 == null) {
                    repositoryv2 = new RepositoryV2();

                }
                return repositoryv2;


    }



    public static void init(Context context) {
        IRepository repository = createOrgetRepository();
        repository.init(context);
    }
}

package com.xmobile.pppdemonew.data.resource;


import com.xmobile.xframework.mvvm.data.Resource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

/**
 * Created by 黄卫华(wayhua@126.com) on 2018/2/28.
 */

public  abstract class XDBFirstConstantNetworkResource<ResultType>
        extends DBFirstConstantNetworkResource<Resource<ResultType>> {

    public XDBFirstConstantNetworkResource(int checkminutes, String tablename) {
        super(checkminutes, tablename);
    }

    public XDBFirstConstantNetworkResource(String tablename) {
        super(tablename);
    }

    @Override
    protected LiveData<Resource<ResultType>> loadFaileddata(String errormsg) {
        MediatorLiveData<Resource<ResultType>> liveData = new MediatorLiveData<>();
        liveData.setValue(Resource.error(errormsg, null));
        return liveData;
    }


}

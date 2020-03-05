package com.xmobile.pppdemonew.data.resource;


import android.os.AsyncTask;

import com.xmobile.xframework.mvvm.data.Resource;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 黄卫华(wayhua@126.com) on 2017/8/9.
 */

public abstract class SimpleNetworkResource<ResultType> {
    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    @MainThread
    public SimpleNetworkResource() {
        result.setValue(Resource.loading(null));

        fetchFromNetwork();

    }

    private void fetchFromNetwork() {

        createCall()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResultType>() {
                    @Override
                    public void accept(ResultType response) throws Exception {
                        saveResultAndReInit(response);
                        result.setValue(Resource.success(response));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onFetchFailed(throwable.getMessage());
                        result.setValue(Resource.error(throwable.getMessage(), null));

                    }
                });
    }

    @MainThread
    private void saveResultAndReInit(ResultType response) {
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {

                saveCallResult(response);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {

            }
        }.execute();
    }

    @NonNull
    @MainThread
    protected abstract Observable<ResultType> createCall();

    public final LiveData<Resource<ResultType>> getAsLiveData() {
        return result;
    }

    @WorkerThread
    protected void saveCallResult(@NonNull ResultType item) {

    }

    @MainThread
    protected void onFetchFailed(String errmsg) {

    }
}

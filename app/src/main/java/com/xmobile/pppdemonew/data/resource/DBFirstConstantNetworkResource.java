package com.xmobile.pppdemonew.data.resource;


import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;


import com.xmobile.pppdemonew.data.bean.UpdateFromNetBean;
import com.xmobile.pppdemonew.data.local.LocalDb;

import java.util.Date;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by 黄卫华(wayhua@126.com) on 2018/1/10.
 */

public abstract class DBFirstConstantNetworkResource<ResultType> {
    public static final int DefaultCheckMinutes = 1 * 60;//每1分钟拉取一次
    protected final MediatorLiveData<ResultType> result = new MediatorLiveData<>();
    String tablename;
    int checksencond;
//    private final Lock lock = new ReentrantLock();

    public DBFirstConstantNetworkResource(int checkminutes, String tablename) {
        this.tablename = tablename;
        this.checksencond = checkminutes;
        docheckDbStatus();
    }

    public DBFirstConstantNetworkResource(String tablename) {
        this(DefaultCheckMinutes, tablename);
    }

    static final int LOADFROMDB = 222;
    private final Handler mainHandler = new Handler()//(Looper.getMainLooper());
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOADFROMDB:
                    _loadFromdb();
                    break;
            }
        }
    };

    private void docheckDbStatus() {
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {

                UpdateFromNetBean bean = LocalDb.updateFromNetBeanDAO()
                        .loadbyname(tablename);
                if (checkFectch(bean)) {
                    fetchFromNetwork();
                } else {
                    mainHandler.sendEmptyMessage(LOADFROMDB);

                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {

            }
        }.execute();


    }

    // @SuppressLint("CheckResult")
    @MainThread
    protected void _loadFromdb() {
        Observable.create(new ObservableOnSubscribe<ResultType>() {

            @Override
            public void subscribe(ObservableEmitter<ResultType> emitter) throws Exception {
                ResultType resultType = loadFromDb();
                emitter.onNext(resultType);
                emitter.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResultType>() {
                    @Override
                    public void accept(ResultType resultType) throws Exception {
                        result.setValue(resultType);
                    }
                });


//        result.addSource(loadFromDb(), new Observer<ResultType>() {
//
//            @Override
//            public void onChanged(@Nullable ResultType resultType) {
//                result.setValue(resultType);
//            }
//        });


    }

    @WorkerThread
    protected abstract ResultType loadFromDb();


    protected boolean checkFectch(UpdateFromNetBean bean) {
        if (bean == null) {
            return true;
        }
        return checkTime(bean.getLastUpdateTime());
    }

    protected boolean checkTime(Date lastUpdateTime) {
        if (lastUpdateTime == null)
            return true;
        Date now = new Date();
        if ((now.getTime() - lastUpdateTime.getTime()) / 1000 > checksencond)
            return true;
        else return false;
    }

    private void fetchFromNetwork() {
        createCall()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResultType>() {
                    @Override
                    public void accept(ResultType resultType) throws Exception {
                        updateDBStatus();
                        saveResultAndReInit(resultType);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onFetchFailed(throwable.getMessage());
                    }
                });
    }

    @MainThread
    private void saveResultAndReInit(final ResultType response) {

        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
                //    Looper.prepare();
                saveCallResult(response);
                // _loadFromdb();
                mainHandler.sendEmptyMessage(LOADFROMDB);
                //   Looper.loop();
                //这种情况下，Runnable对象是运行在子线程中的，可以进行联网操作，但是不能更新UI
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                // _loadFromdb();
            }
        }.execute();
    }

    private void reloadDb(ResultType response) {
        MediatorLiveData<ResultType> liveData = new MediatorLiveData<>();
        liveData.setValue(response);
        result.addSource(liveData, new Observer<ResultType>() {
            //
            @Override
            public void onChanged(@Nullable ResultType resultType) {
                result.setValue(resultType);
            }
        });
    }

    protected void updateDBStatus() {
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
//                lock.lock();
//                try {
                UpdateFromNetBean bean = LocalDb.updateFromNetBeanDAO().loadbyname(tablename);
                if (bean == null) {
                    bean = new UpdateFromNetBean();
                }
                bean.setLastUpdateTime(new Date());
                bean.setTablename(tablename);
                LocalDb.updateFromNetBeanDAO().save(bean);
//                } catch (Exception ex) {
//                } finally {
//                    lock.unlock();
//                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {

            }
        }.execute();
    }

    private void onFetchFailed(String errormsg) {
        result.addSource(loadFaileddata(errormsg), new Observer<ResultType>() {

            @Override
            public void onChanged(@Nullable ResultType resultType) {
                result.setValue(resultType);
            }
        });
    }

    protected LiveData<ResultType> loadFaileddata(String errormsg) {
        MediatorLiveData<ResultType> liveData = new MediatorLiveData<>();
        return liveData;
    }


    protected abstract void saveCallResult(ResultType response);


    @NonNull
    @MainThread
    protected abstract Observable<ResultType> createCall();

    public final LiveData<ResultType> getAsLiveData() {
        return result;
    }


}

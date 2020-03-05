package com.xmobile.pppdemonew.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.IBinder;

import android.os.RemoteException;
import android.text.TextUtils;


import com.xmobile.ppplatformv8.IPPPlatformV8Service;

import java.util.List;

public class AidlBinder {

    private static final String REMOTESERVICE = "com.xmobile.ppplatformv8.BackService";

    private AidlConnection aidlConnection;



    public AidlBinder(AidlConnectionCallback callback) {
        this.aidlConnection = new AidlConnection(callback);
    }

    public void bind(Context context, final String remoteservice) throws Exception {
        Intent intent;
        if (TextUtils.isEmpty(remoteservice)) {
            intent = new Intent(REMOTESERVICE);
        } else {
            intent = new Intent(remoteservice);
        }
        context.bindService(getExplicitIntent(context, intent), aidlConnection, Context.BIND_AUTO_CREATE);

    }

    public void unBind(Context context) {
        try {
            if (aidlConnection != null && aidlConnection.isConnection())
                context.unbindService(aidlConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Intent getExplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }
        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);
        // Set the component to be explicit
        explicitIntent.setComponent(component);
        return explicitIntent;
    }


    public interface AidlConnectionCallback {
        void onServiceDisconnected(ComponentName name);

        void onServiceConnected(ComponentName name);
    }

    public boolean isConnection() {
        return aidlConnection != null && aidlConnection.isConnection();
    }

    private static class AidlConnection implements ServiceConnection {
        private IPPPlatformV8Service instance;
        private boolean isConnection = false;

        private AidlConnectionCallback callback;
        private Handler mHandler;

        public AidlConnection(AidlConnectionCallback callback) {
            this.callback = callback;
            mHandler = new Handler();
        }

        @Override

        public void onServiceDisconnected(final ComponentName name) {
            isConnection = false;
            if (callback != null) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onServiceConnected(name);
                    }
                });

            }
        }

        @Override
        public void onServiceConnected(final ComponentName name, IBinder service) {
            instance = IPPPlatformV8Service.Stub.asInterface(service);
            isConnection = true;
            if (callback != null) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) callback.onServiceConnected(name);
                    }
                });
            }
        }

        public IPPPlatformV8Service getInstance() {
            return instance;
        }

        public boolean isConnection() {
            return isConnection;
        }
    }

    public IPPPlatformV8Service getInstance() {
        return aidlConnection != null ? aidlConnection.getInstance() : null;
    }


}

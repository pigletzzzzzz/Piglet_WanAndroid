package com.xmobile.pppdemonew.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;

import com.google.gson.Gson;
import com.xmobile.pppdemonew.Host;
import com.xmobile.pppdemonew.data.bean.LocationModel;
import com.xmobile.ppplatformv8.IPPPlatformV8Service;
import com.xmobile.xlogger.XLogger;
import com.xmobile.xretrofit.gson.GsonUtils;

/**
 * Created by 黄卫华(wayhua@126.com) on 2019/11/14 0014.
 */
public class XAidl {

    /***
     * 在这里编写方法
     * @return
     * @throws RemoteException
     */
    public static String test() throws RemoteException {
        IPPPlatformV8Service service = aidlBinder.getInstance();
        if (service == null) {
            return "没有找到匹配的内容！请检测代码！";
        }
        return service.test();
    }

    public static boolean jump(String packagename) throws RemoteException {
        IPPPlatformV8Service service = aidlBinder.getInstance();
        if (service == null) {
            return false;
        }
        return service.jump(packagename);

    }

    /***
     *播放视频
     */
    public static boolean play(String uri, String title) throws RemoteException {

        IPPPlatformV8Service service = aidlBinder.getInstance();
        if (service == null) {
            return false;
        }
        return service.play(uri, title);

    }


    public static LocationModel getLocationData() throws RemoteException {
        IPPPlatformV8Service service = aidlBinder.getInstance();
        if (service == null) {
            return null;
        }
        String sjson = service.getLocationData();
        XLogger.e("aidl:" + sjson);
        LocationModel result = gson.fromJson(sjson, LocationModel.class);
        return result;
    }


    public static void bind(Context context) {

        if (!isChecked) {
            doBind(context);
        }


    }

    private static void doBind(Context context) {
        isChecked = true;
        if (aidlBinder == null)
            aidlBinder = new AidlBinder(new AidlBinder.AidlConnectionCallback() {
                @Override
                public void onServiceDisconnected(ComponentName name) {


                }

                @Override
                public void onServiceConnected(ComponentName name) {

                }

            });
        try {
            if (!aidlBinder.isConnection()) {


                aidlBinder.bind(context, Host.PackageName + ".BackService");
            }
        } catch (Exception e) {
            XLogger.e(e.getMessage());
        }

    }

    private static AidlBinder aidlBinder;
    private static boolean isChecked = false;
    private static Gson gson = GsonUtils.getGson();
}

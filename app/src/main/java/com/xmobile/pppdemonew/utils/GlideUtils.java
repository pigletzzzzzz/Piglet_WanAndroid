package com.xmobile.pppdemonew.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.xmobile.xframework.utils.NightModelUtils;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/24
 */
public class GlideUtils {
    /**
     * @param context   上下文
     * @param imageView 显示图片控件
     * @param url       图片路径
     * @param hdId      placeholder时显示的资源id
     */
    public static void glide(Context context, ImageView imageView, String url, int hdId) {

        RequestBuilder<Drawable> requestManager = Glide.with(context).load(url);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        if (NightModelUtils.getNightModeSwitch(context)) {

            requestOptions.optionalTransform(new GrayscaleTransformation());
            //  requestManager.apply(requestOptions);
        }

        if (hdId > 0) {
            requestManager.placeholder(hdId);
        }

        requestManager.apply(requestOptions).into(imageView);

    }
}

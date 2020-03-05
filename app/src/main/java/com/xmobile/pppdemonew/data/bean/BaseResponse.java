package com.xmobile.pppdemonew.data.bean;

import androidx.annotation.NonNull;

import com.xmobile.xframework.mvvm.data.Status;

public class BaseResponse<T> {
    /**
     * data : []
     * errorCode : 0
     * errorMsg :
     */

    //errorCode = 0代表执行成功，非0都为失败
    //errorCode = -1001 代表登录失效，需要重新登录。
    @NonNull
    public final int errorCode;
    @NonNull
    public final String errorMsg;
    @NonNull
    public final T data;

    public BaseResponse(@NonNull int errorCode,@NonNull String errorMsg,@NonNull T data) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @NonNull
    public String getErrorMsg() {
        return errorMsg;
    }

    @NonNull
    public T getData() {
        return data;
    }
}

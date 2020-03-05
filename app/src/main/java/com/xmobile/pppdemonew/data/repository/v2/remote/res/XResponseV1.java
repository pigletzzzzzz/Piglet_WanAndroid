package com.xmobile.pppdemonew.data.repository.v2.remote.res;

public class XResponseV1<T>  {
    private T data;
    private int errorCode;
    private String errorMsg;

    public XResponseV1() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

package com.xmobile.pppdemonew.data.repository.v2.remote.req;


import com.xmobile.xbiz.XDevice;

/**
 * Created by 黄卫华(wayhua@126.com) on 2016/2/24.
 */
public class LoginReqV2 {
    private String account;
    private String password;
    private String verCode;
    private String verCodeValue;

    private XDevice device;

    public XDevice getDevice() {
        return device;
    }

    public void setDevice(XDevice device) {
        this.device = device;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerCode() {
        return verCode;
    }

    public void setVerCode(String verCode) {
        this.verCode = verCode;
    }

    public String getVerCodeValue() {
        return verCodeValue;
    }

    public void setVerCodeValue(String verCodeValue) {
        this.verCodeValue = verCodeValue;
    }
}

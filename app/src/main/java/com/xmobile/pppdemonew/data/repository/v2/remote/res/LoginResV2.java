package com.xmobile.pppdemonew.data.repository.v2.remote.res;

/**
 * time :2019/9/17 16:53
 * version:1.0
 * 黄卫华(wayhua@126.com)
 */
public class LoginResV2 {
private String token;
    private String refreshToken;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

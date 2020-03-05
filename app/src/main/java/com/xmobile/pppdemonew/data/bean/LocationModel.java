package com.xmobile.pppdemonew.data.bean;


/**
 * Created by wei.
 * Date: 2019/10/18 15:46
 * Desc:
 */
public class LocationModel {

    //经度
    double longitude;
    //纬度
    double latitude;
    //地址
    String address;
    //wifi 是否打开
    private boolean isWifiAble;
    //gps 是否打开
    private boolean isGPSOpen;
    private String gpsStatus;
    private int statusCode;
    //网络类型
    private String networkType;


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isWifiAble() {
        return isWifiAble;
    }

    public void setWifiAble(boolean wifiAble) {
        isWifiAble = wifiAble;
    }

    public boolean isGPSOpen() {
        return isGPSOpen;
    }

    public void setGPSOpen(boolean GPSOpen) {
        isGPSOpen = GPSOpen;
    }

    public String getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(String gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }



    @Override
    public String toString() {
        return "LocationModel{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", address='" + address + '\'' +
                ", isWifiAble=" + isWifiAble +
                ", isGPSOpen=" + isGPSOpen +
                ", gpsStatus='" + gpsStatus + '\'' +
                ", statusCode=" + statusCode +
                ", networkType='" + networkType + '\'' +
                '}';
    }
}

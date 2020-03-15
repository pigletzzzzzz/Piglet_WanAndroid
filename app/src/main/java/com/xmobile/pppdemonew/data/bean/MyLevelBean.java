package com.xmobile.pppdemonew.data.bean;

import java.util.Date;

/**
 * Created By 刘纯贵
 * Created Time 2020/3/1
 */
public class MyLevelBean {
    /**
     * "coinCount": 12,
     *"date": 1583043566000,
     *"desc": "2020-03-01 14:19:26 签到 , 积分：10 + 2",
     *"id": 152229,
     *"reason": "签到",
     *"type": 1,
     *"userId": 46639,
     *"userName": "piglet"
     */

    private int coinCount;
    private Date date;
    private String desc;
    private int id;
    private String reason;
    private int type;
    private int userId;
    private String userName;

    public String getInstructions(){
        return desc.substring(0,desc.indexOf(","));
    }

    public String getLevel(){
        return desc.substring(desc.indexOf("积"));
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

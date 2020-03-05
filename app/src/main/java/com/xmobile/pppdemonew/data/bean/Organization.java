package com.xmobile.pppdemonew.data.bean;

import android.text.TextUtils;

import com.xmobile.xbiz.IOrg;

import java.io.Serializable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = Organization.TABLENAME)
public class Organization implements Serializable, IOrg, IIdentify {
    public  static final String TABLENAME="Organization";
    /**
     *
     */
    private static final long serialVersionUID = -3030302114290024376L;


    @PrimaryKey(autoGenerate = true)
    private int id;
    /**
     * 单位编码（按照升序排序）
     */
    private String dwbm;

    /**
     * 单位名称
     */
    private String dwmc;

    /**
     * 父单位编码
     */

    private String fdwbm;

    /**
     * 单位编码标识,不需要
     */
    // @Column(name="dwbmbc",length=50)
    // private String dwbmbc;

    /**
     * 单位级别
     */

    private String dwjb;

    /**
     * 单位简称
     */

    private String dwjc;

    /**
     * 单位标识:0普通;1铁检;2林检;3军检
     */
    private String dwbs;

    /**
     * 单位地址
     */

    private String dwdz;

    /**
     * 邮政编码
     */

    private String yzbm;
    /**
     * 电话区号
     */

    private String dhqh;

    /**
     * 值班电话
     */

    private String zbdh;

    /**
     * 举报电话
     */

    private String jbdh;
    /**
     * 传真号码
     */
    private String czhm;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;

    public String getDwbm() {
        return dwbm;
    }

    public void setDwbm(String dwbm) {
        this.dwbm = dwbm;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getFdwbm() {
        return fdwbm;
    }

    public void setFdwbm(String fdwbm) {
        this.fdwbm = fdwbm;
    }

    public String getDwjb() {
        return dwjb;
    }

    public void setDwjb(String dwjb) {
        this.dwjb = dwjb;
    }

    public String getDwjc() {
        return dwjc;
    }

    public void setDwjc(String dwjc) {
        this.dwjc = dwjc;
    }

    public String getDwbs() {
        return dwbs;
    }

    public void setDwbs(String dwbs) {
        this.dwbs = dwbs;
    }

    public String getDwdz() {
        return dwdz;
    }

    public void setDwdz(String dwdz) {
        this.dwdz = dwdz;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getDhqh() {
        return dhqh;
    }

    public void setDhqh(String dhqh) {
        this.dhqh = dhqh;
    }

    public String getZbdh() {
        return zbdh;
    }

    public void setZbdh(String zbdh) {
        this.zbdh = zbdh;
    }

    public String getJbdh() {
        return jbdh;
    }

    public void setJbdh(String jbdh) {
        this.jbdh = jbdh;
    }

    public String getCzhm() {
        return czhm;
    }

    public void setCzhm(String czhm) {
        this.czhm = czhm;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    @Override
    public String getCaption() {
       if(dwjc.contains("省院")){
           return dwmc;
       }
        return TextUtils.isEmpty(dwjc) ? dwmc : dwjc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

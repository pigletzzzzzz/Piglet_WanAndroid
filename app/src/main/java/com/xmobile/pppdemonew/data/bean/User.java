package com.xmobile.pppdemonew.data.bean;

import com.xmobile.xbiz.IUser;

import java.io.Serializable;
import java.util.Date;

public class User implements IUser, Serializable  {
    /**
     *
     */
    private static final long serialVersionUID = -5200874343201063185L;
    /**
     * 帐号
     */
    private String account;
    /**
     * 口令
     */

    private String kl;

    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 性别
     */
    private String sex;
    private String bgsh;

    /**
     * 出生年月日
     */
    private Date csnyr;
    /**
     * 籍贯
     */
    private String jg;

    /**
     * 民族
     */
    private String mz;

    /**
     * 电子邮件
     */
    private String email;
    //头像
    private int headimage;

    public int getHeadimage() {
        return headimage;
    }

    public void setHeadimage(int headimage) {
        this.headimage = headimage;
    }

    public String getKl() {
        return kl;
    }

    public void setKl(String kl) {
        this.kl = kl;
    }

    public String getBgsh() {
        return bgsh;
    }

    public void setBgsh(String bgsh) {
        this.bgsh = bgsh;
    }

    /**
     * 办公电话号码
     */
    private String bgdhhm;
    /**
     * 家庭电话号码
     */
    private String jtdhhm;


    /**
     * 家庭地址
     */
    private String jtdz;
    /**
     * 职务
     */
    private String zw;
    /**
     * 职称
     */
    private String zc;
    /**
     * 职级
     */
    private String zj;

    /**
     * 部门编码
     */
    private String bmbm;

    /**
     * 单位编码
     */
    private String dwbm;


    /**
     * 部门名称
     */
    private String bmmc;
    /**
     * 单位名称
     */
    private String dwmc;

    private boolean isSc;


    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }


    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    // 简单拼音名称
    private String simplePYName = "";

    public String getSimplePYName() {
        return simplePYName;
    }

    public void setSimplePYName(String simplePYName) {
        this.simplePYName = simplePYName;
    }


    public void setRealname(String realname) {
        this.realname = realname;

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCsnyr() {
        return csnyr;
    }

    public void setCsnyr(Date csnyr) {
        this.csnyr = csnyr;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBgdhhm() {
        return bgdhhm;
    }

    public void setBgdhhm(String bgdhhm) {
        this.bgdhhm = bgdhhm;
    }

    public String getJtdhhm() {
        return jtdhhm;
    }

    public void setJtdhhm(String jtdhhm) {
        this.jtdhhm = jtdhhm;
    }

    public String getJtdz() {
        return jtdz;
    }

    public void setJtdz(String jtdz) {
        this.jtdz = jtdz;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getZj() {
        return zj;
    }

    public void setZj(String zj) {
        this.zj = zj;
    }


    public String getBmbm() {
        return bmbm;
    }

    public void setBmbm(String bmbm) {
        this.bmbm = bmbm;
    }


    public String getDwbm() {
        return dwbm;
    }

    public void setDwbm(String dwbm) {
        this.dwbm = dwbm;
    }


    public String getRealname() {
        return realname;
    }

    public boolean isSc() {
        return isSc;
    }

    public void setSc(boolean isSc) {
        this.isSc = isSc;
    }



    public String getId() {
        return account;
    }


    private Object tag;


    public Object getTag() {
        return tag;
    }


    public void setTag(Object tag) {
        this.tag = tag;
    }

    //这个用来显示在PickerView上面的字符串,PickerView会通过反射获取getPickerViewText方法显示出来。
    public String getPickerViewText() {
        //这里还可以判断文字超长截断再提供显示
        return realname;
    }
}

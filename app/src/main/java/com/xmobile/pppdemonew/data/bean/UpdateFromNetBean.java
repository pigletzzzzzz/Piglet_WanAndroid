package com.xmobile.pppdemonew.data.bean;


import java.util.Date;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by  黄卫华(wayhua@126.com) on 2017/5/24.
 */
@Entity(tableName = UpdateFromNetBean.TABLENAME)
public class UpdateFromNetBean {

    public  static final String TABLENAME="updateFromNetBean";

    transient//GSon用的
    private static final long serialVersionUID = -7451135403984383045L;

    @PrimaryKey(autoGenerate = true)
    private int id;



    private int tag;
    private int tag2;
    private int tags1;
    private int tags2;
    //表名
    private String tablename;
    private Date lastUpdateTime;


    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getTag2() {
        return tag2;
    }

    public void setTag2(int tag2) {
        this.tag2 = tag2;
    }

    public int getTags1() {
        return tags1;
    }

    public void setTags1(int tags1) {
        this.tags1 = tags1;
    }

    public int getTags2() {
        return tags2;
    }

    public void setTags2(int tags2) {
        this.tags2 = tags2;
    }
}

package com.xmobile.pppdemonew.data.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * 地市类别
 */

@Entity(tableName = OrgType.TABLENAME)
public class OrgType implements Serializable, IIdentify {
    public static final String TABLENAME = "OrgType";
    /**
     *
     */
    private static final long serialVersionUID = -8948301778084585043L;
    private String dsbm;
    private String dsmc;
    private String dsjc;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public OrgType() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDsjc() {
        return dsjc;
    }

    public void setDsjc(String dsjc) {
        this.dsjc = dsjc;
    }

    public String getDsbm() {
        return dsbm;
    }

    public void setDsbm(String dsbm) {
        this.dsbm = dsbm;
    }

    public String getDsmc() {
        return dsmc;
    }

    public void setDsmc(String dsmc) {
        this.dsmc = dsmc;
    }

    @Ignore
    @Expose()
    private List<Organization> organizations = new ArrayList<>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getCaption() {
        return dsjc;
    }




}

package com.xmobile.pppdemonew.data.bean;

import java.util.List;

/**
 * Created By 刘纯贵
 * Created Time 2020/2/23
 */
public class NavigationBean {

    /**
     * articles : [{..}]
     * cid : 272
     * name : 常用网站
     */

    private int cid;
    private String name;
    private List<Article> articles;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

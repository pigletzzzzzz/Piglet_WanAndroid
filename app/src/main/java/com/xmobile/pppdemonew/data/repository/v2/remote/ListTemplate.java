package com.xmobile.pppdemonew.data.repository.v2.remote;

import java.util.List;

/**
 * 时间 : 2019/9/24 11:11
 * 版本 : 1.0
 * 黄卫华(wayhua@126.com)
 */
public class ListTemplate<T> {
    private int total;
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

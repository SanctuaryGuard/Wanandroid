package com.example.asus.wanandroid.network.bean.home.article;

import com.example.asus.wanandroid.base.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class HomeArticleData extends BaseBean {
    private int curPage;
    private List<HomeArticleListBean> datas = new ArrayList<HomeArticleListBean>();
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<HomeArticleListBean> getDatas() {
        return datas;
    }

    public void setDatas(List<HomeArticleListBean> datas) {
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

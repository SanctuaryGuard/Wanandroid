package com.example.asus.wanandroid.network.bean.project.article;

import com.example.asus.wanandroid.base.BaseBean;

import java.util.ArrayList;
import java.util.List;

public class ProjectArticleData extends BaseBean {
    private int curPage;
    private List<ProjectArticleListBean> datas = new ArrayList<ProjectArticleListBean>();
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

    public List<ProjectArticleListBean> getDatas() {
        return datas;
    }

    public void setDatas(List<ProjectArticleListBean> datas) {
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

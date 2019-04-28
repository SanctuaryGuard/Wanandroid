package com.example.asus.wanandroid.network.bean.architecture.article;

import com.example.asus.wanandroid.base.BaseBean;

public class ArchitectureArticle extends BaseBean {
    private ArchitectureArticleData data;
    private int errorCode;
    private String errorMsg;

    public ArchitectureArticleData getData() {
        return data;
    }

    public void setData(ArchitectureArticleData data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

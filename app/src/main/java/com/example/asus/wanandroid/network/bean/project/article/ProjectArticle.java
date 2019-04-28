package com.example.asus.wanandroid.network.bean.project.article;

import com.example.asus.wanandroid.base.BaseBean;

import java.util.List;

public class ProjectArticle extends BaseBean {
    private ProjectArticleData data;
    private int errorCode;
    private String errorMsg;

    public ProjectArticleData getData() {
        return data;
    }

    public void setData(ProjectArticleData data) {
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

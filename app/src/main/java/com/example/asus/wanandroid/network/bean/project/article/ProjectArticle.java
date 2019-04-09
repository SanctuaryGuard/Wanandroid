package com.example.asus.wanandroid.network.bean.project.article;

import java.util.List;

public class ProjectArticle {
    private List<ProjectArticleData> data;
    private int errorCode;
    private String errorMsg;

    public List<ProjectArticleData> getData() {
        return data;
    }

    public void setData(List<ProjectArticleData> data) {
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

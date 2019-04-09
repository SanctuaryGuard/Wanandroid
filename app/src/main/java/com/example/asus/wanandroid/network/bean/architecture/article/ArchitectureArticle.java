package com.example.asus.wanandroid.network.bean.architecture.article;

public class ArchitectureArticle {
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

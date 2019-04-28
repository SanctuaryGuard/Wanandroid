package com.example.asus.wanandroid.network.bean.home.article;

import com.example.asus.wanandroid.base.BaseBean;

public class HomeArticle extends BaseBean {
    private HomeArticleData data;
    private int errorCode;
    private String  errorMsg;

    public HomeArticleData getData() {
        return data;
    }

    public void setData(HomeArticleData data) {
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

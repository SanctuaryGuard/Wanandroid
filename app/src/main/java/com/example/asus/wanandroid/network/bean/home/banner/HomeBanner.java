package com.example.asus.wanandroid.network.bean.home.banner;

import java.util.ArrayList;
import java.util.List;

public class HomeBanner {

    private List<HomeBannerData> data = new ArrayList<HomeBannerData>();
    private int errorCode;
    private String errorMsg;

    public List<HomeBannerData> getData() {
        return data;
    }

    public void setData(List<HomeBannerData> data) {
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

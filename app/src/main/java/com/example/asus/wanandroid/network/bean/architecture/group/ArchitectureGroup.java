package com.example.asus.wanandroid.network.bean.architecture.group;

import com.example.asus.wanandroid.base.BaseBean;

import java.util.List;

public class ArchitectureGroup extends BaseBean {
    private List<ArchitectureGroupData> data;
    private int errorCode;
    private String errorMsg;

    public List<ArchitectureGroupData> getData() {
        return data;
    }

    public void setData(List<ArchitectureGroupData> data) {
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

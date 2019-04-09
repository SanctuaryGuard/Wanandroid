package com.example.asus.wanandroid.network.bean.project.group;

import java.util.List;

public class ProjectGroup {
    private List<ProjectGroupData> data;
    private int errorCode;
    private String errorMsg;

    public List<ProjectGroupData> getData() {
        return data;
    }

    public void setData(List<ProjectGroupData> data) {
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

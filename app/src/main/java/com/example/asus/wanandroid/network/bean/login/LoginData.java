package com.example.asus.wanandroid.network.bean.login;

import com.example.asus.wanandroid.base.BaseBean;

public class LoginData extends BaseBean {
    private LoginDataBean data;
    private int errorCode;
    private String errorMsg;

    public LoginDataBean getData() {
        return data;
    }

    public void setData(LoginDataBean data) {
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

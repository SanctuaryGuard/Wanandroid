package com.example.asus.wanandroid.ui.fragment.loginandregister.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.login.LoginData;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;
import com.example.asus.wanandroid.ui.fragment.loginandregister.model.LoginAndRegisterModel;

import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;

public class LoginAndRegisterPresenter extends BasePresenter<HomeContract.SimpleView> {
    private LoginAndRegisterModel mLoginAndRegisterModel;

    public LoginAndRegisterPresenter() {
        mLoginAndRegisterModel = new LoginAndRegisterModel();
    }

    public void getLoginData(String username, String password, OkHttpClient client) {
        mLoginAndRegisterModel.getLoginData(new Observer<LoginData>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(LoginData loginData) {
                view.onSuccess(loginData);
            }

            @Override
            public void onFail(Throwable e) {
                view.onFail(e);
            }

            @Override
            public void onCompleted() {
                view.onCompleted();
            }
        }, username, password, client);
    }

    public void getRegisterData(String username, String password, String repasswrod, OkHttpClient client) {
        mLoginAndRegisterModel.getRegisterData(new Observer<LoginData>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(LoginData loginData) {
                view.onSuccess(loginData);
            }

            @Override
            public void onFail(Throwable e) {
                view.onFail(e);
            }

            @Override
            public void onCompleted() {
                view.onCompleted();
            }
        }, username, password, repasswrod, client);
    }
}

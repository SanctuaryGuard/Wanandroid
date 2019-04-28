package com.example.asus.wanandroid.ui.fragment.loginandregister.model;

import com.example.asus.wanandroid.network.HttpServer;
import com.example.asus.wanandroid.network.bean.login.LoginData;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

public class LoginAndRegisterModel {
    public void getLoginData(Observer<LoginData> observer, String username, String password, OkHttpClient client) {
        HttpServer httpServer = HttpServer.getInstance();
//        httpServer.setClient(client);
        Observable<LoginData> observable = httpServer.getLoginData(username, password);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getRegisterData(Observer<LoginData> observer, String username, String passwrod, String repassword, OkHttpClient client) {
        HttpServer httpServer = HttpServer.getInstance();
//        httpServer.setClient(client);
        Observable<LoginData> observable = HttpServer.getInstance().getRegisterData(username, passwrod, repassword);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

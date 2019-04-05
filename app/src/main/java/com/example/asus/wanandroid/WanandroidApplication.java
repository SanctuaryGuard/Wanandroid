package com.example.asus.wanandroid;

import android.app.Application;

public class WanandroidApplication extends Application {
    private static WanandroidApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static WanandroidApplication getApplication() {
        return sApplication;
    }
}

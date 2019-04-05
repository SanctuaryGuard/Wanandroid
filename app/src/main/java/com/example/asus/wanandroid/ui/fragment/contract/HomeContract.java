package com.example.asus.wanandroid.ui.fragment.contract;

public interface HomeContract {
    interface SimpleView {
        void onSuccess(Object object);

        void onFail(Throwable e);

        void onCompleted();
    }
}

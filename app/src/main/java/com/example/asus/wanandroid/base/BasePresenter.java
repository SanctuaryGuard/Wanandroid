package com.example.asus.wanandroid.base;

public class BasePresenter<V> {
    public V view;

    public void addView(V v) {
        view = v;
    }

    public void  detattch() {
        if (view != null) {
            view = null;
        }
    }
}

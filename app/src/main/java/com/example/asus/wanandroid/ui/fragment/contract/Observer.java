package com.example.asus.wanandroid.ui.fragment.contract;

import io.reactivex.disposables.Disposable;

public abstract class Observer<T> implements io.reactivex.Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        onDisposable(d);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    @Override
    public void onComplete() {
        onCompleted();
    }

    public abstract void onDisposable(Disposable d);

    public abstract void onSuccess(T t);

    public abstract void onFail(Throwable e);

    public abstract void onCompleted();
}

package com.example.asus.wanandroid.ui.fragment.architecture.model;

import com.example.asus.wanandroid.network.HttpServer;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ArchitectureModel {
    public void getArchitectureGroupData(Observer<ArchitectureGroup> architectureGroupObserver) {
        Observable<ArchitectureGroup> architectureGroupObservable = HttpServer.getInstance().getArchitectureGroupData();
        architectureGroupObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(architectureGroupObserver);
    }

    public void getArchitectureArticleData(Observer<ArchitectureArticle> architectureArticleObserver, int pageNum, int cid) {
        Observable<ArchitectureArticle> architectureArticleObservable = HttpServer.getInstance().getArchitectureArticleData(pageNum, cid);
        architectureArticleObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(architectureArticleObserver);
    }
}

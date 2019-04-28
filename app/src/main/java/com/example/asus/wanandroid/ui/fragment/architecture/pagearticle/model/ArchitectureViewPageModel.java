package com.example.asus.wanandroid.ui.fragment.architecture.pagearticle.model;

import com.example.asus.wanandroid.network.HttpServer;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ArchitectureViewPageModel {
    public void getArchitectureArticleData(Observer<ArchitectureArticle> observer, int pageNum, int cid) {
        Observable<ArchitectureArticle> observable = HttpServer.getInstance().getArchitectureArticleData(pageNum, cid);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

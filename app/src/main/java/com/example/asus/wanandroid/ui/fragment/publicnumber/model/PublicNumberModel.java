package com.example.asus.wanandroid.ui.fragment.publicnumber.model;

import com.example.asus.wanandroid.network.HttpServer;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PublicNumberModel {
    public void getWxarticleGroupData(Observer<ArchitectureGroup> observer) {
        Observable<ArchitectureGroup> observable = HttpServer.getInstance().getWxarticleGroupData();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getWxarticleArticleData(Observer<HomeArticle> observer, int page, int cid) {
        Observable<HomeArticle> observable = HttpServer.getInstance().getWxarticleArticleData(page, cid);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

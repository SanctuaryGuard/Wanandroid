package com.example.asus.wanandroid.ui.fragment.home.model;

import com.example.asus.wanandroid.network.HttpServer;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleTop;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeModel {
    public void getBannerData(Observer<HomeBanner> observer) {
        Observable<HomeBanner> homeBannerObservable = HttpServer.getInstance().getHomeBannerData();
        homeBannerObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getArticleData(Observer<HomeArticle> observer, int pageNum) {
        Observable<HomeArticle> homeArticleobserver = HttpServer.getInstance().getHomeArticleData(pageNum);
        homeArticleobserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getArticleTopData(Observer<HomeArticleTop> observer) {
        Observable<HomeArticleTop> homeArticleTopObservable = HttpServer.getInstance().getHomeArticleTopData();
        homeArticleTopObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

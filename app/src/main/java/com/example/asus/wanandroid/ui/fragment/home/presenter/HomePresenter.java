package com.example.asus.wanandroid.ui.fragment.home.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;
import com.example.asus.wanandroid.ui.fragment.home.model.HomeModel;

import io.reactivex.disposables.Disposable;

public class HomePresenter extends BasePresenter<HomeContract.SimpleView> {
    private HomeModel mModel;

    public HomePresenter() {
        mModel = new HomeModel();
    }

    public void getBannerData() {
        mModel.getBannerData(new Observer<HomeBanner>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(HomeBanner homeBanner) {
                view.onSuccess(homeBanner);
            }

            @Override
            public void onFail(Throwable e) {
                view.onFail(e);
            }

            @Override
            public void onCompleted() {
                view.onCompleted();
            }
        });
    }

    public void getArticleData(int page) {
        mModel.getArticleData(new Observer<HomeArticle>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(HomeArticle homeArticle) {
                view.onSuccess(homeArticle);
            }

            @Override
            public void onFail(Throwable e) {
                view.onFail(e);
            }

            @Override
            public void onCompleted() {
                view.onCompleted();
            }
        }, page);
    }
}

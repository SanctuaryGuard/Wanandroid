package com.example.asus.wanandroid.ui.fragment.publicnumber.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;
import com.example.asus.wanandroid.ui.fragment.publicnumber.model.PublicNumberModel;

import io.reactivex.disposables.Disposable;

public class PublicNumberPresenter extends BasePresenter<HomeContract.SimpleView> {
    private PublicNumberModel mPublicNumberModel;

    public PublicNumberPresenter() {
        mPublicNumberModel = new PublicNumberModel();
    }

    public void getWxarticleGroupData() {
        mPublicNumberModel.getWxarticleGroupData(new Observer<ArchitectureGroup>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(ArchitectureGroup architectureGroup) {
                view.onSuccess(architectureGroup);
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

    public void getWxarticleArticleData(int page, int cid) {
        mPublicNumberModel.getWxarticleArticleData(new Observer<HomeArticle>() {
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
        }, page, cid);
    }
}

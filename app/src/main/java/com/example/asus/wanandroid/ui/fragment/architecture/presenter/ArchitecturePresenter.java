package com.example.asus.wanandroid.ui.fragment.architecture.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.ui.fragment.architecture.model.ArchitectureModel;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.disposables.Disposable;

public class ArchitecturePresenter extends BasePresenter<HomeContract.SimpleView> {

    private ArchitectureModel mArchitectureModel;

    public ArchitecturePresenter() {
        mArchitectureModel = new ArchitectureModel();
    }

    public void getArchitectureGroupData() {
        mArchitectureModel.getArchitectureGroupData(new Observer<ArchitectureGroup>() {
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

    public void getArchitectureArticleData(int pageNum, int cid) {
        mArchitectureModel.getArchitectureArticleData(new Observer<ArchitectureArticle>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(ArchitectureArticle architectureArticle) {
                view.onSuccess(architectureArticle);
            }

            @Override
            public void onFail(Throwable e) {
                view.onFail(e);
            }

            @Override
            public void onCompleted() {
                view.onCompleted();
            }
        }, pageNum, cid);
    }
}

package com.example.asus.wanandroid.ui.fragment.architecture.pagearticle.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.ui.fragment.architecture.pagearticle.model.ArchitectureViewPageModel;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.disposables.Disposable;

public class ArchitectureViewPagePresenter extends BasePresenter<HomeContract.SimpleView> {

    private ArchitectureViewPageModel mArchitectureViewPageModel;

    public ArchitectureViewPagePresenter() {
        mArchitectureViewPageModel = new ArchitectureViewPageModel();
    }

    public void getArchitectureViewArticleData(int pageNum, int cid) {
        mArchitectureViewPageModel.getArchitectureArticleData(new Observer<ArchitectureArticle>() {
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

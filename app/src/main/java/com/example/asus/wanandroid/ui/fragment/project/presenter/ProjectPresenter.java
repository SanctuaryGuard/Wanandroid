package com.example.asus.wanandroid.ui.fragment.project.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticle;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;
import com.example.asus.wanandroid.ui.fragment.project.model.ProjectModel;

import io.reactivex.disposables.Disposable;

public class ProjectPresenter extends BasePresenter<HomeContract.SimpleView> {
    private ProjectModel mProjectModel;

    public ProjectPresenter() { mProjectModel = new ProjectModel(); }

    public void getProjectGroupData() {
        mProjectModel.getProjectGroupData(new Observer<ProjectGroup>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(ProjectGroup projectGroup) {
                view.onSuccess(projectGroup);
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

    public void getProjectArticleData(int page, int cid) {
        mProjectModel.getProjectArticleData(new Observer<ProjectArticle>() {
            @Override
            public void onDisposable(Disposable d) {

            }

            @Override
            public void onSuccess(ProjectArticle projectArticle) {
                view.onSuccess(projectArticle);
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

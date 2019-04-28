package com.example.asus.wanandroid.ui.fragment.project.model;

import com.example.asus.wanandroid.network.HttpServer;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticle;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;
import com.example.asus.wanandroid.ui.fragment.contract.Observer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProjectModel {
    public void getProjectGroupData(Observer<ProjectGroup> observer) {
        Observable<ProjectGroup> observable = HttpServer.getInstance().getProjectGroupData();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getProjectArticleData(Observer<ProjectArticle> observer, int page, int cid) {
        Observable<ProjectArticle> observable = HttpServer.getInstance().getProjectArticleData(page, cid);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}

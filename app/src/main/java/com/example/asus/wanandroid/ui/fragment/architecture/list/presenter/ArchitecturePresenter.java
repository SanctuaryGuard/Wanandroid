package com.example.asus.wanandroid.ui.fragment.architecture.list.presenter;

import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.ui.fragment.architecture.list.model.ArchitectureModel;
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

}

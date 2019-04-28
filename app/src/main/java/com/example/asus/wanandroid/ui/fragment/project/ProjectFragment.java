package com.example.asus.wanandroid.ui.fragment.project;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.FragmentAdapter;
import com.example.asus.wanandroid.adapter.ProjectFragmentAdapter;
import com.example.asus.wanandroid.base.BaseFragment;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroupData;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.project.presenter.ProjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProjectFragment extends MVPFragment<ProjectPresenter> implements HomeContract.SimpleView {

    private List<ProjectGroupData> mProjectGroupData;
    private List<Fragment> mFragments;
    private List<String> mTitles;

    private ProjectFragmentAdapter mProjectFragmentAdapter;


    @BindView(R.id.project_tab_layout)
    TabLayout mProjectTabLayout;
    @BindView(R.id.project_view_pager)
    ViewPager mProjectViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void init() {
        mProjectGroupData = new ArrayList<>();
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();

        mProjectFragmentAdapter = new ProjectFragmentAdapter(getActivity().getSupportFragmentManager(), mFragments, mTitles, mProjectGroupData);

        mProjectViewPager.setAdapter(mProjectFragmentAdapter);
        mProjectViewPager.setCurrentItem(0);
        mProjectViewPager.setOffscreenPageLimit(1);
        mProjectTabLayout.setupWithViewPager(mProjectViewPager);

        presenter.getProjectGroupData();

    }

    @Override
    protected ProjectPresenter initPresenter() {
        return new ProjectPresenter();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof ProjectGroup) {
            ProjectGroup projectGroup = (ProjectGroup) object;
            mProjectGroupData = projectGroup.getData();
            for (ProjectGroupData data : mProjectGroupData) {
                mFragments.add(ProjectViewPagerFragment.actionStart(data.getId()));
                mTitles.add(data.getName());
            }
            mProjectFragmentAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}

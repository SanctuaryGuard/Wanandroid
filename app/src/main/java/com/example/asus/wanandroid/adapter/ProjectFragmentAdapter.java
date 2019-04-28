package com.example.asus.wanandroid.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroupData;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroupData;

import java.util.List;

public class ProjectFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public ProjectFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles, List<ProjectGroupData> projectGroupData) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}

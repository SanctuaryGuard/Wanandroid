package com.example.asus.wanandroid.ui.fragment.architecture.pagearticle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.FragmentAdapter;
import com.example.asus.wanandroid.base.BaseActivity;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroupData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArchitectureViewPageActivity extends BaseActivity {

    private ArchitectureGroupData mArchitectureGroupData;
    private FragmentAdapter mFragmentAdapter;

    @BindView(R.id.architecture_page_title_text)
    TextView mTextView;
    @BindView(R.id.architecture_page_tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.architecture_page_view_pager)
    ViewPager mViewPager;
    @BindView(R.id.architecture_page_toolbar)
    Toolbar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_architecture_page;
    }

    @Override
    public Fragment CreateFragment() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architecture_page);
        ButterKnife.bind(this, this);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (null != getIntent().getSerializableExtra("viewpage")) {
            mArchitectureGroupData = (ArchitectureGroupData) getIntent().getSerializableExtra("viewpage");
        }

        initViewPager();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    private void initViewPager() {
        mTextView.setText(mArchitectureGroupData.getName());
        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (ArchitectureGroupData data : mArchitectureGroupData.getChildren()) {
            mTabLayout.addTab(mTabLayout.newTab().setText(data.getName()));
            fragments.add(ArchitectureViewPageFragment.actionStart(data.getId()));
            titles.add(data.getName());
        }

        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);

        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public static void actionStart(Context context, ArchitectureGroupData architectureGroupData) {
        Intent intent = new Intent(context, ArchitectureViewPageActivity.class);
        intent.putExtra("viewpage", architectureGroupData);
        context.startActivity(intent);
    }
}

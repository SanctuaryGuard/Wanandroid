package com.example.asus.wanandroid.ui.fragment.publicnumber;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.FragmentAdapter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroupData;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.project.ProjectViewPagerFragment;
import com.example.asus.wanandroid.ui.fragment.publicnumber.presenter.PublicNumberPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PublicNumberFragment extends MVPFragment<PublicNumberPresenter> implements HomeContract.SimpleView {

    private List<ArchitectureGroupData> mArchitectureGroupData;
    private List<Fragment> mFragments;
    private List<String> mTitles;

    private FragmentAdapter mFragmentAdapter;

    @BindView(R.id.public_number_tab_layout)
    TabLayout mPublicNumberTabLayout;
    @BindView(R.id.public_number_view_pager)
    ViewPager mPublicNumberViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_publicnumber;
    }

    @Override
    public void init() {
        mArchitectureGroupData = new ArrayList<>();
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();

        mFragmentAdapter = new FragmentAdapter(getActivity().getSupportFragmentManager(), mFragments, mTitles);

        mPublicNumberViewPager.setAdapter(mFragmentAdapter);
        mPublicNumberViewPager.setOffscreenPageLimit(1);
        mPublicNumberViewPager.setCurrentItem(0);
        mPublicNumberTabLayout.setupWithViewPager(mPublicNumberViewPager);

        presenter.getWxarticleGroupData();
    }

    @Override
    protected PublicNumberPresenter initPresenter() {
        return new PublicNumberPresenter();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof ArchitectureGroup) {
            ArchitectureGroup architectureGroup = (ArchitectureGroup) object;
            mArchitectureGroupData = architectureGroup.getData();

            for (ArchitectureGroupData data : mArchitectureGroupData) {
                mTitles.add(data.getName());
                mFragments.add(PublicNumberViewPagerFragment.actionStart(data.getId()));
            }

            mFragmentAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}

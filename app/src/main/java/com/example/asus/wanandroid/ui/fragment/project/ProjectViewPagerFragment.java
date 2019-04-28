package com.example.asus.wanandroid.ui.fragment.project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.ProjectArticleAdapter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticle;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticleData;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticleListBean;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.project.presenter.ProjectPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProjectViewPagerFragment extends MVPFragment<ProjectPresenter> implements HomeContract.SimpleView {
    private int cid = 0;
    private int mTotalPage = 0;
    private int mCurrentPage = 0;

    private List<ProjectArticleListBean> mProjectArticleListBeans;

    private ProjectArticleAdapter mProjectArticleAdapter;


    @BindView(R.id.project_view_page_recycler_view)
    RecyclerView mProjectRecyclerView;
    @BindView(R.id.project_view_page_smart_refresh_layout)
    SmartRefreshLayout mPojectSmartRefreshLayout;

    private void refreshAndLoadMore() {
        mPojectSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mCurrentPage + 1 < mTotalPage) {
                    presenter.getProjectArticleData(mCurrentPage + 1, cid);
                    refreshLayout.finishLoadMore(3000);
                    mProjectArticleAdapter.notifyDataSetChanged();
                } else if (mCurrentPage + 1 == mTotalPage) {
                    presenter.getProjectArticleData(mCurrentPage + 1, cid);
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    mProjectArticleAdapter.notifyDataSetChanged();
                } else {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project_view_page;
    }

    @Override
    public void init() {
        cid = getArguments().getInt("cid", 0);

        if (0 == cid) {
            return;
        }

        mProjectArticleListBeans = new ArrayList<>();

        mProjectArticleAdapter = new ProjectArticleAdapter(mProjectArticleListBeans, getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mProjectRecyclerView.setLayoutManager(layoutManager);
        mProjectRecyclerView.setAdapter(mProjectArticleAdapter);

        presenter.getProjectArticleData(1, cid);

        mPojectSmartRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);

        refreshAndLoadMore();
    }

    public static ProjectViewPagerFragment actionStart(int cid) {
        Bundle args = new Bundle();
        args.putInt("cid", cid);

        ProjectViewPagerFragment fragment = new ProjectViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected ProjectPresenter initPresenter() {
        return new ProjectPresenter();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof ProjectArticle) {
            ProjectArticle projectArticle = (ProjectArticle) object;
            ProjectArticleData projectArticleData = projectArticle.getData();
            mProjectArticleListBeans = projectArticleData.getDatas();

            mTotalPage = projectArticleData.getPageCount();
            mCurrentPage = projectArticleData.getCurPage();

            mProjectArticleAdapter.addProjectArticleData(mProjectArticleListBeans);
            mProjectArticleAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}

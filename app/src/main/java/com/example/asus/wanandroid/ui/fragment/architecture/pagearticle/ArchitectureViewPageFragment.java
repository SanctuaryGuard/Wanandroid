package com.example.asus.wanandroid.ui.fragment.architecture.pagearticle;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.ArchitectureArticleAdapter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticleData;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticleListBean;
import com.example.asus.wanandroid.ui.fragment.architecture.pagearticle.presenter.ArchitectureViewPagePresenter;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ArchitectureViewPageFragment extends MVPFragment<ArchitectureViewPagePresenter> implements HomeContract.SimpleView {

    private int cid = 0;
    private int mTotalPage = 0;
    private int mCurrentPage = 0;

    private List<ArchitectureArticleListBean> mArchitectureArticleListBeans;
    private ArchitectureArticleAdapter mArchitectureArticleAdapter;

    @BindView(R.id.architecture_page_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.architecture_page_smart_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;

    public static ArchitectureViewPageFragment actionStart(int cid) {
        Bundle args = new Bundle();
        args.putInt("cid", cid);

        ArchitectureViewPageFragment fragment = new ArchitectureViewPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void refreshAndLoadMore() {
        mSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mCurrentPage + 1 < mTotalPage) {
                    presenter.getArchitectureViewArticleData(mCurrentPage, cid);
                    refreshLayout.finishLoadMore(3000);
                    mArchitectureArticleAdapter.notifyDataSetChanged();
                } else if (mCurrentPage + 1 == mTotalPage) {
                    presenter.getArchitectureViewArticleData(mCurrentPage, cid);
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    mArchitectureArticleAdapter.notifyDataSetChanged();
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
    protected ArchitectureViewPagePresenter initPresenter() {
        return new ArchitectureViewPagePresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_architecture_view_page;
    }

    @Override
    public void init() {
        cid = getArguments().getInt("cid", 0);
        if (cid == 0) {
            return;
        }

        mArchitectureArticleListBeans = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mArchitectureArticleAdapter = new ArchitectureArticleAdapter(mArchitectureArticleListBeans, getContext());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mArchitectureArticleAdapter);

        presenter.getArchitectureViewArticleData(0, cid);

        mSmartRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);

        refreshAndLoadMore();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof ArchitectureArticle) {
            ArchitectureArticle architectureArticle = (ArchitectureArticle) object;
            ArchitectureArticleData architectureArticleData = architectureArticle.getData();

            mTotalPage = architectureArticleData.getPageCount();
            mCurrentPage = architectureArticleData.getCurPage();

            mArchitectureArticleAdapter.addArchitectureArticleListBean(architectureArticleData.getDatas());
            mArchitectureArticleAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}

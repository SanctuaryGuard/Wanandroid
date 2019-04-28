package com.example.asus.wanandroid.ui.fragment.publicnumber;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.adapter.PublicNumberArticleAdapter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleData;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleListBean;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.publicnumber.presenter.PublicNumberPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PublicNumberViewPagerFragment extends MVPFragment<PublicNumberPresenter> implements HomeContract.SimpleView {
    private int cid = 0;
    private int mTotalPage = 0;
    private int mCurrentPage = 0;

    private List<HomeArticleListBean> mHomeArticleListBeans;

    private PublicNumberArticleAdapter mPublicNumberArticleAdapter;

    @BindView(R.id.public_number_view_page_recycler_view)
    RecyclerView mPublicNumberRecyclerView;
    @BindView(R.id.public_number_view_page_smart_refresh_layout)
    SmartRefreshLayout mPublicNumberSmartRefreshLayout;

    private void refreshAndLoadMore() {
        mPublicNumberSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mCurrentPage + 1 < mTotalPage) {
                    presenter.getWxarticleArticleData(mCurrentPage + 1, cid);
                    refreshLayout.finishLoadMore(3000);
                    mPublicNumberArticleAdapter.notifyDataSetChanged();
                } else if (mCurrentPage + 1 == mTotalPage) {
                    presenter.getWxarticleArticleData(mCurrentPage + 1, cid);
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    mPublicNumberArticleAdapter.notifyDataSetChanged();
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

    public static PublicNumberViewPagerFragment actionStart(int cid) {
        Bundle args = new Bundle();
        args.putInt("cid", cid);

        PublicNumberViewPagerFragment fragment = new PublicNumberViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected PublicNumberPresenter initPresenter() {
        return new PublicNumberPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_publicnumber_view_page;
    }

    @Override
    public void init() {
        cid = getArguments().getInt("cid", 0);

        if (0 == cid) {
            return;
        }

        mHomeArticleListBeans = new ArrayList<>();

        mPublicNumberArticleAdapter = new PublicNumberArticleAdapter(mHomeArticleListBeans, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mPublicNumberRecyclerView.setLayoutManager(layoutManager);
        mPublicNumberRecyclerView.setAdapter(mPublicNumberArticleAdapter);

        presenter.getWxarticleArticleData(1, cid);

        mPublicNumberSmartRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);

        refreshAndLoadMore();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof HomeArticle) {
            HomeArticle homeArticle = (HomeArticle) object;
            HomeArticleData homeArticleData = homeArticle.getData();
            mHomeArticleListBeans = homeArticleData.getDatas();

            mCurrentPage = homeArticleData.getCurPage();
            mTotalPage = homeArticleData.getPageCount();

            mPublicNumberArticleAdapter.addHomeArticleListBean(mHomeArticleListBeans);
            mPublicNumberArticleAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }
}

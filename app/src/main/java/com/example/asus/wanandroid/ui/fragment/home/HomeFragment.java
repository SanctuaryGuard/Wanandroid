package com.example.asus.wanandroid.ui.fragment.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.WanandroidApplication;
import com.example.asus.wanandroid.adapter.ArticleAdapter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleListBean;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleData;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBannerData;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.home.presenter.HomePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;


public class HomeFragment extends MVPFragment<HomePresenter> implements HomeContract.SimpleView {

    private List<HomeArticleListBean> mArticleListBeans;
    private List<HomeBannerData> mHomeBannerDataList;

    private int mTotalPage = 0;
    private int mCurrentPage = 0;

    private ArticleAdapter mArticleAdapter;
    private Banner mHomeBanner;

    @BindView(R.id.home_recycler_view)
    RecyclerView mHomeRecyclerView;
    @BindView(R.id.home_smart_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;




    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof HomeBanner) {
            HomeBanner homeBanner = (HomeBanner) object;
            List<String> titles = new ArrayList<>();
            List<String> urls = new ArrayList<>();
            for(HomeBannerData data : homeBanner.getData()) {
                String str = data.getTitle();
                String str2 = data.getImagePath();
                titles.add(str);
                urls.add(str2);
            }

            mHomeBanner.update(urls, titles);
            mArticleAdapter.addHeaderView(mHomeBanner);
            mArticleAdapter.notifyDataSetChanged();


        } else if (object instanceof HomeArticle) {
            HomeArticle homeArticle = (HomeArticle) object;
            HomeArticleData homeArticleData = homeArticle.getData();
            mArticleAdapter.addArticleListBeans(homeArticleData.getDatas());
            mArticleAdapter.notifyDataSetChanged();
            mTotalPage = homeArticleData.getPageCount();
            mCurrentPage = homeArticleData.getCurPage();
        }
    }


    @Override
    public void onFail(Throwable e) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        mHomeBannerDataList = new ArrayList<>();
        mArticleListBeans = new ArrayList<>();

        List<String> titles = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        for(HomeBannerData data : mHomeBannerDataList) {
            String str = data.getTitle();
            String str2 = data.getImagePath();
            titles.add(str);
            urls.add(str2);
        }

        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.item_home_banner, null);
        mHomeBanner = relativeLayout.findViewById(R.id.home_banner);
        relativeLayout.removeView(mHomeBanner);
        mHomeBanner.setImageLoader(new HomeBannerLoader()).setImages(urls)
                .setBannerTitles(titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .start();

        mArticleAdapter = new ArticleAdapter(getContext(), mArticleListBeans);

        LinearLayoutManager layoutManager = new LinearLayoutManager(WanandroidApplication.getApplication());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mHomeRecyclerView.setLayoutManager(layoutManager);
        mHomeRecyclerView.setAdapter(mArticleAdapter);

        presenter.getBannerData();
        presenter.getArticleData(0);

        refreshAndLoadMore();
    }

    private void refreshAndLoadMore() {
        mSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mCurrentPage + 1 < mTotalPage) {
                    presenter.getArticleData(mCurrentPage + 1);
                    refreshLayout.finishLoadMore(3000);
                    mArticleAdapter.notifyDataSetChanged();
                } else if (mCurrentPage + 1 == mTotalPage) {
                    presenter.getArticleData(mCurrentPage + 1);
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    mArticleAdapter.notifyDataSetChanged();
                } else {
                    refreshLayout.finishLoadMore(2000, false, true);
                }
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
    }


}

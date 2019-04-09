package com.example.asus.wanandroid.network;

import com.example.asus.wanandroid.network.api.ApiServer;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleTop;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;


import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpServer {
    private static final String BASE_URL = "https://www.wanandroid.com/";
    private ApiServer mApiServer;
    private static volatile HttpServer sHttpServer;



    public static HttpServer getInstance() {
        if (sHttpServer == null) {
            synchronized (HttpServer.class) {
                sHttpServer = new HttpServer();
            }
        }

        return sHttpServer;
    }

    private HttpServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mApiServer = retrofit.create(ApiServer.class);
    }

    //获取首页Article数据
    public Observable<HomeArticle> getHomeArticleData(int pageNum) {
        return mApiServer.getHomeArticleData(pageNum);
    }

    //获取首页Banner数据
    public Observable<HomeBanner> getHomeBannerData() {
        return mApiServer.getBannerData();
    }

    //获取首页置顶Article数据
    public Observable<HomeArticleTop> getHomeArticleTopData() {
        return mApiServer.getHomeArticleTopData();
    }

    //获取知识体系分类
    public Observable<ArchitectureGroup> getArchitectureGroupData() {
        return mApiServer.getArchitectureGroupdata();
    }

    //获取知识体系下的文章
    public Observable<ArchitectureArticle> getArchitectureArticleData(int pageNum, int cid) {
        return mApiServer.getArchitectureArticleData(pageNum, cid);
    }
}

package com.example.asus.wanandroid.network.api;

import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleTop;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServer {
    //获取首页Banner
    @GET("banner/json")
    Observable<HomeBanner> getBannerData();

    //获取首页文章
    @GET("article/list/{pageNum}/json")
    Observable<HomeArticle> getHomeArticleData(@Path("pageNum") int pageNum);

    //获取首页置顶文章
    @GET("article/top/json")
    Observable<HomeArticleTop> getHomeArticleTopData();
}

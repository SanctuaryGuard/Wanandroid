package com.example.asus.wanandroid.network.api;

import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleTop;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticle;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    //获取知识体系分类
    @GET("tree/json")
    Observable<ArchitectureGroup> getArchitectureGroupdata();

    //获取知识体系下的文章
    @GET("article/list/{pageNum}/json")
    Observable<ArchitectureArticle> getArchitectureArticleData(@Path("pageNum") int pageNum, @Query("cid") int cid);

    //获取项目分类
    @GET("project/tree/json")
    Observable<ProjectGroup> getProjectGroupData();

    //获取项目下的文章
    @GET("project/list/{pageNum}/json")
    Observable<ProjectArticle> getProjectArticleData(@Path("pageNum") int pageNum, @Query("cid") int cid);
}

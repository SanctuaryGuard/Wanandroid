package com.example.asus.wanandroid.network.api;

import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleTop;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;
import com.example.asus.wanandroid.network.bean.login.LoginData;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticle;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    //获取微信公众号分类
    @GET("wxarticle/chapters/json")
    Observable<ArchitectureGroup> getWxarticleGroupData();

    //获取微信公众号下的文章
    @GET("wxarticle/list/{cid}/{pageNum}/json")
    Observable<HomeArticle> getWxarticleArticleData(@Path("pageNum") int pageNum, @Path("cid") int cid);



    //登录
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginData> getLoginData(@Field("username") String username, @Field("password") String password);

    //注册
    @POST("user/register")
    @FormUrlEncoded
    Observable<LoginData> getRegisterData(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);
}

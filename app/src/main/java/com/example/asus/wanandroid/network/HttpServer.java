package com.example.asus.wanandroid.network;

import com.example.asus.wanandroid.network.api.ApiServer;
import com.example.asus.wanandroid.network.bean.architecture.article.ArchitectureArticle;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroup;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticle;
import com.example.asus.wanandroid.network.bean.home.article.HomeArticleTop;
import com.example.asus.wanandroid.network.bean.home.banner.HomeBanner;
import com.example.asus.wanandroid.network.bean.login.LoginData;
import com.example.asus.wanandroid.network.bean.project.article.ProjectArticle;
import com.example.asus.wanandroid.network.bean.project.group.ProjectGroup;


import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpServer {
    private static final String BASE_URL = "https://www.wanandroid.com/";
    private static volatile HttpServer sHttpServer;
    private Retrofit.Builder Builder;



    public static HttpServer getInstance() {
        if (sHttpServer == null) {
            synchronized (HttpServer.class) {
                sHttpServer = new HttpServer();
            }
        }

        return sHttpServer;
    }

    private HttpServer() {
        Builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    public void setClient(OkHttpClient client) {
        Builder.client(client);
    }

    //获取首页Article数据
    public Observable<HomeArticle> getHomeArticleData(int pageNum) {
        return Builder.build().create(ApiServer.class).getHomeArticleData(pageNum);
    }

    //获取首页Banner数据
    public Observable<HomeBanner> getHomeBannerData() {
        return Builder.build().create(ApiServer.class).getBannerData();
    }

    //获取首页置顶Article数据
    public Observable<HomeArticleTop> getHomeArticleTopData() {
        return Builder.build().create(ApiServer.class).getHomeArticleTopData();
    }

    //获取知识体系分类
    public Observable<ArchitectureGroup> getArchitectureGroupData() {
        return Builder.build().create(ApiServer.class).getArchitectureGroupdata();
    }

    //获取知识体系下的文章
    public Observable<ArchitectureArticle> getArchitectureArticleData(int pageNum, int cid) {
        return Builder.build().create(ApiServer.class).getArchitectureArticleData(pageNum, cid);
    }

    //获取项目分类
    public Observable<ProjectGroup> getProjectGroupData() {
        return Builder.build().create(ApiServer.class).getProjectGroupData();
    }

    //获取项目下的文章
    public Observable<ProjectArticle> getProjectArticleData(int page, int cid) {
        return Builder.build().create(ApiServer.class).getProjectArticleData(page, cid);
    }

    //获取微信公众号分类
    public Observable<ArchitectureGroup> getWxarticleGroupData() {
        return Builder.build().create(ApiServer.class).getWxarticleGroupData();
    }

    //获取微信公众号下的文章
    public Observable<HomeArticle> getWxarticleArticleData(int page, int cid) {
        return Builder.build().create(ApiServer.class).getWxarticleArticleData(page, cid);
    }

    //登录
    public Observable<LoginData> getLoginData(String username, String password) {
        return Builder.build().create(ApiServer.class).getLoginData(username, password);
    }

    //注册
    public Observable<LoginData> getRegisterData(String username, String password, String repassword) {
        return Builder.build().create(ApiServer.class).getRegisterData(username, password, repassword);
    }
}

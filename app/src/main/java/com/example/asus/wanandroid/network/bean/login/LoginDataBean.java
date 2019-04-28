package com.example.asus.wanandroid.network.bean.login;

import com.example.asus.wanandroid.base.BaseBean;

import java.util.List;

public class LoginDataBean extends BaseBean {
    private String[] chapterTops;
    private int[] collectIds;
    private String email;
    private String icon;
    private int id;
    private String password;
    private String token;
    private int type;
    private String username;

    public String[] getChapterTops() {
        return chapterTops;
    }

    public void setChapterTops(String[] chapterTops) {
        this.chapterTops = chapterTops;
    }

    public int[] getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(int[] collectIds) {
        this.collectIds = collectIds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

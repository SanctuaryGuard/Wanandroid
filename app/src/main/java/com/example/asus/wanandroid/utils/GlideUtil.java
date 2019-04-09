package com.example.asus.wanandroid.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {
    private static GlideUtil sGlideUtil;

    private GlideUtil() {

    }

    public static GlideUtil getInstance() {
        if (sGlideUtil == null) {
            sGlideUtil = new GlideUtil();
        }
        return sGlideUtil;
    }

    public void displayImage(Context context, String url, ImageView view) {
        Glide.with(context).load(url).dontAnimate().into(view);
    }
}

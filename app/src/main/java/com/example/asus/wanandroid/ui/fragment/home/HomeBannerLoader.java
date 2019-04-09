package com.example.asus.wanandroid.ui.fragment.home;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.asus.wanandroid.utils.GlideUtil;
import com.youth.banner.loader.ImageLoader;

public class HomeBannerLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load((String) path).into(imageView);
    }

}

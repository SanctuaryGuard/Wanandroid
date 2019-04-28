package com.example.asus.wanandroid.ui.fragment.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseFragment;
import com.example.asus.wanandroid.ui.fragment.loginandregister.LoginAndRegisterActivity;
import com.example.asus.wanandroid.utils.SharedPreferenceUtil;


import butterknife.BindView;
import butterknife.OnClick;


public class MeFragment extends BaseFragment {

    @BindView(R.id.me_toolbar)
    CollapsingToolbarLayout mMeCollapsingToolbarLayout;
    @BindView(R.id.me_login_image_view)
    ImageView mMeLoginImageView;
    @BindView(R.id.me_collection_btn)
    Button mMeCollectionBtn;
    @BindView(R.id.me_about_btn)
    Button mMeAboutBtn;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    public void init() {
        if (SharedPreferenceUtil.loadInt("login", "loginState") == 1) {
            mMeCollapsingToolbarLayout.setTitle(SharedPreferenceUtil.loadString("login", "username"));
        }
    }

    @OnClick(R.id.me_collection_btn)
    public void startCollection() {

    }

    @OnClick(R.id.me_about_btn)
    public void startAbout() {

    }

    @OnClick(R.id.me_login_image_view)
    public void login() {
        LoginAndRegisterActivity.actionStart(getActivity());
    }

}

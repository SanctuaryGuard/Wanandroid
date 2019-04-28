package com.example.asus.wanandroid.ui.fragment.loginandregister;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseActivity;



public class LoginAndRegisterActivity extends BaseActivity {

    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.login_register_frame_layout, CreateFragment()).commit();
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public Fragment CreateFragment() {
        return new LoginFragment();
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LoginAndRegisterActivity.class);
        context.startActivity(intent);
    }
}

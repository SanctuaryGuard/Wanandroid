package com.example.asus.wanandroid.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseActivity;
import com.example.asus.wanandroid.network.bean.architecture.group.ArchitectureGroupData;
import com.example.asus.wanandroid.ui.fragment.architecture.pagearticle.ArchitectureViewPageActivity;
import com.example.asus.wanandroid.ui.fragment.me.MeFragment;
import com.example.asus.wanandroid.ui.fragment.architecture.list.ArchitectureFragment;
import com.example.asus.wanandroid.ui.fragment.project.ProjectFragment;
import com.example.asus.wanandroid.ui.fragment.publicnumber.PublicNumberFragment;
import com.example.asus.wanandroid.ui.fragment.home.HomeFragment;
import com.example.asus.wanandroid.utils.SharedPreferenceUtil;

public class MainActivity extends BaseActivity {

    private RadioGroup mRadioGroup;

    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private ArchitectureFragment mArchitectureFragment;
    private ProjectFragment mProjectFragment;
    private PublicNumberFragment mPublicNumberFragment;
    private MeFragment mMeFragment;

    private Fragment mCurrenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferenceUtil.removeData("login", "loginState");
        SharedPreferenceUtil.removeData("login", "username");
    }

    private void init() {
        mFragmentManager = getSupportFragmentManager();
        mHomeFragment = new HomeFragment();
        mFragmentManager.beginTransaction().replace(R.id.main_frame_layout, mHomeFragment).commit();
        mCurrenFragment = mHomeFragment;
        
        mRadioGroup = findViewById(R.id.radio_group);
        mRadioGroup.check(R.id.home_radio);
        mRadioGroup.setOnCheckedChangeListener((radiogroup, i) -> {
            switch (i) {
                case R.id.home_radio:
                    if (mHomeFragment == null) {
                        mHomeFragment = new HomeFragment();
                    }
                    showFragment(mHomeFragment);
                    break;

                case R.id.architecture_radio:
                    if (mArchitectureFragment == null) {
                        mArchitectureFragment = new ArchitectureFragment();
                    }
                    showFragment(mArchitectureFragment);
                    break;

                case R.id.project_radio:
                    if (mProjectFragment == null) {
                        mProjectFragment = new ProjectFragment();
                    }
                    showFragment(mProjectFragment);
                    break;

                case R.id.public_number_radio:
                    if (mPublicNumberFragment == null) {
                        mPublicNumberFragment = new PublicNumberFragment();
                    }
                    showFragment(mPublicNumberFragment);
                    break;

                case R.id.me_radio:
                    if (mMeFragment == null) {
                        mMeFragment = new MeFragment();
                    }
                    showFragment(mMeFragment);
                    break;
            }
        });

        RadioButton[] radioButtons = new RadioButton[] { findViewById(R.id.home_radio), findViewById(R.id.architecture_radio),
                findViewById(R.id.project_radio), findViewById(R.id.public_number_radio), findViewById(R.id.me_radio)};
        int[] images = new int[] {R.drawable.menu_home_, R.drawable.menu_knowledge_hierarchy, R.drawable.menu_project,
                R.drawable.menu_wechat_sub, R.drawable.menu_me};

        drawableRadioButton(radioButtons, images);

    }

    private void drawableRadioButton(RadioButton[] radioButtons, int[] images) {
        for (int i = 0; i < radioButtons.length; i++){
            Drawable drawableHome = getResources().getDrawable(images[i]);
            drawableHome.setBounds(0, 0, 80, 80);//第一0是距左右边距离，第二0是距上下边距离，第三长度,第四宽度
            radioButtons[i].setCompoundDrawables(null, drawableHome, null, null);
        }
    }

    private void showFragment(Fragment fragment) {
        if (mCurrenFragment != fragment) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            transaction.hide(mCurrenFragment);
            mCurrenFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.main_frame_layout, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Fragment CreateFragment() {
        return null;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}

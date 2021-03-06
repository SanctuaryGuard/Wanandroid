package com.example.asus.wanandroid.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BaseActivity;
import com.example.asus.wanandroid.ui.fragment.architecture.ArchitectureFragment;
import com.example.asus.wanandroid.ui.fragment.project.ProjectFragment;
import com.example.asus.wanandroid.ui.fragment.publicnumber.PublicNumberFragment;
import com.example.asus.wanandroid.ui.fragment.home.HomeFragment;

public class MainActivity extends BaseActivity {

    private RadioGroup mRadioGroup;

    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private ArchitectureFragment mArchitectureFragment;
    private ProjectFragment mProjectFragment;
    private PublicNumberFragment mPublicNumberFragment;

    private Fragment mCurrenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
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
            }
        });
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
}

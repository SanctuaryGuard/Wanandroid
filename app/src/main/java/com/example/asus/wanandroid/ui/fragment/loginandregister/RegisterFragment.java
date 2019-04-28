package com.example.asus.wanandroid.ui.fragment.loginandregister;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.base.MVPFragment;

public class RegisterFragment extends MVPFragment {
    @Override
    protected BasePresenter initPresenter() {
        return new BasePresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void init() {

    }
}

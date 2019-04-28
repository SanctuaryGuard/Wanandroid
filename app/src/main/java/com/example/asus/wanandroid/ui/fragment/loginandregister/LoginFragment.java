package com.example.asus.wanandroid.ui.fragment.loginandregister;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.wanandroid.R;
import com.example.asus.wanandroid.base.BasePresenter;
import com.example.asus.wanandroid.base.MVPFragment;
import com.example.asus.wanandroid.network.bean.login.LoginData;
import com.example.asus.wanandroid.network.bean.login.LoginDataBean;
import com.example.asus.wanandroid.ui.activity.MainActivity;
import com.example.asus.wanandroid.ui.fragment.architecture.list.presenter.ArchitecturePresenter;
import com.example.asus.wanandroid.ui.fragment.contract.HomeContract;
import com.example.asus.wanandroid.ui.fragment.home.presenter.HomePresenter;
import com.example.asus.wanandroid.ui.fragment.loginandregister.presenter.LoginAndRegisterPresenter;
import com.example.asus.wanandroid.utils.SharedPreferenceUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginFragment extends MVPFragment<LoginAndRegisterPresenter> implements HomeContract.SimpleView {

    @BindView(R.id.login_username_edit_text)
    EditText mUserNameEdit;
    @BindView(R.id.login_password_edit_text)
    EditText mPassWordEdit;

    @Override
    protected LoginAndRegisterPresenter initPresenter() {
        return new LoginAndRegisterPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.register_btn)
    public void register() {
        RegisterFragment registerFragment = new RegisterFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().hide(LoginFragment.this).add(R.id.login_register_frame_layout, registerFragment).show(registerFragment).commit();
    }

    @OnClick(R.id.login_btn)
    public  void login() {
        String username = mUserNameEdit.getText().toString();
        String password = mPassWordEdit.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(getActivity().getApplicationContext(), "用户名或密码为空！", Toast.LENGTH_SHORT).show();
            return;
        }

        presenter.getLoginData(username, password, null);
    }

    @Override
    public void onSuccess(Object object) {
        if (object instanceof LoginData) {
            LoginData loginData = (LoginData) object;
            LoginDataBean dataBean = loginData.getData();
            SharedPreferenceUtil.putData("login", "username", dataBean.getUsername());
            SharedPreferenceUtil.putData("login", "loginState", 1);
            MainActivity.actionStart(getActivity());
        }

    }

    @Override
    public void onFail(Throwable e) {
        SharedPreferenceUtil.putData("login", "loginState", 2);
        Log.i("hell", e.getLocalizedMessage());
    }

    @Override
    public void onCompleted() {
        Log.i("hell", "onCompleted!");
    }
}

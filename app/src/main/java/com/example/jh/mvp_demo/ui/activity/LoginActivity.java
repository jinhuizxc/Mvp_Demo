package com.example.jh.mvp_demo.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jh.baselibrary.utils.LogUtil;
import com.example.jh.baselibrary.widget.DeleteEditText;
import com.example.jh.mvp_demo.App;
import com.example.jh.mvp_demo.R;
import com.example.jh.mvp_demo.base.activity.BaseActivity;
import com.example.jh.mvp_demo.bean.UserInfo;
import com.example.jh.mvp_demo.ui.login.LoginView;
import com.example.jh.mvp_demo.ui.login.presenter.impl.LoginPresenterImpl;
import com.example.jh.mvp_demo.utils.LoginUtil;
import com.example.jh.mvp_demo.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：jinhui on 2017/5/19
 * 邮箱：1004260403@qq.com
 */

public class LoginActivity extends BaseActivity implements LoginView {


    @Inject
    LoginPresenterImpl mLoginPresenter;
    @BindView(R.id.edit_login_phone)
    DeleteEditText editLoginPhone;
    @BindView(R.id.edit_login_password)
    DeleteEditText editLoginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register_user)
    TextView tvRegisterUser;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.base_back)
    ImageView back;
    @BindView(R.id.base_title)
    TextView title;
    @BindView(R.id.base_title_view)
    RelativeLayout titleView;

    private ProgressDialog progressDialog;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInject() {

        mActivityComponent.inject(this);

    }

    @Override
    protected void initView() {
        isNeedNavigationView = false;

        mPresenter = mLoginPresenter;
        //presenter和View的绑定
        mPresenter.onBindView(this);

        back.setVisibility(View.GONE);
        title.setText("登录");
        title.setTextColor(getResources().getColor(R.color.rgb_color_01));
        titleView.setBackgroundColor(getResources().getColor(R.color.transparent));

        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("登陆中...");


    }


    @Override
    public void showProgress(boolean pullToRefresh) {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorMsg(String errorMsg, boolean pullToRefresh) {
        LogUtil.fussenLog().d("1008611" + "====showErrorMsg========" + errorMsg);
        ToastUtil.showToast(errorMsg);
    }


    @Override
    public void loadData(boolean pullToRefresh) {
        login();
    }


    @Override
    public void toHomeActivity(UserInfo data) {

        if (data != null) {
            startActivity(new Intent(App.getContext(), HomeActivity.class));
            overridePendingTransition(0, android.R.anim.fade_out);
            finish();
        }
    }


    @OnClick({R.id.btn_login, R.id.tv_register_user, R.id.tv_forgot_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loadData(false);
                break;
            case R.id.tv_register_user:
                break;
            case R.id.tv_forgot_password:
                break;
        }
    }


    private void login() {

        String number = editLoginPhone.getText().toString().trim();
        String password = editLoginPassword.getText().toString().trim();

        if (LoginUtil.checkAcount(number, password)) {
            String encryptNum = LoginUtil.encryptString(number);
            String encryptPassword = LoginUtil.encryptString(password);

            Map<String, String> params = new HashMap<>();

            params.put("username", encryptNum);
            params.put("password", encryptPassword);
            mLoginPresenter.login(params);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

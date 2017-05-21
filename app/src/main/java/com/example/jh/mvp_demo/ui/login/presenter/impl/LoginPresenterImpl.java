package com.example.jh.mvp_demo.ui.login.presenter.impl;

import com.example.jh.baselibrary.base.presenter.BasePresenter;
import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.mvp_demo.bean.UserInfo;
import com.example.jh.mvp_demo.ui.login.LoginView;
import com.example.jh.mvp_demo.ui.login.model.LoginInteractor;
import com.example.jh.mvp_demo.ui.login.model.impl.LoginInteractorImpl;
import com.example.jh.mvp_demo.ui.login.presenter.LoginPresenter;

import java.util.Map;

import javax.inject.Inject;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * 当presenter创建的时候，此时model层也应该随之被创建，可以准备获取数据
 */

public class LoginPresenterImpl extends BasePresenter<LoginView, UserInfo> implements LoginPresenter, RequestCallBack<UserInfo> {

    private LoginInteractor<UserInfo> mLoginInteractor;

    @Inject
    public LoginPresenterImpl(LoginInteractorImpl loginInteractor) {
        this.mLoginInteractor = loginInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void login(Map<String, String> accountInfo) {
        getView().showProgress(false);
        toLogin(accountInfo);
    }

    /**
     * 调用model层的方法
     *
     * @param accountInfo
     */
    private void toLogin(Map<String, String> accountInfo) {
        mSubscription = mLoginInteractor.loginApp(accountInfo, this);
    }


    /**
     * 访问网络成功回调
     *
     * @param data
     */
    @Override
    public void onSuccess(UserInfo data) {
        super.onSuccess(data);
        getView().toHomeActivity(data);
    }

    /**
     * 访问网络失败回调
     *
     * @param errorMsg
     * @param pullToRefresh
     */
    @Override
    public void onError(String errorMsg, boolean pullToRefresh) {
        super.onError(errorMsg, pullToRefresh);
    }
}

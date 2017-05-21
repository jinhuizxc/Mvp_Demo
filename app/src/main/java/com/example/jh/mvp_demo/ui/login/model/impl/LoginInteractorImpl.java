package com.example.jh.mvp_demo.ui.login.model.impl;

import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.baselibrary.utils.LogUtil;
import com.example.jh.baselibrary.utils.TransformUtils;
import com.example.jh.daogenerator.dao.User;
import com.example.jh.mvp_demo.api.NetConfig;
import com.example.jh.mvp_demo.bean.UserInfo;
import com.example.jh.mvp_demo.db.DbUtils;
import com.example.jh.mvp_demo.ui.login.model.LoginInteractor;
import com.example.jh.mvp_demo.utils.NetworkUtils;
import com.example.jh.mvp_demo.utils.PreferUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class LoginInteractorImpl implements LoginInteractor<UserInfo> {

    @Inject
    public LoginInteractorImpl() {
    }


    /**
     * 登录app
     *
     * @param params   账户信息
     * @param callBack 回调
     * @return
     */
    @Override
    public Subscription loginApp(final Map<String, String> params, final RequestCallBack<UserInfo> callBack) {

        LogUtil.fussenLog().d("1008611" + "========model层开始登陆========");

        params.put("loginType", "1");
        params.put("loginSource", "2");
        params.put("type", "2");//用户身份1:学员 2:教练


        return NetworkUtils.getLogin()
                .toLogin(NetConfig.LOGING_URL, params)
                .doOnNext(new Action1<UserInfo>() {
                    @Override
                    public void call(UserInfo info) {
                        User user = new User();
                        user.setUid(info.userId);
                        user.setNickName(info.nickName);
                        user.setAvatarUrl(info.avatarUrl);
                        user.setGender(info.gender);
                        user.setMobile(info.mobile);
                        DbUtils.insertUser(user);

                    }
                })
                .compose(TransformUtils.schedulersTransformer())
                .subscribe(new Subscriber<UserInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.fussenLog().d("1008611" + "=====onError====" + e.getMessage());
                        callBack.onError(e.getMessage(), false);
                        PreferUtils.getInstance().setAppIsLogin(false);
                    }

                    @Override
                    public void onNext(UserInfo info) {

                        LogUtil.fussenLog().d("1008611" + "=====onNext====" + info.nickName);
                        PreferUtils.getInstance().setUserUid(info.userId);
                        callBack.onSuccess(info);
                        PreferUtils.getInstance().setAppIsLogin(true);
                    }
                });

    }

}


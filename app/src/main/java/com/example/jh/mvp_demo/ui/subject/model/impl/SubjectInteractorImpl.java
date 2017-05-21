package com.example.jh.mvp_demo.ui.subject.model.impl;

import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.baselibrary.utils.LogUtil;
import com.example.jh.mvp_demo.App;
import com.example.jh.mvp_demo.api.NetConfig;
import com.example.jh.mvp_demo.network.callback.ResponseCallBack;
import com.example.jh.mvp_demo.bean.WeekEvent;
import com.example.jh.mvp_demo.ui.subject.model.SubjectInteractor;
import com.example.jh.mvp_demo.utils.NetworkUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * <p>
 * 此类为model层，在此类中做耗时操作
 */

public class SubjectInteractorImpl implements SubjectInteractor<WeekEvent> {

    @Inject
    public SubjectInteractorImpl() {
    }


    @Override
    public Subscription getSubject(Map<String, String> params, final RequestCallBack<WeekEvent> callBack) {


        return NetworkUtils.getInstance(App.getContext()).executePost(NetConfig.GETSUBJECT_URL, params, new ResponseCallBack<WeekEvent>() {
            @Override
            public void onStart() {
                callBack.onStart();
            }

            @Override
            public void onCompleted() {
                callBack.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.fussenLog().d("1008611" + "========onError========" + e.getMessage());
                callBack.onError(e.getMessage(), false);
            }

            @Override
            public void onSuccee(WeekEvent response) {
                LogUtil.fussenLog().d("1008611" + "========onSuccee========" + response.workTime.endTime);
                callBack.onSuccess(response);
            }
        });

    }

}

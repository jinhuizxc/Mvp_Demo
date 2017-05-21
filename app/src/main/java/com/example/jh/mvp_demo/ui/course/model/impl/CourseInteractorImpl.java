package com.example.jh.mvp_demo.ui.course.model.impl;

import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.mvp_demo.api.NetConfig;
import com.example.jh.mvp_demo.network.callback.ResponseCallBack;
import com.example.jh.mvp_demo.bean.CourseData;
import com.example.jh.mvp_demo.ui.course.model.CourseInteractor;
import com.example.jh.mvp_demo.utils.NetworkUtils;
import com.example.jh.mvp_demo.utils.UiUtils;

import java.util.Map;

import javax.inject.Inject;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class CourseInteractorImpl implements CourseInteractor<CourseData> {


    @Inject
    public CourseInteractorImpl() {
    }

    @Override
    public Subscription getAllCourseType(Map<String, String> params, final RequestCallBack<CourseData> callBack) {


        return NetworkUtils.getInstance(UiUtils.getContext()).executePost(NetConfig.GET_ALL_TYPE, new ResponseCallBack<CourseData>() {
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
                callBack.onError(e.getMessage(), false);
            }

            @Override
            public void onSuccee(CourseData response) {
                callBack.onSuccess(response);
            }
        });
    }
}

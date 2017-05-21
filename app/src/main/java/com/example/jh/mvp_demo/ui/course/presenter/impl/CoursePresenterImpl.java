package com.example.jh.mvp_demo.ui.course.presenter.impl;

import com.example.jh.baselibrary.base.presenter.BasePresenter;
import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.mvp_demo.bean.CourseData;
import com.example.jh.mvp_demo.ui.course.CourseView;
import com.example.jh.mvp_demo.ui.course.model.CourseInteractor;
import com.example.jh.mvp_demo.ui.course.model.impl.CourseInteractorImpl;
import com.example.jh.mvp_demo.ui.course.presenter.CoursePresenter;

import java.util.Map;

import javax.inject.Inject;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class CoursePresenterImpl extends BasePresenter<CourseView, CourseData> implements CoursePresenter, RequestCallBack<CourseData> {


    private CourseInteractor<CourseData> mCourseInteractor;

    @Inject
    public CoursePresenterImpl(CourseInteractorImpl courseInteractor) {
        this.mCourseInteractor = courseInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void getAllCourseType(Map<String, String> params, boolean pullToRefresh) {

        getView().showProgress(pullToRefresh);

        mSubscription = mCourseInteractor.getAllCourseType(null, this);
    }


    @Override
    public void onSuccess(CourseData data) {
        super.onSuccess(data);
        if (isViewAttached())
            getView().loadDataSucces(data);
    }

}

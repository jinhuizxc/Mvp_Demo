package com.example.jh.mvp_demo.ui.course.model;

import com.example.jh.baselibrary.callback.RequestCallBack;

import java.util.Map;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface CourseInteractor<T> {
    Subscription getAllCourseType(Map<String, String> params, RequestCallBack<T> callBack);
}


package com.example.jh.mvp_demo.ui.course.presenter;

import com.example.jh.baselibrary.base.presenter.PresenterLife;

import java.util.Map;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface CoursePresenter extends PresenterLife {
    void getAllCourseType(Map<String, String> params, boolean pullToRefresh);
}


package com.example.jh.mvp_demo.di.component;

import android.app.Activity;
import android.content.Context;

import com.example.jh.mvp_demo.di.module.FragmentModule;
import com.example.jh.mvp_demo.di.scope.ContextLife;
import com.example.jh.mvp_demo.di.scope.ForFragment;
import com.example.jh.mvp_demo.ui.fragment.CourseFragment;
import com.example.jh.mvp_demo.ui.fragment.SubjectFragment;
import com.example.jh.mvp_demo.ui.user.UserFragment;

import dagger.Component;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@ForFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();


    Activity getActivity();

    void inject(SubjectFragment fragment);
    void inject(CourseFragment fragment);
    void inject(UserFragment fragment);
}

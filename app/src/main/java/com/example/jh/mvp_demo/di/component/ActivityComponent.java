package com.example.jh.mvp_demo.di.component;

import android.app.Activity;
import android.content.Context;

import com.example.jh.mvp_demo.di.module.ActivityModule;
import com.example.jh.mvp_demo.di.scope.ContextLife;
import com.example.jh.mvp_demo.di.scope.ForActivity;
import com.example.jh.mvp_demo.ui.activity.HomeActivity;
import com.example.jh.mvp_demo.ui.activity.LoginActivity;

import dagger.Component;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@ForActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(HomeActivity homeActivity);

    void inject(LoginActivity loginActivity);
    // 运动界面
//    void inject(SportActivity sportActivity);
}

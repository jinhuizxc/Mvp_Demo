package com.example.jh.mvp_demo.di.component;

import android.content.Context;

import com.example.jh.mvp_demo.di.module.ApplicationModule;
import com.example.jh.mvp_demo.di.scope.ContextLife;
import com.example.jh.mvp_demo.di.scope.ForApp;

import dagger.Component;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@ForApp
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}


package com.example.jh.mvp_demo.di.module;

import android.content.Context;

import com.example.jh.mvp_demo.App;
import com.example.jh.mvp_demo.di.scope.ContextLife;
import com.example.jh.mvp_demo.di.scope.ForApp;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@Module
public class ApplicationModule {

    private App mApplication;

    public ApplicationModule(App application) {
        mApplication = application;
    }

    @Provides
    @ForApp
    @ContextLife("Application")
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}


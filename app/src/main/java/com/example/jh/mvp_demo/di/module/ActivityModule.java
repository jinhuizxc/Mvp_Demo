package com.example.jh.mvp_demo.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.jh.mvp_demo.di.scope.ContextLife;
import com.example.jh.mvp_demo.di.scope.ForActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }


    @Provides
    @ForActivity
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mActivity;
    }


    @Provides
    @ForActivity
    public Activity provideActivity() {
        return mActivity;
    }
}


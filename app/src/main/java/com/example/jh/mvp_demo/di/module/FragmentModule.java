package com.example.jh.mvp_demo.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.jh.mvp_demo.di.scope.ContextLife;
import com.example.jh.mvp_demo.di.scope.ForFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }


    @Provides
    @ForFragment
    @ContextLife("Activity")
    public Context provideActivityContext() {
        return mFragment.getActivity();
    }


    @Provides
    @ForFragment
    public Activity provideActivity() {
        return mFragment.getActivity();
    }


    @Provides
    @ForFragment
    public Fragment provideFragment() {
        return mFragment;
    }
}


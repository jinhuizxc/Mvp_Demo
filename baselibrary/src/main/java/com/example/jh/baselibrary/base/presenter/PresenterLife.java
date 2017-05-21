package com.example.jh.baselibrary.base.presenter;

import android.support.annotation.NonNull;

import com.example.jh.baselibrary.base.view.BaseView;


/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * presenter的生命周期
 * 每个presenter须继承此接口
 * 执行顺序：onBindView() --> onCreate() --> onDestroy()
 */

public interface PresenterLife {
    void onCreate();
    void onBindView(@NonNull BaseView view);
    void onDestroy();
}

package com.example.jh.mvp_demo.ui.user.model;

import com.example.jh.baselibrary.callback.RequestCallBack;

import java.io.File;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface UserInteractor<T> {
    Subscription upLoadImage(File file, RequestCallBack<T> callBack);
    Subscription downLoadImage(String url, RequestCallBack<T> callBack);
}


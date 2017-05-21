package com.example.jh.mvp_demo.network;

import rx.Subscriber;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }


    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T t) {

    }
}

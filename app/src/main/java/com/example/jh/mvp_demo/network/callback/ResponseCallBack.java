package com.example.jh.mvp_demo.network.callback;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 * 请求结果的方法
 */

public interface ResponseCallBack<T> {
    void onStart();

    void onCompleted();

    void onError(Throwable e);

    void onSuccee(T response);
}


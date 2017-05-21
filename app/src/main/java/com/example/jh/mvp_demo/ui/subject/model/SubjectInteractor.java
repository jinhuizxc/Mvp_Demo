package com.example.jh.mvp_demo.ui.subject.model;

import com.example.jh.baselibrary.callback.RequestCallBack;

import java.util.Map;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * <p>
 * 此接口为presenter层操作model层
 * <p>
 * 在model层实现此接口
 * <p>
 * 在presenter层调用接口中的方法
 */

public interface SubjectInteractor<T> {
    Subscription getSubject(Map<String, String> params, RequestCallBack<T> callBack);
}
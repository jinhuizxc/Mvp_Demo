package com.example.jh.baselibrary.utils;

import android.os.Looper;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * 解除订阅
 */

public class AppUtil {
    /**
     * 解除订阅
     *
     * @param subscription
     */
    public static void cancelSubscription(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            subscription = null;
        }
    }

    /**
     * 检查是否在主线程内
     *
     * @return
     */
    public static boolean checkMain() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}


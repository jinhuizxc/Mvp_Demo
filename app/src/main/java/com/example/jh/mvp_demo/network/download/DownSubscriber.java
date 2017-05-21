package com.example.jh.mvp_demo.network.download;

import android.content.Context;
import android.util.Log;

import com.example.jh.mvp_demo.network.BaseSubscriber;
import com.example.jh.mvp_demo.network.callback.DownLoadCallBack;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class DownSubscriber <ResponseBody extends okhttp3.ResponseBody> extends BaseSubscriber<ResponseBody> {
    public static final String TAG = "[DownLoad]";
    private DownLoadCallBack callBack;
    private String path;
    private String name;
    private Context mContext;

    public DownSubscriber(String path, String name, DownLoadCallBack callBack, Context mContext) {
        this.path = path;
        this.name = name;
        this.callBack = callBack;
        this.mContext = mContext;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (callBack != null) {
            callBack.onStart();
        }
    }

    @Override
    public void onCompleted() {
        if (callBack != null) {
            callBack.onCompleted();
        }
    }

    @Override
    public void onError(java.lang.Throwable e) {
        Log.d( TAG, "======DownSubscriber:onError========" + e.getMessage());
        callBack.onError(e);
    }


    @Override
    public void onNext(ResponseBody responseBody) {

        Log.d(TAG, "=======DownSubscriber:>>>> onNext===========");

        DownLoadManager.getInstance(callBack,mContext).writeResponseBodyToDisk(path, name, responseBody);

    }
}


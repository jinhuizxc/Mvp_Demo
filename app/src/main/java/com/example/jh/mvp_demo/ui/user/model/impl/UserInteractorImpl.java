package com.example.jh.mvp_demo.ui.user.model.impl;

import android.util.Log;

import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.baselibrary.config.FileConfig;
import com.example.jh.mvp_demo.api.NetConfig;
import com.example.jh.mvp_demo.network.callback.DownLoadCallBack;
import com.example.jh.mvp_demo.network.callback.ResponseCallBack;
import com.example.jh.mvp_demo.bean.UpLoad;
import com.example.jh.mvp_demo.ui.user.model.UserInteractor;
import com.example.jh.mvp_demo.utils.NetworkUtils;
import com.example.jh.mvp_demo.utils.UiUtils;

import java.io.File;

import javax.inject.Inject;

import rx.Subscription;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class UserInteractorImpl implements UserInteractor {

    private static final String TAG = "UserInteractorImpl";

    @Inject
    public UserInteractorImpl() {

    }

    @Override
    public Subscription upLoadImage(File file, final RequestCallBack callBack) {
        if (file == null) {
            callBack.onError("文件为空", false);
            callBack.onCompleted();
            return null;
        }

        return NetworkUtils.getInstance(UiUtils.getContext()).uploadFlie(NetConfig.UPLOAD_PHOTO, file, new ResponseCallBack<UpLoad>() {
            @Override
            public void onStart() {
                callBack.onStart();
                Log.e(TAG, "onStart 方法被执行");
            }

            @Override
            public void onCompleted() {
                callBack.onCompleted();
                Log.e(TAG, "onCompleted 方法被执行");
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage(), false);
                Log.e(TAG, "onError 方法被执行");
            }

            @Override
            public void onSuccee(UpLoad response) {
                callBack.onSuccess(response);
                Log.e(TAG, "onSuccee 方法被执行");
            }
        });
    }

    @Override
    public Subscription downLoadImage(String url, final RequestCallBack callBack) {
        return NetworkUtils.getInstance(UiUtils.getContext()).download(url, FileConfig.DOWNLOAD_IMG_PATH, "touxiang", new DownLoadCallBack() {
            @Override
            public void onStart() {
                callBack.onStart();
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage(), false);
            }

            @Override
            public void onSuccess(String path, String fileName, long fileSize) {
                callBack.dowloadSuccess(path, fileName, fileSize);
            }

            @Override
            public void onProgress(long downSize, long fileSize) {
                callBack.onProgress(downSize, fileSize);
            }
        });
    }
}


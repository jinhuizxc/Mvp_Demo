package com.example.jh.mvp_demo.ui.user.presenter.impl;

import com.example.jh.baselibrary.base.presenter.BasePresenter;
import com.example.jh.baselibrary.callback.RequestCallBack;
import com.example.jh.mvp_demo.bean.UpLoad;
import com.example.jh.mvp_demo.ui.user.UserView;
import com.example.jh.mvp_demo.ui.user.model.UserInteractor;
import com.example.jh.mvp_demo.ui.user.model.impl.UserInteractorImpl;
import com.example.jh.mvp_demo.ui.user.presenter.UserPresenter;

import java.io.File;

import javax.inject.Inject;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class UserPresenterImpl extends BasePresenter<UserView, Object> implements UserPresenter, RequestCallBack<Object> {


    private UserInteractor mUserInteractor;

    @Inject
    public UserPresenterImpl(UserInteractorImpl userInteractor) {
        this.mUserInteractor = userInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onSuccess(Object data) {
        super.onSuccess(data);
        if (data instanceof UpLoad) {
            getView().upLoadImageSucce((UpLoad) data);
        }
    }

    @Override
    public void onProgress(long downSize, long fileSize) {
        if (isViewAttached()) {
            getView().onProgress(downSize, fileSize);
        }
    }

    @Override
    public void dowloadSuccess(String path, String fileName, long fileSize) {
        super.dowloadSuccess(path, fileName, fileSize);
        if (isViewAttached())
            getView().downLoadImageSucce(path);
    }

    // 上传图片
    @Override
    public void upLoadImage(File file) {
        mSubscription = mUserInteractor.upLoadImage(file, this);
    }

    // 下载图片
    @Override
    public void downLoadImage(String url) {
        getView().showProgress(false);
        mSubscription = mUserInteractor.downLoadImage(url, this);
    }
}


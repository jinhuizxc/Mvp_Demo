package com.example.jh.mvp_demo.ui.user.presenter;

import com.example.jh.baselibrary.base.presenter.PresenterLife;

import java.io.File;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface UserPresenter extends PresenterLife {

    void upLoadImage(File file);

    void downLoadImage(String url);
}


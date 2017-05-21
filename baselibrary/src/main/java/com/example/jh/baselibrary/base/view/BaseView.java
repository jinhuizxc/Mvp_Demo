package com.example.jh.baselibrary.base.view;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 * <p>
 * 所有view的基类
 */

public interface BaseView extends MvpView {
    void showProgress(boolean pullToRefresh);

    void hideProgress();

    void showErrorMsg(String errorMsg,boolean pullToRefresh);

    void loadData(boolean pullToRefresh);
}


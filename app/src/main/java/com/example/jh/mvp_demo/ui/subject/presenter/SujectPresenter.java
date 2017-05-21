package com.example.jh.mvp_demo.ui.subject.presenter;

import com.example.jh.baselibrary.base.presenter.PresenterLife;

import java.util.Map;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * <p>
 * 此接口是view层操作presenter层，presenter须实现此接口
 *
 * 在view层调用接口中的方法
 */

public interface SujectPresenter extends PresenterLife {
    void getSubject(Map<String, String> params , boolean pullToRefresh);
}

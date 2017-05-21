package com.example.jh.mvp_demo.ui.login;

import com.example.jh.baselibrary.base.view.BaseView;
import com.example.jh.mvp_demo.bean.UserInfo;


/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * 此接口是presenter层操作view层
 * view层须实现此接口，并实现该接口的方法
 * 调用在presenter层调用即可
 */

public interface LoginView extends BaseView {
    void toHomeActivity(UserInfo data);
}

package com.example.jh.mvp_demo.ui.subject;

import com.example.jh.baselibrary.base.view.BaseView;
import com.example.jh.mvp_demo.bean.WeekEvent;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface SubjectView extends BaseView {
    void refreshView(WeekEvent data);
}

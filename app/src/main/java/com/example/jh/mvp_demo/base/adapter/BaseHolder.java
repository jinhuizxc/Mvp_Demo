package com.example.jh.mvp_demo.base.adapter;

import android.view.View;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public abstract class BaseHolder<T> {

    public View convertView;
    public T mData;

    public BaseHolder() {
        convertView = initView();
        convertView.setTag(this);
    }

    public void setData(T data) {
        this.mData = data;
        if (mData != null) {
            refreshView();
        }
    }
    //初始化布局
    public abstract View initView();

    //填充数据
    public abstract void refreshView();
}

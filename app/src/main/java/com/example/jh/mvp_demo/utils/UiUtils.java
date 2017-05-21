package com.example.jh.mvp_demo.utils;

import android.content.Context;

import com.example.jh.mvp_demo.App;

/**
 * 作者：jinhui on 2017/5/19
 * 邮箱：1004260403@qq.com
 */

public class UiUtils {

    public static Context getContext(){
        return App.getContext();
    }


    /**
     * dp转px
     */
    public static int dip2px(float dpValue) {
        final float scale =App.getContext().getResources()
                .getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}


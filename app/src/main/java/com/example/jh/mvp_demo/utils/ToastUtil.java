package com.example.jh.mvp_demo.utils;

import android.widget.Toast;

import com.example.jh.mvp_demo.App;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class ToastUtil {

    private static Toast toast;

    /**
     * 可以连续弹吐司，不用等上个吐司消失
     *
     * @param text
     */
    public static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(App.getContext(),text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}


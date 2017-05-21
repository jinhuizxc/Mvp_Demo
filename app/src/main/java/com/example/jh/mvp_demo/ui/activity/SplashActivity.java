package com.example.jh.mvp_demo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jh.mvp_demo.utils.PreferUtils;
import com.example.jh.mvp_demo.utils.UiUtils;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：jinhui on 2017/5/19
 * 邮箱：1004260403@qq.com
 *
 * 开始正式的写这个demo,这是真正属于自己的demo。
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toHomeActivity();
    }


    private void toHomeActivity() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent intent = new Intent();
//                         是否登录判断，后面在做处理
                        if (PreferUtils.getInstance().getAppIsLogin()) {
                            intent.setClass(UiUtils.getContext(), HomeActivity.class);
                        } else {
                            intent.setClass(UiUtils.getContext(), LoginActivity.class);
                        }
                        startActivity(intent);
                        overridePendingTransition(0, android.R.anim.fade_out);
                        finish();
                    }
                });
    }
}

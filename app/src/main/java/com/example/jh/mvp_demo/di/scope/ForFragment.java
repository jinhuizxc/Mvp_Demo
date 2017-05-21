package com.example.jh.mvp_demo.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ForFragment {
}
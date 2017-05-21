package com.example.jh.mvp_demo.network;

import com.example.jh.mvp_demo.bean.UserInfo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface LoginService {
    @POST()
    @FormUrlEncoded
    Observable<UserInfo> toLogin(
            @Url() String url,
            @FieldMap Map<String, String> params);
}


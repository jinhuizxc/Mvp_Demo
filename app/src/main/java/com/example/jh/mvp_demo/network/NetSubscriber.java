package com.example.jh.mvp_demo.network;

import android.util.Log;

import com.example.jh.baselibrary.exception.FormatException;
import com.example.jh.baselibrary.exception.NetException;
import com.example.jh.baselibrary.utils.JsonUtil;
import com.example.jh.mvp_demo.network.callback.ResponseCallBack;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Type;

import okhttp3.ResponseBody;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 * <p>
 * 服务器返回格式统一处理
 * <p>
 * 只返回data中的数据
 */

public class NetSubscriber<T> extends BaseSubscriber<ResponseBody> {


    public static final String TAG = "[NetSubscriber]";

    private Type finalNeedType;
    private ResponseCallBack<T> callBack;

    public NetSubscriber(Type finalNeedType, ResponseCallBack<T> callBack) {
        this.finalNeedType = finalNeedType;
        this.callBack = callBack;
    }


    @Override
    public void onStart() {
        super.onStart();
        // todo some common as show loadding  and check netWork is NetworkAvailable
        if (callBack != null) {
            callBack.onStart();
        }
    }


    @Override
    public void onCompleted() {
        // todo some common as  dismiss loadding
        if (callBack != null) {
            callBack.onCompleted();
        }
    }

    @Override
    public void onError(java.lang.Throwable e) {
        super.onError(e);
        if (callBack != null) {
            callBack.onError(e);
        }
    }


    @Override
    public void onNext(ResponseBody responseBody) {

        try {
            byte[] bytes = responseBody.bytes();
            String jsStr = new String(bytes);
            Log.i(TAG, "====ResponseBody:====" + jsStr);
            if (callBack != null) {
                try {

                    if (JsonUtil.parseObject(jsStr, finalNeedType) == null) {
                        throw new NullPointerException();
                    }

                    JSONObject jsonObj = new JSONObject(jsStr);

                    int status = jsonObj.optInt("status");

                    String msg = jsonObj.optString("msg", "服务器开小差了~~");

                    if (status == 200) {

                        Object data = jsonObj.get("data");

                        if (data == null) {
                            throw new FormatException();
                        }

                        callBack.onSuccee((T) new Gson().fromJson(data.toString(), finalNeedType));
                    } else {

                        NetException serverException = new NetException(status, msg);
                        callBack.onError(serverException);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    if (callBack != null) {
                        callBack.onError(new FormatException());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (callBack != null) {
                callBack.onError(e);
            }
        }
    }

}


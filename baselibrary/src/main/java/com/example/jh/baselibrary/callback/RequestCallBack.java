package com.example.jh.baselibrary.callback;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 *
 * 请求回调
 */

public interface RequestCallBack<T> {
    void onStart();//请求前
    void onSuccess(T data); //请求成功
    void onError(String errorMsg, boolean pullToRefresh); //请求失败
    void onCompleted();//请求完成
    //下载
    void onProgress(long downSize, long fileSize);
    void dowloadSuccess(String path, String fileName, long fileSize);
}

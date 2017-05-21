package com.example.jh.mvp_demo.network.callback;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public abstract class DownLoadCallBack  {
    public void onStart(){}
    public void onCancel(){}
    public void onCompleted(){}

    /**
     * @param e
     */
    abstract public void onError(java.lang.Throwable e);

    public void onProgress(long downSize,long fileSize){}
    /**
     * @param path
     * @param fileName
     * @param fileSize
     */
    abstract public void onSuccess(String path, String fileName, long fileSize);
}


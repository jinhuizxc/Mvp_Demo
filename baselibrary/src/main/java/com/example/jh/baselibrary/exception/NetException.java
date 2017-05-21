package com.example.jh.baselibrary.exception;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class NetException extends RuntimeException {
    public int code;
    public String message;

    public NetException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}


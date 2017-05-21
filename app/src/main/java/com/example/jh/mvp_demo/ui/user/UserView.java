package com.example.jh.mvp_demo.ui.user;

import com.example.jh.baselibrary.base.view.BaseView;
import com.example.jh.mvp_demo.bean.UpLoad;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public interface UserView extends BaseView {
    void upLoadImageSucce(UpLoad upLoad);
    void downLoadImageSucce(String path);
    void onProgress(long downSize, long fileSize);
}

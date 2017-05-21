package com.example.jh.mvp_demo.ui.course;

import com.example.jh.mvp_demo.base.adapter.BaseHolder;
import com.example.jh.mvp_demo.base.adapter.MyBaseAdapter;
import com.example.jh.mvp_demo.base.adapter.holder.CourseTypeHolder;
import com.example.jh.mvp_demo.bean.CourseData;

import java.util.ArrayList;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class CourseTypeAdapter extends MyBaseAdapter<CourseData.DataListUser> {
    public CourseTypeAdapter(ArrayList<CourseData.DataListUser> data) {
        super(data);
    }

    @Override
    public BaseHolder getHolder(int position) {
        return new CourseTypeHolder();
    }
}


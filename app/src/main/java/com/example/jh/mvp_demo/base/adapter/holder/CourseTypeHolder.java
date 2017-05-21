package com.example.jh.mvp_demo.base.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jh.mvp_demo.R;
import com.example.jh.mvp_demo.base.adapter.BaseHolder;
import com.example.jh.mvp_demo.bean.CourseData;
import com.example.jh.mvp_demo.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class CourseTypeHolder extends BaseHolder<CourseData.DataListUser> {
    @BindView(R.id.image_bg)
    ImageView imageBg;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_content)
    TextView textContent;

    @Override
    public View initView() {


        View view = View.inflate(UiUtils.getContext(), R.layout.item_course_type, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void refreshView() {

        Glide.with(UiUtils.getContext())
                .load(mData.imageUrl)
                .error(R.drawable.ic_image_error)
                .placeholder(R.drawable.ic_image_error)
                .into(imageBg);
        textName.setText(mData.categoryName);
    }
}


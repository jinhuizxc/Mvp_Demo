package com.example.jh.mvp_demo.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.example.jh.baselibrary.widget.ListViewForScroll;
import com.example.jh.mvp_demo.R;
import com.example.jh.mvp_demo.base.fragment.BaseFragment;
import com.example.jh.mvp_demo.bean.CourseData;
import com.example.jh.mvp_demo.ui.course.CourseTypeAdapter;
import com.example.jh.mvp_demo.ui.course.CourseView;
import com.example.jh.mvp_demo.ui.course.presenter.impl.CoursePresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class CourseFragment extends BaseFragment implements CourseView {

    @BindView(R.id.listview)
    ListViewForScroll listview;
    @BindView(R.id.contentView)
    LinearLayout contentView;


    @Inject
    CoursePresenterImpl mCoursepresenter;

    @Override
    protected int getContentView() {
        return R.layout.fragment_course;
    }

    @Override
    protected void initView(View view) {

        mPresenter = mCoursepresenter;

        mPresenter.onBindView(this);

        loadData(false);
    }

    @Override
    protected void initInject() {

        mFragmentComponent.inject(this);
    }

    @Override
    protected void showErrorMessage(String errorMsg, boolean pullToRefresh) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        mCoursepresenter.getAllCourseType(null,pullToRefresh);
    }


    @Override
    public void loadDataSucces(CourseData data) {
        if (data != null) {
            CourseTypeAdapter adapter = new CourseTypeAdapter(data.dataList);
            listview.setAdapter(adapter);
        }
    }
}

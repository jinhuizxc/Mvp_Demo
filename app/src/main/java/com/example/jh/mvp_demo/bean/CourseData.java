package com.example.jh.mvp_demo.bean;

import java.util.ArrayList;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class CourseData {
    /**
     * status : 200
     * showType : 5
     * msg : 官方模板分类列表
     * data : {"dataList":[{"categoryId":"45","categoryName":"减脂"},{"categoryId":"46","categoryName":"增肌"},{"categoryId":"47","categoryName":"塑形"},{"categoryId":"77","categoryName":"保健"},{"categoryId":"78","categoryName":"拉伸"}]}
     */


    public ArrayList<DataListUser> dataList;

    public static class DataListUser {
        /**
         * categoryId : 45
         * categoryName : 减脂
         */

        public String categoryId;
        public String imageUrl;
        public String categoryName;
    }
}


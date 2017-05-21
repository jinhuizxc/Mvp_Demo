package com.example.jh.mvp_demo.bean;

/**
 * 作者：jinhui on 2017/5/21
 * 邮箱：1004260403@qq.com
 */

public class UpLoad {

    /**
     * photoId : 17
     * imageUrl : http://127.0.0.1/images/coach/coach_1453897407.jpg
     */

    public String photoId;
    public String imageUrl;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UpLoad{" +
                "photoId='" + photoId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}


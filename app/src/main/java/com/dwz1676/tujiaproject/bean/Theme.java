package com.dwz1676.tujiaproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class Theme {
    private String id;// 编号
    private String title;// 标题
    private String url;// 详情
    private List<String> thumbnails;// 缩略图

    public Theme() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(List<String> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnails=" + thumbnails +
                '}';
    }
}

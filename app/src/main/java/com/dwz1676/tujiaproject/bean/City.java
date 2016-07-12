package com.dwz1676.tujiaproject.bean;

import android.content.Context;


/**
 * Created by Administrator on 2016/7/8.
 */
public class City {
    private String id;// 编号
    private String title;// 标题
    private String url;// 详情

    public City() {
    }

    public City(String id, String title,String url)
    {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public int getCityResourceId( Context context )
    {
        try
        {
            return context.getResources().getIdentifier(this.title, "drawable", context.getPackageName());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}


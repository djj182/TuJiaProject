package com.dwz1676.tujiaproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class HotUnitsBean implements Serializable {

    /**
     * cityId : 0
     * defaultPicture : http://pic.tujia.com/upload/landlordunit/day_150817/thumb/201508170302119945_580_358.jpg
     * isFavorite : false
     * pictures : ["http://pic.tujia.com/upload/landlordunit/day_150817/thumb/201508170302119945_580_358.jpg"]
     * price : 0
     * unitId : 53334
     * unitName : 大连盛捷天城公寓行政三房式公寓
     */

    private String defaultPicture;
    private boolean isFavorite;
    private int price;//价格没有随机生成
    private String unitName;
    private List<String> pictures;

    public HotUnitsBean() {
    }

    public HotUnitsBean(String defaultPicture, boolean isFavorite, int price, String unitName, List<String> pictures) {
        this.defaultPicture = defaultPicture;
        this.isFavorite = isFavorite;
        this.price = price;
        this.unitName = unitName;
        this.pictures = pictures;
    }

    public String getDefaultPicture() {
        return defaultPicture;
    }

    public void setDefaultPicture(String defaultPicture) {
        this.defaultPicture = defaultPicture;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}

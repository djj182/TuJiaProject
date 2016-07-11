package com.dwz1676.tujiaproject.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class UnitBean {
//listView展现的内容
    /**
     * cityId : 10
     * cityName : 成都
     * defaultPicture : http://pic.tujia.com/upload/landlordunit/day_150817/thumb/201508171116349571_580_358.png
     * housetype : 酒店式公寓
     * isFavorite : false
     * pictures : ["http://pic.tujia.com/upload/landlordunit/day_150817/thumb/201508171116349571_580_358.png","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/201511171446342703_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/201511171446443292_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/201511171446596133_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/20151117144653709_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/201511171446484422_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/20151117144637203_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/201511171447046913_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_151117/thumb/201511171446339106_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_150818/thumb/201508181027276349_580_358.png","http://pic.tujia.com/upload/landlordunit/day_150818/thumb/201508181027412237_580_358.jpg","http://pic.tujia.com/upload/landlordunit/day_150818/thumb/201508181027407744_580_358.jpg"]
     * price : 422
     * unitId : 53267
     * unitName : 成都馨乐庭城南服务公寓行政单间
     */

    private String cityName;
    private String defaultPicture;
    private String housetype;
    private boolean isFavorite;
    private int price;
    private String unitName;
    private List<String> pictures;

    public UnitBean(String cityName, String defaultPicture, String housetype, boolean isFavorite, int price, String unitName, List<String> pictures) {
        this.cityName = cityName;
        this.defaultPicture = defaultPicture;
        this.housetype = housetype;
        this.isFavorite = isFavorite;
        this.price = price;
        this.unitName = unitName;
        this.pictures = pictures;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDefaultPicture() {
        return defaultPicture;
    }

    public void setDefaultPicture(String defaultPicture) {
        this.defaultPicture = defaultPicture;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
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

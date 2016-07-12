package com.dwz1676.tujiaproject.utils;

import android.util.Log;

import com.dwz1676.tujiaproject.bean.HotUnitsBean;
import com.dwz1676.tujiaproject.bean.UnitBean;
import com.dwz1676.tujiaproject.common.CommonData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public class ParseJaonDta {

    public static List getCharacterData(String type) {
//57810193e0f55a2914003ac1;appkey
        File file = new File(CommonData.JSONCACHE_DIR.concat("/character.txt"));
        Log.i("CLG",CommonData.JSONCACHE_DIR);
        if (!file.exists()) {
            HttpUtils22.downLoadFile(CommonData.CHARACTER,CommonData.JSONCACHE_DIR.concat("/character.txt"));
        }
        String strJson = new String(getJsonData());
        return parseDirect(strJson, type);
    }

    private static byte[] getJsonData() {
        byte[] fromSdcard = ExternalStorageUtil.readDataFromSdcard(CommonData.JSONCACHE_DIR, "character.txt");
        return fromSdcard;
    }

    private static List parseDirect(String str, String type) {
        try {
            JSONObject object = new JSONObject(str);
            JSONObject objectList = (JSONObject) object.getJSONObject("content").getJSONArray("list").get(0);
            switch (type) {

                case "title":
                    //获得导航栏项
                    JSONArray arrayCategories = objectList.getJSONArray("categories");
                    List<String> titles=new LinkedList<>();
                    for (int i = 0; i < arrayCategories.length(); i++) {
                        JSONObject objectTmp = (JSONObject) arrayCategories.get(i);
                        objectTmp.getString("label");//label="浪漫假期"
                        titles.add(objectTmp.getString("label"));
                    }
                    return titles;
                case "viewpager":
                    //hotUtils
                    List<HotUnitsBean> hotuits=new LinkedList<>();
                    JSONArray arrayHotUnits = objectList.getJSONArray("hotUnits");
                    for (int i = 0; i < arrayHotUnits.length(); i++) {
                        JSONObject objectTmp = (JSONObject) arrayHotUnits.get(i);
                        HotUnitsBean hotUnitsBean = new HotUnitsBean(
                                objectTmp.getString("defaultPicture"),//label="途家"label="雅诗阁"
                                objectTmp.getBoolean("isFavorite"),
                                objectTmp.getInt("price"),
                                objectTmp.getString("unitName"), null);
                        JSONArray pictures = objectTmp.getJSONArray("pictures");
                        List<String> pictureList = new LinkedList<>();
                        for (int index = 0; index < pictures.length(); index++) {
                            pictureList.add(pictures.getString(index));
                        }
                        hotUnitsBean.setPictures(pictureList);
                        hotuits.add(hotUnitsBean);
                    }
                    return hotuits;

                case "titleview":
                    //获取ListView头标签
                    JSONArray arraySubCategories = objectList.getJSONArray("subCategories");
                    List<String> subCategories = new LinkedList<>();
                    for (int index = 0; index < arraySubCategories.length(); index++) {
                        subCategories.add(arraySubCategories.getString(index));
                    }
                    return subCategories;

                case "listview":
                    //unit数据获得
                    JSONArray arrayUnits = objectList.getJSONArray("units");
                    List<UnitBean> units=new LinkedList<>();
                    for (int i = 0; i < arrayUnits.length(); i++) {
                        JSONObject objectTmp = (JSONObject) arrayUnits.get(i);
                        UnitBean unitsBean = new UnitBean(objectTmp.getString("cityName"),
                                objectTmp.getString("defaultPicture"),//label="途家"label="雅诗阁"
                                objectTmp.getString("housetype"),//label="途家"label="雅诗阁"
                                objectTmp.getBoolean("isFavorite"),
                                objectTmp.getInt("price"),
                                objectTmp.getString("unitName"), null);
                        JSONArray pictures = objectTmp.getJSONArray("pictures");
                        List<String> pictureList = new LinkedList<>();
                        for (int index = 0; index < pictures.length(); index++) {
                            pictureList.add(pictures.getString(index));
                        }
                        unitsBean.setPictures(pictureList);
                        units.add(unitsBean);
                    }
                    return units;
                default:
                    return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.dwz1676.tujiaproject.utils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;

/**
 * Created by Administrator on 2016/7/6.
 */
public class HttpUtils22 {
    public static void downLoadFile(String url,String fileName) {
//        String url = "http://119.39.253.33/10298486.s21d-10.faiusrd.com/0/ABUIABBEGAAg85ONvAUowO7NhgQ?f=moganshan1-2.txt&v=1468221939&wsiphost=ipdb";
        HttpUtils http = new HttpUtils();
        HttpHandler handler = http.download(url,fileName,
                true, // 如果目标文件存在，接着未完成的部分继续下载。服务器不支持RANGE时将从新下载。
//                true, // 如果从请求返回信息中获取到文件名，下载完成后自动重命名。
                new RequestCallBack<File>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                    }

                    @Override
                    public void onSuccess(ResponseInfo<File> responseInfo) {
                    }
                    @Override
                    public void onFailure(HttpException error, String msg) {
                    }
                });
//调用cancel()方法停止下载
//        handler.cancel();
    }
}

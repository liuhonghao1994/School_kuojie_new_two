package com.kuojie.school.school_kuojie.util;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.Map;

/**
 * Created by hjy on 2017/4/11 17:28.
 * 基于okhttputils二次封装的网络请求库
 */

public class HttpUtils {


    private static volatile OkHttpUtils mInstance;

    private HttpUtils() {
    }

    public static OkHttpUtils getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpUtils.class) {
                if (mInstance == null) {
                    mInstance = OkHttpUtils.getInstance();
                }
            }
        }
        return mInstance;
    }


    /**
     * 一般的Get请求
     *
     * @param url      网址
     * @param params   参数 key value形式
     * @param callBack 网络请求回调
     */
    public static void get(String url, Map<String, String> params, String Tag, ResponseCallBack<?> callBack) {
        OkHttpUtils.get()
                .url(url)
                .params(params)
                .build()
                .execute(callBack);
        LogUtils.i(Tag, url + "?" + params.toString());
    }

    /**
     * 一般的post请求
     *
     * @param url      网址
     * @param params   参数 key value形式
     * @param callBack 网络请求回调
     */
    public static void post(String url, Map<String, String> params, StringCallback callBack) {
        OkHttpUtils.post()
                .url(url)
                .params(params)
                .build()
                .execute(callBack);
    }

    /**
     * 下载文件
     *
     * @param url          下载地址
     * @param fileCallBack 下载文件的的回调
     */
    public static void downloadFile(String url, FileCallBack fileCallBack) {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(fileCallBack);
    }

    //上传多张图片
    public static void uploadFiles(String url, String fileKey, Map<String, File> files, Map<String, String> params, StringCallback stringCallback) {
        OkHttpUtils.post()
                .url(url)
                .files(fileKey, files)
                .params(params)
                .build()
                .execute(stringCallback);
        //
    }
    //上传单张图片

    public static void uploadSignFiles(String url, String fileKey, String fileName, File file, Map<String, String> params, StringCallback stringCallback) {
        OkHttpUtils.post()
                .url(url)
                .addFile(fileKey, fileName, file)
                .params(params)
                .build()
                .execute(stringCallback);
        //
    }

}

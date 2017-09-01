package com.kuojie.school.school_kuojie.util;

import android.content.Context;

/**
 * Created by 胡俊焰 on 2017/8/2.
 */

public class SharePreUtils {
    private static SharePreUtils instance;
    private static SchoolSharePre pre;

    private SharePreUtils(Context context) {
        pre = new SchoolSharePre(context);
//		pre = SchoolApplication.getSharedPreferences();
    }

    public static SharePreUtils getInstance(Context context) {
        if (instance == null) {
            instance = new SharePreUtils(context);
        }
        return instance;
    }

    //获取登陆的所有数据
    public static String getScholAreanName() {
        return pre.fetchString("schoolareaname");
    }

    //保存登陆的所有数据
    public static void setScholAreanName(String schoolAreaName) {
        pre.storeString("schoolareaname", schoolAreaName);
    }

    public static String getUserName() {
        return pre.fetchString("username");
    }

    //登录名
    public static void setUserName(String username) {
        pre.storeString("username", username);
    }

    public static String getPwd() {
        return pre.fetchString("password");
    }

    //保存密码
    public static void setPwd(String pwd) {
        pre.storeString("password", pwd);
    }

    //清除所有缓存数据
    public void deleteAllData() {
        pre.deleteSp();
    }
}

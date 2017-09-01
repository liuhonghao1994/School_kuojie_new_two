package com.kuojie.school.school_kuojie.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.kuojie.school.school_kuojie.application.MyApplication;

import java.util.Set;

/**
 * Created by 胡俊焰 on 2017/3/13.
 * 存储方法
 */


public class SchoolSharePre {
    public static final String ACCOUONTINFO = "account";
    /**
     * 登陆信息，用户名密码等
     */
    public static String LOGIN = "login";
    private Context ctx;
    private SharedPreferences spf;

    public SchoolSharePre(Context context) {
//        ctx = context;
        spf = context.getSharedPreferences("XYXschool", Context.MODE_PRIVATE);
//        spf = SchoolApplication.getSharePreferences();
    }

    /**
     * 将下载后文件的路径保存到SharedPrefence中.
     *
     * @param prevItemPosition 标记未处理页面是从哪一个item进入当前页面的
     * @param position         key为当前点击的item的位置.
     * @param filePath         value为文件下载后的位置.
     */
    public static void saveAttachFilePath(int prevItemPosition, int position, String filePath) {
        SharedPreferences spf = MyApplication.getSharePreferences();
        SharedPreferences.Editor edit = spf.edit();
        String key = String.valueOf(prevItemPosition) + "_" + String.valueOf(position);
        edit.putString(key, filePath);
        edit.commit();
    }

    /**
     * 通过点击的行政消息id来获取已下载文件的路径,如果未下载就返回空字符串.
     *
     * @param position
     * @return
     */
    public static String getDownloadFilePath(int prevItemPosition, int position) {
        String key = String.valueOf(prevItemPosition) + "_" + String.valueOf(position);
        return MyApplication.getSharePreferences().getString(key, "");
    }

    /**
     * 存储字符串
     *
     * @param key   关键字
     * @param value 储存的值
     */
    public void storeString(String key, String value) {
        SharedPreferences.Editor editor = spf.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void storeInt(String key, int value) {
        SharedPreferences.Editor editor = spf.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public String fetchString(String key) {
        return spf.getString(key, "");
    }

    public int fetchInt(String key) {
        return spf.getInt(key, -1);
    }

    public void storeBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = spf.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean fetchBoolean(String key) {
        return spf.getBoolean(key, false);
    }

    /**
     * @param key   customerId+userName+password
     * @param value 是否已经保存过此账号，false：未保存
     */
    public void setIsSaved(String key, boolean value) {
        SharedPreferences.Editor editor = spf.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * @param key customerId+userName+password
     * @return 账号是否保存过的状态，false：未保存
     */
    public boolean getIsSaved(String key) {
        return spf.getBoolean(key, false);
    }

    @SuppressLint("NewApi")
    public void storeSetString(String key, Set<String> set) {
        SharedPreferences.Editor editor = spf.edit();
        editor.putStringSet(key, set);
        editor.commit();
    }

    public Set<String> fetSetString(String key) {
        return spf.getStringSet(key, null);
    }

    /**
     * 清除所有的数据
     */
    public void deleteSp() {
        spf.edit().clear().commit();
    }

}

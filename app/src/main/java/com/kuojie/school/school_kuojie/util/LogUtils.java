package com.kuojie.school.school_kuojie.util;

import android.util.Log;

/**
 * Created by 胡俊焰 on 2017/3/16.
 */

public class LogUtils implements LogInterface {


    public static void d(String tag, String msg) {
        if (LogInterface.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LogInterface.WARN) {
            Log.w(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LogInterface.INFO) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LogInterface.ERROR) {
            Log.e(tag, msg);
        }
    }


}

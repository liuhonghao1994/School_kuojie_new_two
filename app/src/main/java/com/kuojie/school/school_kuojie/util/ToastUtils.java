package com.kuojie.school.school_kuojie.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 胡俊焰
 * on 2017/8/2.
 */
public class ToastUtils {

    public static void showToast(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}

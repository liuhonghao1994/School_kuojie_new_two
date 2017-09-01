package com.kuojie.school.school_kuojie.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.kuojie.school.school_kuojie.R;


/**
 * Created by hjy on 2017/8/02 15:28
 * 弹窗工具类
 */
public class AlertDialogUtils {

    public static void show(Context context, String title, String content, DialogInterface.OnClickListener mDialogInterface) {
        new AlertDialog.Builder(context, R.style.DialogTheme)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("否", null)
                .setNegativeButton("是", mDialogInterface)
                .show();

    }

    public static void show(String po, String ne, Context context, String title, String content, DialogInterface.OnClickListener mDialogInterface) {
        new AlertDialog.Builder(context, R.style.DialogTheme)
                .setTitle(title)
                .setCancelable(false)
                .setMessage(content)
                .setPositiveButton(ne, null)
                .setNegativeButton(po, mDialogInterface)
                .show();

    }


    public static void showLogin(Context context, String title, String content, DialogInterface.OnClickListener mDialogInterface) {
        new AlertDialog.Builder(context, R.style.DialogTheme)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("", null)
                .setNegativeButton("确定", mDialogInterface)
                .show();

    }

}

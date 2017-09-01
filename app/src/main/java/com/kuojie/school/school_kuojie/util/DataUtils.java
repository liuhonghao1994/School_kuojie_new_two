package com.kuojie.school.school_kuojie.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 胡俊焰 on 2017/3/20.
 */

public class DataUtils {

    //申请单号的生成
    public static String getBillNum() {
        Calendar nowtime = new GregorianCalendar();
        String strDateTime = String.format("%04d", nowtime.get(Calendar.YEAR)) +
                String.format("%02d", nowtime.get(Calendar.MONTH)) +
                String.format("%02d", nowtime.get(Calendar.DATE)) +
                String.format("%02d", nowtime.get(Calendar.HOUR)) +
                String.format("%02d", nowtime.get(Calendar.MINUTE)) +
                String.format("%02d", nowtime.get(Calendar.SECOND)) +
                String.format("%03d", nowtime.get(Calendar.MILLISECOND));

        return strDateTime;
    }

    /**
     * 将long型转化为string
     *
     * @return
     */
    public static String getStringFromLong(Long l) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        Long time=new Long(445555555);

        String d = format.format(l);

        return d;
    }

    public static String getStringFromLong(Long l, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);


        String d = sd.format(l);

        return d;
    }

    public static String getCurrentYMDTime() {
        // HH:mm:ss
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time;
    }


    public static String getCurrentHMTime() {
        // HH:mm:ss
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(date);
        return time;
    }

    public static String fromDateToString(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format.format(date);
        return time;

    }

    public static int getCurrentMonth() {
        Calendar CD = Calendar.getInstance();
//        int YY = CD.get(Calendar.YEAR) ;
        int MM = CD.get(Calendar.MONTH) + 1;
       /* int DD = CD.get(Calendar.DATE);
        int HH = CD.get(Calendar.HOUR);
        int NN = CD.get(Calendar.MINUTE);
        int SS = CD.get(Calendar.SECOND);
        int MI = CD.get(Calendar.MILLISECOND);*/
        return MM;
    }


    /**
     * 将时间戳转为代表"距现在多久之前"的字符串
     *
     * @param //时间戳
     * @return
     */
    public static String getStandardDate(long t) {

        StringBuffer sb = new StringBuffer();

//        long t = Long.parseLong(timeStr);
//        long time = System.currentTimeMillis() - (t*1000);
        long time = System.currentTimeMillis() - t;
        long mill = (long) Math.ceil(time / 1000);//秒前

        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 > 0) {
//            sb.append(day + "天");
            sb.append(DataUtils.getStringFromLong(t, "MM-dd HH:mm"));
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天前");
            } else {
                if (hour > 4) {
                    sb.append(DataUtils.getStringFromLong(t, "MM-dd HH:mm"));
                } else {
                    sb.append(hour + "小时前");
                }
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时前");
            } else {
                sb.append(minute + "分钟前");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟前");
            } else {
                sb.append(mill + "秒前");
            }
        } else {
            sb.append("刚刚");
        }
        /*if (!sb.toString().equals("刚刚")) {
            sb.append("");
        }*/
        return sb.toString();
    }


}

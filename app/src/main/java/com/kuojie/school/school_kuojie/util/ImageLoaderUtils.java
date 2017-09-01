package com.kuojie.school.school_kuojie.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.kuojie.school.school_kuojie.R;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by hy on 2017/8/2 15:50.
 * 加载图片的工具类
 */

public class ImageLoaderUtils {
    /**
     * 默认加载中显示的图片
     */
    private static final int DEFAULT_IMAGE = R.drawable.ic_launcher;
    /**
     * 默认加载失败时显示的图片
     */
    private static final int ERROR_IMAGE = R.drawable.ic_launcher;

    private static volatile ImageLoaderUtils loader;

    public ImageLoaderUtils() {
    }

    public static ImageLoaderUtils getInstance() {
        if (loader == null) {
            synchronized (ImageLoaderUtils.class) {
                if (loader == null) {
                    loader = new ImageLoaderUtils();
                }
            }
        }
        return loader;
    }

    /**
     * 加载网络图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载资源文件
     *
     * @param context
     * @param resID
     * @param imageView
     */
    public void loadImage(Context context, int resID, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载本地图片文件
     *
     * @param context
     * @param file
     * @param imageView
     */
    public void loadImage(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片
     * 注意:此处显示图片的控件为CircleImageView,需添加dontAnimate()方法,禁用动画,以避免弄乱图片.
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadWithCircleImageView(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .dontAnimate()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .into(imageView);
    }

    /**
     * 加载资源文件
     * 注意:此处显示图片的控件为CircleImageView,需添加dontAnimate()方法,禁用动画,以避免弄乱图片.
     *
     * @param context
     * @param resID
     * @param imageView
     */
    public void loadWithCircleImageView(Context context, int resID, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .dontAnimate()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .into(imageView);
    }

    /**
     * 加载本地图片文件
     * 注意:此处显示图片的控件为CircleImageView,需添加dontAnimate()方法,禁用动画,以避免弄乱图片.
     *
     * @param context
     * @param file
     * @param imageView
     */
    public void loadWithCircleImageView(Context context, File file, CircleImageView imageView) {
        Glide.with(context)
                .load(file)
                .dontAnimate()
                .placeholder(DEFAULT_IMAGE)
                .dontAnimate()
                .error(ERROR_IMAGE)
                .into(imageView);
    }

    /**
     * 加载本地图片文件
     * 注意:此处显示图片的控件为CircleImageView,需添加dontAnimate()方法,禁用动画,以避免弄乱图片.
     *
     * @param context
     * @param file
     * @param imageView
     */
    public void loadWithCircleImageView(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .dontAnimate()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .into(imageView);
    }

    /**
     * 加载网络图片
     * 支持缩略图.先加载缩略图,再加载全图
     * 适用于RecyclerView的Item中显示图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadImageWithThumbnail(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .thumbnail(0.1f)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载资源图片
     * 支持缩略图.先加载缩略图,再加载全图
     * 适用于RecyclerView的Item中显示图片
     *
     * @param context
     * @param resID
     * @param imageView
     */
    public void loadImageWithThumbnail(Context context, int resID, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .thumbnail(0.1f)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载本地图片文件
     * 支持缩略图.先加载缩略图,再加载全图
     * 适用于RecyclerView的Item中显示图片
     *
     * @param context
     * @param file
     * @param imageView
     */
    public void loadImageWithThumbnail(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .thumbnail(0.1f)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }


    /**
     * 加载网络图片,并设置图片的尺寸
     * 注意:此处的width,height的单位为px.
     *
     * @param context
     * @param url
     * @param width
     * @param height
     * @param imageView
     */
    public void loadImageWithSize(Context context, String url, int width, int height, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .override(width, height)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载资源图片,并设置图片的尺寸
     * 注意:此处的width,height的单位为px.
     *
     * @param context
     * @param resID
     * @param width
     * @param height
     * @param imageView
     */
    public void loadImageWithSize(Context context, int resID, int width, int height, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .override(width, height)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载本地图片文件,并设置图片的尺寸
     * 注意:此处的width,height的单位为px.
     *
     * @param context
     * @param file
     * @param width
     * @param height
     * @param imageView
     */
    public void loadImageWithSize(Context context, File file, int width, int height, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .override(width, height)
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络的静态gif图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadStaticGif(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .asBitmap()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .into(imageView);
    }

    /**
     * 加载网络的动态gif图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadDynamicGif(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .asGif()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载资源的动态gif图片
     *
     * @param context
     * @param resID
     * @param imageView
     */
    public void loadDynamicGif(Context context, int resID, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .asGif()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片,实现高斯模糊
     * <p>
     * 在app/build.gradle--android下--defaultConfig中添加如下两行代码
     * renderscriptTargetApi 23
     * renderscriptSupportModeEnabled true
     *
     * @param context
     * @param url
     * @param radius    取值范围1-25,值越大越模糊.
     * @param imageView
     */
    public void loadImageWithBlur(Context context, String url, int radius, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new BlurTransformation(context, radius))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }


    /**
     * 加载资源图片,实现高斯模糊
     * <p>
     * 在app/build.gradle--android下--defaultConfig中添加如下两行代码
     * renderscriptTargetApi 23
     * renderscriptSupportModeEnabled true
     *
     * @param context
     * @param resID
     * @param radius    取值范围1-25,值越大越模糊.
     * @param imageView
     */
    public void loadImageWithBlur(Context context, int resID, int radius, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .bitmapTransform(new BlurTransformation(context, radius))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载资源图片,实现高斯模糊
     * <p>
     * 在app/build.gradle--android下--defaultConfig中添加如下两行代码
     * renderscriptTargetApi 23
     * renderscriptSupportModeEnabled true
     *
     * @param context
     * @param drawable
     * @param radius    取值范围1-25,值越大越模糊.
     * @param imageView
     */
    public void loadImageWithBlur(Context context, Drawable drawable, int radius, ImageView imageView) {
        Glide.with(context)
                .load(drawable)
                .bitmapTransform(new BlurTransformation(context, radius))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载本地图片文件,实现高斯模糊
     * <p>
     * 在app/build.gradle--android下--defaultConfig中添加如下两行代码
     * renderscriptTargetApi 23
     * renderscriptSupportModeEnabled true
     *
     * @param context
     * @param file
     * @param radius    取值范围1-25,值越大越模糊.
     * @param imageView
     */
    public void loadImageWithBlur(Context context, File file, int radius, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .bitmapTransform(new BlurTransformation(context, radius))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片,图片为圆形
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new CropCircleTransformation(context))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片,图片为圆形
     *
     * @param context
     * @param url
     * @param imageView
     */
    public void loadCircleImage(Context context, String url, CircleImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new CropCircleTransformation(context))
                .dontAnimate()
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载资源图片,图片为圆形
     *
     * @param context
     * @param resID
     * @param imageView
     */
    public void loadCircleImage(Context context, int resID, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .bitmapTransform(new CropCircleTransformation(context))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载本地图片文件,图片为圆形
     *
     * @param context
     * @param file
     * @param imageView
     */
    public void loadCircleImage(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .bitmapTransform(new CropCircleTransformation(context))
                .placeholder(DEFAULT_IMAGE)
                .error(ERROR_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片,图片带有圆角
     *
     * @param context
     * @param url
     * @param radius
     * @param imageView
     */
    public void loadRoundImage(Context context, String url, int radius, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, radius, 0))
                .placeholder(DEFAULT_IMAGE)
                .error(DEFAULT_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片,图片带有圆角
     *
     * @param context
     * @param resID
     * @param radius
     * @param imageView
     */
    public void loadRoundImage(Context context, int resID, int radius, ImageView imageView) {
        Glide.with(context)
                .load(resID)
                .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, radius, 0))
                .placeholder(DEFAULT_IMAGE)
                .error(DEFAULT_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }

    /**
     * 加载网络图片,图片带有圆角
     *
     * @param context
     * @param file
     * @param radius    圆角弧度
     * @param imageView
     */
    public void loadRoundImage(Context context, File file, int radius, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, radius, 0))
                .placeholder(DEFAULT_IMAGE)
                .error(DEFAULT_IMAGE)
                .crossFade()    //占位符图片与网络请求的图片之间的切换有一种淡入淡出的效果,使图片切换更加平滑和自然
                .into(imageView);
    }
}

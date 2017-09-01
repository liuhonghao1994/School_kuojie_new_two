package com.kuojie.school.school_kuojie.util;

import android.content.Context;

import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hjy on 2017/4/11 18:19.
 * 通用的请求回调
 * 泛型 T 传入将要解析的数据Bean即可
 */

public abstract class ResponseCallBack<T> extends Callback<T> {

    private Context mContext;
    private String mMsg;
    /**
     * json泛型序列化帮助类
     */
    private IGenericsSerializator mGenericsSerializator;

    /**
     * @param context 上下文，供显示加载对话框使用。不能传入Application的Context。
     * @param
     */
    public ResponseCallBack(Context context) {
        this.mContext = context;
//        this.mMsg = msg;
        this.mGenericsSerializator = new JsonParse();
    }

    /**
     * 请求网络之前
     *
     * @param request
     * @param id
     */
    @Override
    public void onBefore(Request request, int id) {

    }

    /**
     * 请求网络结束后
     *
     * @param id
     */
    @Override
    public void onAfter(int id) {

    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String json = response.body().string();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) json;
        }
        T bean = mGenericsSerializator.transform(json, entityClass);
        return bean;
    }
}

package com.kuojie.school.school_kuojie.util;


import com.alibaba.fastjson.JSON;

/**
 * Created by hjy on 2017/4/12 15:50.
 * Json泛型序列化
 */

public class JsonParse implements IGenericsSerializator {
    public static JsonParse getInstances() {
        JsonParse json = new JsonParse();
        if (json == null) {
            json = new JsonParse();
        }
        return json;
    }

    @Override
    public <T> T transform(String response, Class<T> classOfT) {

        return JSON.parseObject(response, classOfT);
    }

    public <T> T parseJson(String json, Class<T> classoft) {

        return JSON.parseObject(json, classoft);

    }
}

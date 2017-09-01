package com.kuojie.school.school_kuojie.util;

/**
 * Created by gys on 2017/4/12 15:59.
 */

public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}

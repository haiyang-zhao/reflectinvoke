package com.zhy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class TestParameterizedType {
    Map<String, Integer> map;

    public static void main(String[] args) throws Exception {
        Field f = TestParameterizedType.class.getDeclaredField("map");
        System.out.println("getGenericType : " + f.getGenericType());
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        System.out.println("pType : " + pType.getRawType());
        for (Type type : pType.getActualTypeArguments()) {
            System.out.println(type);
        }
    }
}

package com.zhy.reflect;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TestTypeVariable<K extends Comparable & Serializable, V> {
    K key;
    V value;

    public static void main(String[] args) throws Exception {
        Field fk = TestTypeVariable.class.getDeclaredField("key");
        Field fv = TestTypeVariable.class.getDeclaredField("value");
        TypeVariable keyType = (TypeVariable) fk.getGenericType();
        TypeVariable valueType = (TypeVariable) fv.getGenericType();
        System.out.println(keyType.getName());
        System.out.println(valueType.getName());
        System.out.println(keyType.getGenericDeclaration());
        System.out.println(valueType.getGenericDeclaration());
        System.out.println("K的上界:");
        for (Type type : keyType.getBounds()) {
            System.out.println(type);
        }
        System.out.println("V的上界:");
        for (Type type : valueType.getBounds()) {
            System.out.println(type);
        }
    }
}

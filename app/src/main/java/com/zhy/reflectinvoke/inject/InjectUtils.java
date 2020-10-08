package com.zhy.reflectinvoke.inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import java.lang.reflect.Field;

public class InjectUtils {


    public static void injectView(Activity activity) {
        Class<? extends Activity> cls = activity.getClass();
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(BindView.class)) {
                try {
                    BindView bindView = field.getAnnotation(BindView.class);
                    assert bindView != null;
                    View view = activity.findViewById(bindView.value());
                    //设置访问权限，允许访问private变量
                    field.setAccessible(true);
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void injectAutowired(Activity activity) {
        Intent intent = activity.getIntent();
        if (null == intent) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (null == extras) {
            return;
        }
        Class<? extends Activity> cls = activity.getClass();
        //获取所有成员
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Autowired autowired = field.getAnnotation(Autowired.class);
                String key = TextUtils.isEmpty(autowired.value()) ? field.getName() :
                        autowired.value();
                if (extras.containsKey(key)) {
                    Object object = extras.get(key);
                    // todo Parcelable数组类型不能直接设置，其他的都可以.
                    // 获得数组单个元素类型
                    field.getType().getComponentType()
                }
            }
        }
    }
}

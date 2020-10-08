package com.zhy.reflectinvoke.intdef;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.zhy.reflectinvoke.intdef.UerType.STUDENT;
import static com.zhy.reflectinvoke.intdef.UerType.TEACHER;


@IntDef({STUDENT, TEACHER})
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.SOURCE)
public @interface UerType {
    int STUDENT =0;
    int TEACHER = 1;
}

class Test{
    public void test(@UerType int userType){

    }

    public static void main(String[] args) {
        new Test().test(1);
    }
}
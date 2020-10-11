package com.zhy.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * WildcardType
 * 该接口表示通配符泛型, 比如? extends Number 和 ? super Integer 它有如下方法:
 * <p>
 * Type[] getUpperBounds(): 获取范型变量的上界
 * Type[] getLowerBounds(): 获取范型变量的下界
 * 注意:
 * <p>
 * 现阶段通配符只接受一个上边界或下边界, 返回数组是为了以后的扩展, 实际上现在返回的数组的大小是1
 */
public class TestWildcardType {
    private List<? extends Number> a;//上限
    private List<? super String> b;//下限
    public static void main(String[] args) throws Exception {
        Field fA = TestWildcardType.class.getDeclaredField("a");
        Field fB = TestWildcardType.class.getDeclaredField("b");
        ParameterizedType pTypeA = (ParameterizedType) fA.getGenericType();
        ParameterizedType pTypeB = (ParameterizedType) fB.getGenericType();
        System.out.println("ParameterizedType a is " + pTypeA);
        System.out.println("ParameterizedType b is " + pTypeB);
        // 再从范型里拿到通配符类型
        WildcardType wTypeA = (WildcardType) pTypeA.getActualTypeArguments()[0];
        WildcardType wTypeB = (WildcardType) pTypeB.getActualTypeArguments()[0];
        System.out.println("WildcardTypeA getUpperBounds is" + wTypeA.getUpperBounds()[0]);   // class java.lang.Number
        System.out.println("WildcardTypeB getLowerBounds is" + wTypeB.getLowerBounds()[0]);   // class java.lang.Number
        System.out.println("WildcardTypeA is " + wTypeA);
        System.out.println("WildcardTypeB is " + wTypeB);
    }
}

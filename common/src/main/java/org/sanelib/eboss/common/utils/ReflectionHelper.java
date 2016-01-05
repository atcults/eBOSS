package org.sanelib.eboss.common.utils;

import java.lang.reflect.Field;

public class ReflectionHelper {

    public static <T1, T2>  void copy(T1 src, T2 dest) throws IllegalAccessException, NoSuchFieldException {

        Class<?> srcClass = src.getClass();
        Class<?> destClass = dest.getClass();

        Field[] fromFields = srcClass.getDeclaredFields();

        for (Field srcField : fromFields){
            srcField.setAccessible(true);
            Object value = srcField.get(src);
            Field destField = destClass.getDeclaredField(srcField.getName());
            destField.setAccessible(true);
            destField.set(dest, value);
        }
    }
}

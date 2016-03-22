package com.google.gwtmockito.lienzo.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StubUtils {

    public static void invoke(Object stubObject, String methodName) {
        try {
            Method method = stubObject.getClass().getMethod(methodName);
            method.invoke(stubObject);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
}

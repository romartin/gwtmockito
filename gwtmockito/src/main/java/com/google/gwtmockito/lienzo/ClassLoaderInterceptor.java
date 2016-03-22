package com.google.gwtmockito.lienzo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;

public interface ClassLoaderInterceptor {

    Class<?> findClass(ClassPool pool, String name) throws ClassNotFoundException;
        
    boolean intercept(final ClassPool pool, final String name) throws NotFoundException, CannotCompileException;
        
}

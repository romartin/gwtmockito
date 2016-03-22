package com.google.gwtmockito.lienzo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.Collection;

public interface ClassLoaderInterceptor {

    Collection<Class<?>> getClassesToStub();

    Class<?> findClass(ClassPool pool, String name) throws ClassNotFoundException;
        
    boolean intercept(final ClassPool pool, final String name) throws NotFoundException, CannotCompileException;
        
}

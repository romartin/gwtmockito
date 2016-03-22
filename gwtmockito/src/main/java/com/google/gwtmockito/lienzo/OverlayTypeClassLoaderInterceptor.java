package com.google.gwtmockito.lienzo;

import com.ait.lienzo.client.core.types.Transform;
import com.ait.tooling.nativetools.client.NArrayBaseJSO;
import com.ait.tooling.nativetools.client.NObjectBaseJSO;
import com.ait.tooling.nativetools.client.NObjectJSO;
import com.ait.tooling.nativetools.client.collection.NFastArrayList;
import com.ait.tooling.nativetools.client.collection.NFastStringMap;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OverlayTypeClassLoaderInterceptor implements ClassLoaderInterceptor {
   
    private static final Map<String, String> OVERLAY_CLASS_TRANSLATIONS = new HashMap<String, String>() {{
        put("com.ait.lienzo.client.core.types.Transform$TransformJSO", "com.google.gwtmockito.lienzo.stub.TransformJSO");
        put("com.ait.tooling.nativetools.client.NObjectJSO", "com.google.gwtmockito.lienzo.stub.NObjectJSO");
    }};
    
    @Override
    public Collection<Class<?>> getClassesToStub() {
        return new ArrayList<Class<?>>() {{
            add(NObjectBaseJSO.class);
            add(NObjectJSO.class);
            add(Transform.TransformJSO.class);
            add(NArrayBaseJSO.class);
            add(NFastArrayList.class);
            add(NFastStringMap.class);
        }};
    }

    @Override
    public Class<?> findClass(ClassPool pool, String name) throws ClassNotFoundException {

        String translationClass = OVERLAY_CLASS_TRANSLATIONS.get(name);
        
        if ( translationClass != null && translationClass.trim().length() > 0 ) {

            try {


                CtClass ctClass = pool.getCtClass(name);
                if ( ctClass.isFrozen() ) {
                    ctClass.defrost();
                }
                CtClass cc = pool.getAndRename(translationClass, name);

                if ( null != cc ) {
                    return cc.toClass();
                }

            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            } catch (CannotCompileException e) {
                throw new RuntimeException(e);
            }
            
        }
        
        return null;
    }

    @Override
    public boolean intercept(ClassPool pool, String name) throws NotFoundException, CannotCompileException {
        // Class renamed, let parent loader do the job.
        return false;
    }

    private boolean isOverlayType(ClassPool pool, CtClass clazz) throws NotFoundException, CannotCompileException {
        if ( null == clazz ) {
            return false;
        }

        String name = clazz.getName();
        while ( name != null && !"java.lang.Object".equals(name) && !"com.google.gwt.core.client.JavaScriptObject".equals(name) ) {
            clazz = clazz.getSuperclass();
            name = clazz.getName();
        }

        return name != null && "com.google.gwt.core.client.JavaScriptObject".equals(name);
    }
    
}

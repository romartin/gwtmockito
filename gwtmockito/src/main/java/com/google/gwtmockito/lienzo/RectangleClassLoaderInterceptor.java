package com.google.gwtmockito.lienzo;

import javassist.*;

public class RectangleClassLoaderInterceptor implements ClassLoaderInterceptor {
   
    private static final String RECTANGLE_CLASS_NAME = "com.ait.lienzo.client.core.shape.Rectangle";
    
    @Override
    public Class<?> findClass(ClassPool pool, String name) throws ClassNotFoundException {
        // Let parent loader do the job.
        return null;
    }

    @Override
    public boolean intercept(ClassPool pool, String name) throws NotFoundException, CannotCompileException {
        
        if ( RECTANGLE_CLASS_NAME.equals(name) ) {
            CtClass clazz = pool.get(name);

            CtMethod m = CtNewMethod.make(
                    "public void doAMethodAddTest() {\n" +
                            "        System.out.println(\"Do a method add test\");\n" +
                            "    }",
                    clazz);
            
            clazz.addMethod(m);
            
            // Intercept class loading. Avoid parent's job..
            return true;
        }

        // Let parent loader do the job.
        return false;
    }

}

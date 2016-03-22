package com.google.gwtmockito.lienzo;

import com.ait.lienzo.client.core.shape.ContainerNode;
import com.ait.lienzo.client.core.shape.Layer;
import com.ait.lienzo.client.core.shape.Node;
import com.google.gwt.user.client.ui.RootPanel;
import javassist.*;

import java.util.ArrayList;
import java.util.Collection;

public class NodeClassLoaderInterceptor implements ClassLoaderInterceptor {
   
    @Override
    public Collection<Class<?>> getClassesToStub() {
        return new ArrayList<Class<?>>() {{
            add(Node.class);
        }};
    }

    @Override
    public Class<?> findClass(ClassPool pool, String name) throws ClassNotFoundException {
        // Let parent loader do the job.
        return null;
    }

    @Override
    public boolean intercept(ClassPool pool, String name) throws NotFoundException, CannotCompileException {
        
        if ( "com.ait.lienzo.client.core.shape.Node".equals(name) ) {
            CtClass clazz = pool.get(name);
            for (CtMethod method : clazz.getMethods()) {
                boolean isShadeMethod = isCastMethod(method.getName());
                if (isShadeMethod) {
                    method.setModifiers(method.getModifiers() & ~Modifier.FINAL);
                    method.setBody(String.format("{ return (%s) $0; }", clazz.getName()));
                }
            }

            // Intercept class loading. Avoid parent's job..
            return true;
        }

        // Let parent loader do the job.
        return false;
    }

    private boolean isCastMethod(String name) {
        return "shade".equals(name) || "cast".equals(name);
    }

}

package com.google.gwtmockito.lienzo;

import com.ait.lienzo.client.core.shape.ContainerNode;
import com.ait.lienzo.client.core.shape.Layer;
import com.ait.lienzo.client.core.shape.Node;
import com.ait.lienzo.client.core.shape.Shape;
import com.ait.lienzo.client.core.types.Transform;
import com.ait.tooling.nativetools.client.NArrayBaseJSO;
import com.ait.tooling.nativetools.client.NObjectBaseJSO;
import com.ait.tooling.nativetools.client.NObjectJSO;
import com.ait.tooling.nativetools.client.collection.NFastArrayList;
import com.ait.tooling.nativetools.client.collection.NFastStringMap;
import com.google.gwt.user.client.ui.RootPanel;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class GenericClassLoaderInterceptor implements ClassLoaderInterceptor {
   
    @Override
    public Collection<Class<?>> getClassesToStub() {
        return new ArrayList<Class<?>>() {{
            add(Layer.class);
            add(ContainerNode.class);
            add(RootPanel.class);
            // add(Node.class);
            // add(Shape.class);
        }};
    }

    @Override
    public Class<?> findClass(ClassPool pool, String name) throws ClassNotFoundException {
        // Let parent loader do the job.
        return null;
    }

    @Override
    public boolean intercept(ClassPool pool, String name) throws NotFoundException, CannotCompileException {
        // Let parent loader do the job.
        return false;
    }

}

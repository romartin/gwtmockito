package com.google.gwtmockito.lienzo.stub;

import com.ait.lienzo.client.core.types.Point2D;
import com.google.gwt.core.client.JavaScriptObject;

public class TransformJSO extends JavaScriptObject
{
    protected TransformJSO()
    {
        System.out.println("Creating a custom Lienzo overlay type for [TransformJSO]");
    }

    public static final TransformJSO make() {
        return new TransformJSO();
    }
    
    public static final TransformJSO make(double x, double y) {
        return new TransformJSO();
    }

    public static final  TransformJSO make(double m00, double m10, double m01, double m11, double m02, double m12)
    {
        return new TransformJSO();
    };

    public final void reset() {
        
    }

    public final void translate(double x, double y) {
        
    }

    public final boolean same(TransformJSO that) {
        return false;
    }

    public final boolean isIdentity() {
        return false;
    }

    public final TransformJSO copy() {
        return this;
    }

    public final void scale(double sx, double sy) {
        
    }
        
    public final void shear(double shx, double shy) {
        
    }

    public final void rotate(double rad) {
        
    }

    public final void multiply(TransformJSO transform) {
        
    }

    public final double getDeterminant() {
        return 0d;
    }

    public final TransformJSO getInverse() {
        return this;
    }
    
    public final double get(int i) {
        return 0d;
    }

    public final void transform(Point2D.Point2DJSO src, Point2D.Point2DJSO target) {
        
    }

}
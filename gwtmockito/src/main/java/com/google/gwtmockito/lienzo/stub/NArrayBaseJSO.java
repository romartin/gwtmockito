package com.google.gwtmockito.lienzo.stub;

import com.ait.tooling.common.api.json.JSONType;
import com.ait.tooling.nativetools.client.NJSONReplacer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;

import java.util.ArrayList;

public class NArrayBaseJSO <T extends NArrayBaseJSO<T>> extends JavaScriptObject
{
    protected static final <T extends NArrayBaseJSO<T>> T createNArrayBaseJSO()
    {
        return null;
    }
    
    protected NArrayBaseJSO()
    {
        System.out.println("Creating a custom Lienzo overlay type for [NArrayBaseJSO]");
    }

    public final JSONArray toJSONArray()
    {
        return new JSONArray(this);
    }

    public final String toJSONString()
    {
        return toString();
    }

    public final String toJSONString(final NJSONReplacer replacer)
    {
        return toString();
    }

    public final String toJSONString(final String indent)
    {
        return toString();
    }

    public final String toJSONString(final NJSONReplacer replacer, final String indent)
    {
        return toString();
    }

    public final String toJSONString(final int indent)
    {
        return toString();
    }

    public final String toJSONString(final NJSONReplacer replacer, final int indent)
    {
        return toString();
    }

    public final void clear()
    {
        setSize(0);
    }

    public final String join()
    {
        return join(",");
    }

    public final JSONType getNativeTypeOf(final int index)
    {
        return null;
    }

    public final boolean isNull(final int index)
    {
        if ((index < 0) || (index >= size()))
        {
            return true;
        }
        return isNull_0(index);
    }

    public final boolean isDefined(final int index)
    {
        if ((index < 0) || (index >= size()))
        {
            return false;
        }
        return isDefined_0(index);
    }

    public final boolean isEmpty() {
        return false;
    }
    
    public final int size() {
        return 0;
    }

    public final  void setSize(int size) {
        
    }

    public final void splice(int beg, int removed) {
        
    }

    public final void reverse() {
        
    }
            
    public final String join(String separator) {
        return null;
    }

    public final T concat(T value) {
        return null;
    }

    public final T copy() {
        return (T) this;
    }

    public final T slice(int beg) {
        return (T) this;
    }

    public final T slice(int beg, int end) {
        return (T) this;
    }

    private final boolean isNull_0(int index) {
        return false;
    }

    private final boolean isDefined_0(int index) {
        return false;
    }
}

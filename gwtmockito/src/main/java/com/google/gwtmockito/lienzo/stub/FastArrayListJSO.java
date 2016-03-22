package com.google.gwtmockito.lienzo.stub;

import java.util.ArrayList;
import com.ait.tooling.nativetools.client.NArrayBaseJSO;

public class FastArrayListJSO <M> extends NArrayBaseJSO<FastArrayListJSO<M>>
{
    
    private final ArrayList<M> list = new ArrayList<M>();
    
    protected FastArrayListJSO()
    {
        System.out.println("Creating a custom Lienzo overlay type for [FastArrayListJSO]");
    }

    public static final <M> FastArrayListJSO<M> make()
    {
        return new FastArrayListJSO<M>();
    }

    final M get(int indx) {
        return list.get(indx);
    }

    final void add(M value) {
        list.add(value);
    }

    final void set(int i, M value) {
        list.set(i ,value);
    }

    final boolean contains(M value) {
        return list.contains(value);
    }
    
    final void remove(M value) {
        list.remove(value);
    }

    final void moveUp(M value) {
         // TODO
    }

    final void moveDown(M value) {
        // TODO
    }

    final void unshift(M value) {   
        // TODO
    }
    
    final void splice(int beg, int removed, M value) {
        // TODO
    }
    
    final M shift() {
        return list.listIterator(1).next();
    }

    final M pop() {
        if ( !list.isEmpty() ) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    final void push(M value) {
        list.add(value);
    }

}
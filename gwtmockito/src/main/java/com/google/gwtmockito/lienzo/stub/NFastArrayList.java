package com.google.gwtmockito.lienzo.stub;

import com.ait.tooling.nativetools.client.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NFastArrayList <M> implements Iterable<M>
{

    private static final class FastArrayListJSO<M> extends com.ait.tooling.nativetools.client.NArrayBaseJSO<FastArrayListJSO<M>> {
        
    }
    
    private final ArrayList<M> list = new ArrayList<M>();

    public NFastArrayList()
    {
        System.out.println("Creating a custom Lienzo overlay type for [NFastArrayList]");
    }

    @SuppressWarnings("unchecked")
    public NFastArrayList(final M value, final M... values)
    {
        this();

        add(value);

        if ((null != values) && (values.length > 0))
        {
            for (int i = 0; i < values.length; i++)
            {
                add(values[i]);
            }
        }
    }

    private NFastArrayList(final FastArrayListJSO<M> jso)
    {
        this();
    }

    public final boolean isEmpty()
    {
        return list.isEmpty();
    }

    /**
     * Return the List's size.
     * @return int
     */
    public final int size()
    {
        return list.size();
    }

    /**
     * Return the primitive found at the specified index.
     * @param index
     * @return
     */
    public final M get(final int index)
    {
        if ((index >= 0) && (index < size()))
        {
            return list.get(index);
        }
        return null;
    }

    /**
     * Add a value to the List
     * @param value
     */
    public final NFastArrayList<M> add(final M value)
    {
        list.add(value);

        return this;
    }

    /**
     * Add a value to the List
     * @param value
     */
    public final NFastArrayList<M> set(final int i, final M value)
    {
        list.set(i, value);

        return this;
    }

    /**
     * Return true if the List contains the passed in value.
     *
     * @param value
     * @return boolean
     */
    public final boolean contains(final M value)
    {
        return list.contains(value);
    }

    /**
     * Clear all values from the List.
     */
    public final NFastArrayList<M> clear()
    {
        list.clear();

        return this;
    }

    /**
     * Remove the value passed in as argument from the List.
     * @param value
     */
    public final NFastArrayList<M> remove(final M value)
    {
        list.remove(value);

        return this;
    }

    public final NFastArrayList<M> unshift(final M value)
    {
         // TOD

        return this;
    }

    public final NFastArrayList<M> moveUp(final M value)
    {
        // TOD

        return this;
    }

    public final NFastArrayList<M> moveDown(final M value)
    {
        // TOD

        return this;
    }

    public final NFastArrayList<M> moveToTop(final M value)
    {
        if ((size() < 2) || (false == contains(value)))
        {
            return this;
        }
        remove(value);

        add(value);

        return this;
    }

    public final NFastArrayList<M> moveToBottom(final M value)
    {
        if ((size() < 2) || (false == contains(value)))
        {
            return this;
        }
        remove(value);

        unshift(value);

        return this;
    }

    public final M pop()
    {
        if ( !list.isEmpty() ) {
            return list.get(list.size() - 1);
        }
        
        return null;
    }

    public final M shift()
    {
        // TODO
        return pop();
    }

    public final NFastArrayList<M> splice(final int beg, final int removed, final M value)
    {
        // TODO

        return this;
    }

    public final NFastArrayList<M> splice(final int beg, final int removed)
    {
        // TODO

        return this;
    }

    public final NFastArrayList<M> reverse()
    {
        // TODO

        return this;
    }

    @SuppressWarnings("unchecked")
    public final NFastArrayList<M> push(final M v, final M... values)
    {
        add(v);

        for (int i = 0; i < values.length; i++)
        {
            add(values[i]);
        }
        return this;
    }

    public final NFastArrayList<M> copy()
    {
        NFastArrayList result = new NFastArrayList<M>();
        result.list.addAll(this.list);
        return result;
    }

    public final NFastArrayList<M> concat(final NFastArrayList<M> value)
    {
        NFastArrayList result = copy();

        if ( null != value) {
            result.list.addAll(value.list);
            return copy();
        }
        
        return result;
    }

    public final NFastArrayList<M> slice(final int beg)
    {
        // TODO
        return copy();
    }

    public final NFastArrayList<M> slice(final int beg, final int end)
    {
        // TODO
        return copy();
    }

    public final List<M> toList()
    {
        final int size = size();

        final ArrayList<M> list = new ArrayList<M>(size);

        for (int i = 0; i < size; i++)
        {
            list.add(get(i));
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public final Iterator<M> iterator()
    {
        return toList().iterator();
    }

}

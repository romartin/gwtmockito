package com.google.gwtmockito.lienzo.stub;

import com.ait.tooling.nativetools.client.NUtils;

import java.util.*;

public class NFastStringMap <V>
{

    private final Map<String, V> map = new HashMap<String, V>();
    
    public NFastStringMap()
    {
        System.out.println("Creating a custom Lienzo overlay type for [NFastStringMap]");
    }

    /**
     * Add <key, value> to the map.
     * @param key
     * @param value
     */
    public final NFastStringMap<V> put(final String key, final V value)
    {
        map.put(NUtils.doKeyRepair(key), value);

        return this;
    }

    /**
     * Get the value based on the key passed in.
     * @param key
     * @return
     */
    public final V get(final String key)
    {
        return map.get(NUtils.doKeyRepair(key));
    }

    /**
     * Remove the value based on the key passed in as argument.
     * @param key
     */
    public final NFastStringMap<V> remove(final String key)
    {
        map.remove(key);

        return this;
    }

    /**
     * Returns true if the map has a value for the specified key
     * @param key
     */
    public final boolean isDefined(final String key)
    {
        return map.containsKey(key);
    }

    public final boolean isNull(final String key)
    {
        return map.get(key) == null;
    }

    /**
     * Returns the number of key-value mappings in this map
     */
    public final int size()
    {
        return map.size();
    }

    public final NFastStringMap<V> clear()
    {
        map.clear();

        return this;
    }

    public final Collection<String> keys()
    {
        return map.keySet();
    }

    public final Collection<V> values()
    {
        final ArrayList<V> list = new ArrayList<V>(map.values());
        return Collections.unmodifiableList(list);
    }

    /**
     * Returns true if this map contains no key-value mappings
     */
    public final boolean isEmpty()
    {
        return map.isEmpty();
    }

}

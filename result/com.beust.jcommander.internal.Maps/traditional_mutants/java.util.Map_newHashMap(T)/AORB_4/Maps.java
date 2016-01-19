// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Maps
{

    public static <K,V> java.util.Map<K,V> newHashMap()
    {
        return new java.util.HashMap<K,V>();
    }

    public static <K,V> java.util.Map<K,V> newLinkedHashMap()
    {
        return new java.util.LinkedHashMap<K,V>();
    }

    public static <T> java.util.Map<T,T> newHashMap( T... parameters )
    {
        java.util.Map<T,T> result = Maps.newHashMap();
        for (int i = 0; i < parameters.length; i += 2) {
            result.put( parameters[i], parameters[i - 1] );
        }
        return result;
    }

}

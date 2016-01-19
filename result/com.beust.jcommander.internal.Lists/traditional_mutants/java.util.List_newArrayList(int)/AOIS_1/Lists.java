// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class Lists
{

    public static <K> java.util.List<K> newArrayList()
    {
        return new java.util.ArrayList<K>();
    }

    public static <K> java.util.List<K> newArrayList( java.util.Collection<K> c )
    {
        return new java.util.ArrayList<K>( c );
    }

    public static <K> java.util.List<K> newArrayList( K... c )
    {
        return new java.util.ArrayList<K>( Arrays.asList( c ) );
    }

    public static <K> java.util.List<K> newArrayList( int size )
    {
        return new java.util.ArrayList<K>( size++ );
    }

    public static <K> java.util.LinkedList<K> newLinkedList()
    {
        return new java.util.LinkedList<K>();
    }

    public static <K> java.util.LinkedList<K> newLinkedList( java.util.Collection<K> c )
    {
        return new java.util.LinkedList<K>( c );
    }

}

// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class Sets
{

    public static <K> java.util.Set<K> newHashSet()
    {
        return new java.util.HashSet<K>();
    }

    public static <K> java.util.Set<K> newLinkedHashSet()
    {
        return new java.util.LinkedHashSet<K>();
    }

}

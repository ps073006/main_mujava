// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


import com.beust.jcommander.FuzzyMap.IKey;


public class StringKey implements com.beust.jcommander.FuzzyMap.IKey
{

    private java.lang.String m_name;

    public StringKey( java.lang.String name )
    {
        m_name = name;
    }

    public  java.lang.String getName()
    {
        return m_name;
    }

    public  java.lang.String toString()
    {
        return m_name;
    }

    public  int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (m_name == null ? 0 : m_name.hashCode());
        return result;
    }

    public  boolean equals( java.lang.Object obj )
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(getClass() != obj.getClass())) {
            return false;
        }
        com.beust.jcommander.StringKey other = (com.beust.jcommander.StringKey) obj;
        if (m_name == null) {
            if (other.m_name != null) {
                return false;
            }
        } else {
            if (!m_name.equals( other.m_name )) {
                return false;
            }
        }
        return true;
    }

}

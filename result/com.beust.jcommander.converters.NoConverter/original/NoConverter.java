// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.IStringConverter;


public class NoConverter implements com.beust.jcommander.IStringConverter<String>
{

    public  java.lang.String convert( java.lang.String value )
    {
        throw new java.lang.UnsupportedOperationException();
    }

}

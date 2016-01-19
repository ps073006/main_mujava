// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.IStringConverter;
import java.io.File;


public class FileConverter implements com.beust.jcommander.IStringConverter<File>
{

    public  java.io.File convert( java.lang.String value )
    {
        return new java.io.File( value );
    }

}

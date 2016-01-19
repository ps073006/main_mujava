// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import java.util.Arrays;
import java.util.List;


public class CommaParameterSplitter implements com.beust.jcommander.converters.IParameterSplitter
{

    public  java.util.List<String> split( java.lang.String value )
    {
        return Arrays.asList( value.split( "," ) );
    }

}

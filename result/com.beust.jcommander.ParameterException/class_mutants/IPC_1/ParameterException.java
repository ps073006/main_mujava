// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


public class ParameterException extends java.lang.RuntimeException
{

    public ParameterException( java.lang.Throwable t )
    {
        // super( t );

    }

    public ParameterException( java.lang.String string )
    {
        super( string );
    }

}

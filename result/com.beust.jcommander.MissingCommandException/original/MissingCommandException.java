// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


public class MissingCommandException extends com.beust.jcommander.ParameterException
{

    public MissingCommandException( java.lang.String string )
    {
        super( string );
    }

    public MissingCommandException( java.lang.Throwable t )
    {
        super( t );
    }

}

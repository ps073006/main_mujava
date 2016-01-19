// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;


public class LongConverter extends com.beust.jcommander.converters.BaseConverter<Long>
{

    public LongConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.lang.Long convert( java.lang.String value )
    {
        try {
            return Long.parseLong( value );
        } catch ( java.lang.NumberFormatException ex ) {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, "a long" ) );
        }
    }

}

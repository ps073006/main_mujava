// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;


public class IntegerConverter extends com.beust.jcommander.converters.BaseConverter<Integer>
{

    public IntegerConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.lang.Integer convert( java.lang.String value )
    {
        try {
            return Integer.parseInt( value );
        } catch ( java.lang.NumberFormatException ex ) {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, "an integer" ) );
        }
    }

}

// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;


public class DoubleConverter extends com.beust.jcommander.converters.BaseConverter<Double>
{

    public DoubleConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.lang.Double convert( java.lang.String value )
    {
        try {
            return Double.parseDouble( value );
        } catch ( java.lang.NumberFormatException ex ) {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, "a double" ) );
        }
    }

}

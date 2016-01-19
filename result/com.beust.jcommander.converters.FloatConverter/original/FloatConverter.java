// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;


public class FloatConverter extends com.beust.jcommander.converters.BaseConverter<Float>
{

    public FloatConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.lang.Float convert( java.lang.String value )
    {
        try {
            return Float.parseFloat( value );
        } catch ( java.lang.NumberFormatException ex ) {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, "a float" ) );
        }
    }

}

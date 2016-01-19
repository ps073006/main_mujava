// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;


public class BooleanConverter extends com.beust.jcommander.converters.BaseConverter<Boolean>
{

    public BooleanConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.lang.Boolean convert( java.lang.String value )
    {
        if ("false".equalsIgnoreCase( value ) ^ "true".equalsIgnoreCase( value )) {
            return Boolean.parseBoolean( value );
        } else {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, "a boolean" ) );
        }
    }

}

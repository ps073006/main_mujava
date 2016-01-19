// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;
import java.math.BigDecimal;


public class BigDecimalConverter extends com.beust.jcommander.converters.BaseConverter<BigDecimal>
{

    public BigDecimalConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.math.BigDecimal convert( java.lang.String value )
    {
        try {
            return new java.math.BigDecimal( value );
        } catch ( java.lang.NumberFormatException nfe ) {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, "a BigDecimal" ) );
        }
    }

}

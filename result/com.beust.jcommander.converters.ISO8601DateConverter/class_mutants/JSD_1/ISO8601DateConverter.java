// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.ParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ISO8601DateConverter extends com.beust.jcommander.converters.BaseConverter<Date>
{

    private final java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat( "yyyy-MM-dd" );

    public ISO8601DateConverter( java.lang.String optionName )
    {
        super( optionName );
    }

    public  java.util.Date convert( java.lang.String value )
    {
        try {
            return DATE_FORMAT.parse( value );
        } catch ( java.text.ParseException pe ) {
            throw new com.beust.jcommander.ParameterException( getErrorString( value, String.format( "an ISO-8601 formatted date (%s)", DATE_FORMAT.toPattern() ) ) );
        }
    }

}

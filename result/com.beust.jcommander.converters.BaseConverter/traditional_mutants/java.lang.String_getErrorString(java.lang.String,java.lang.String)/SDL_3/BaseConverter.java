// This is a mutant program.
// Author : ysma

package com.beust.jcommander.converters;


import com.beust.jcommander.IStringConverter;


public abstract class BaseConverter<T> implements com.beust.jcommander.IStringConverter<T>
{

    private java.lang.String m_optionName;

    public BaseConverter( java.lang.String optionName )
    {
        m_optionName = optionName;
    }

    public  java.lang.String getOptionName()
    {
        return m_optionName;
    }

    protected  java.lang.String getErrorString( java.lang.String value, java.lang.String to )
    {
        return "";
    }

}

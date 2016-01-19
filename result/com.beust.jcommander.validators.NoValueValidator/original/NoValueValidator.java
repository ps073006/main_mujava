// This is a mutant program.
// Author : ysma

package com.beust.jcommander.validators;


import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;


public class NoValueValidator<T> implements com.beust.jcommander.IValueValidator<T>
{

    public  void validate( java.lang.String parameterName, T parameterValue )
        throws com.beust.jcommander.ParameterException
    {
    }

}

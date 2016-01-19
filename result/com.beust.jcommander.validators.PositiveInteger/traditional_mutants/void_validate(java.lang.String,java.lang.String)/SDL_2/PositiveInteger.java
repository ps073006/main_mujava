// This is a mutant program.
// Author : ysma

package com.beust.jcommander.validators;


import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;


public class PositiveInteger implements com.beust.jcommander.IParameterValidator
{

    public  void validate( java.lang.String name, java.lang.String value )
        throws com.beust.jcommander.ParameterException
    {
        int n = Integer.parseInt( value );
        if (n < 0) {
        }
    }

}

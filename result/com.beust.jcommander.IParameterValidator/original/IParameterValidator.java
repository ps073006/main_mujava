// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


public interface IParameterValidator
{

     void validate( java.lang.String name, java.lang.String value )
        throws com.beust.jcommander.ParameterException;

}

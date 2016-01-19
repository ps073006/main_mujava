// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


public interface IParameterValidator2 extends com.beust.jcommander.IParameterValidator
{

     void validate( java.lang.String name, java.lang.String value, com.beust.jcommander.ParameterDescription pd )
        throws com.beust.jcommander.ParameterException;

}

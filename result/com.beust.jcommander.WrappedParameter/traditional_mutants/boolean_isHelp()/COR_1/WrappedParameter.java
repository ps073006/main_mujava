// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class WrappedParameter
{

    private com.beust.jcommander.Parameter m_parameter;

    private com.beust.jcommander.DynamicParameter m_dynamicParameter;

    public WrappedParameter( com.beust.jcommander.Parameter p )
    {
        m_parameter = p;
    }

    public WrappedParameter( com.beust.jcommander.DynamicParameter p )
    {
        m_dynamicParameter = p;
    }

    public  com.beust.jcommander.Parameter getParameter()
    {
        return m_parameter;
    }

    public  com.beust.jcommander.DynamicParameter getDynamicParameter()
    {
        return m_dynamicParameter;
    }

    public  int arity()
    {
        return m_parameter != null ? m_parameter.arity() : 1;
    }

    public  boolean hidden()
    {
        return m_parameter != null ? m_parameter.hidden() : m_dynamicParameter.hidden();
    }

    public  boolean required()
    {
        return m_parameter != null ? m_parameter.required() : m_dynamicParameter.required();
    }

    public  boolean password()
    {
        return m_parameter != null ? m_parameter.password() : false;
    }

    public  java.lang.String[] names()
    {
        return m_parameter != null ? m_parameter.names() : m_dynamicParameter.names();
    }

    public  boolean variableArity()
    {
        return m_parameter != null ? m_parameter.variableArity() : false;
    }

    public  java.lang.Class<? extends IParameterValidator> validateWith()
    {
        return m_parameter != null ? m_parameter.validateWith() : m_dynamicParameter.validateWith();
    }

    public  java.lang.Class<? extends IValueValidator> validateValueWith()
    {
        return m_parameter != null ? m_parameter.validateValueWith() : m_dynamicParameter.validateValueWith();
    }

    public  boolean echoInput()
    {
        return m_parameter != null ? m_parameter.echoInput() : false;
    }

    public  void addValue( com.beust.jcommander.Parameterized parameterized, java.lang.Object object, java.lang.Object value )
    {
        if (m_parameter != null) {
            parameterized.set( object, value );
        } else {
            java.lang.String a = m_dynamicParameter.assignment();
            java.lang.String sv = value.toString();
            int aInd = sv.indexOf( a );
            if (aInd == -1) {
                throw new com.beust.jcommander.ParameterException( "Dynamic parameter expected a value of the form a" + a + "b" + " but got:" + sv );
            }
            callPut( object, parameterized, sv.substring( 0, aInd ), sv.substring( aInd + 1 ) );
        }
    }

    private  void callPut( java.lang.Object object, com.beust.jcommander.Parameterized parameterized, java.lang.String key, java.lang.String value )
    {
        try {
            java.lang.reflect.Method m;
            m = findPut( parameterized.getType() );
            m.invoke( parameterized.get( object ), key, value );
        } catch ( java.lang.SecurityException e ) {
            e.printStackTrace();
        } catch ( java.lang.IllegalAccessException e ) {
            e.printStackTrace();
        } catch ( java.lang.reflect.InvocationTargetException e ) {
            e.printStackTrace();
        } catch ( java.lang.NoSuchMethodException e ) {
            e.printStackTrace();
        }
    }

    private  java.lang.reflect.Method findPut( java.lang.Class<?> cls )
        throws java.lang.SecurityException, java.lang.NoSuchMethodException
    {
        return cls.getMethod( "put", java.lang.Object.class, java.lang.Object.class );
    }

    public  java.lang.String getAssignment()
    {
        return m_dynamicParameter != null ? m_dynamicParameter.assignment() : "";
    }

    public  boolean isHelp()
    {
        return m_parameter != null || m_parameter.help();
    }

}

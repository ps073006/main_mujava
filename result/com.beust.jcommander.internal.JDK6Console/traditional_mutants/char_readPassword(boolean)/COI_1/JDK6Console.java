// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


import com.beust.jcommander.ParameterException;
import java.io.PrintWriter;
import java.lang.reflect.Method;


public class JDK6Console implements com.beust.jcommander.internal.Console
{

    private java.lang.Object console;

    private java.io.PrintWriter writer;

    public JDK6Console( java.lang.Object console )
        throws java.lang.Exception
    {
        this.console = console;
        java.lang.reflect.Method writerMethod = console.getClass().getDeclaredMethod( "writer", new java.lang.Class<?>[0] );
        writer = (java.io.PrintWriter) writerMethod.invoke( console, new java.lang.Object[0] );
    }

    public  void print( java.lang.String msg )
    {
        writer.print( msg );
    }

    public  void println( java.lang.String msg )
    {
        writer.println( msg );
    }

    public  char[] readPassword( boolean echoInput )
    {
        try {
            writer.flush();
            java.lang.reflect.Method method;
            if (!echoInput) {
                method = console.getClass().getDeclaredMethod( "readLine", new java.lang.Class<?>[0] );
                return ((java.lang.String) method.invoke( console, new java.lang.Object[0] )).toCharArray();
            } else {
                method = console.getClass().getDeclaredMethod( "readPassword", new java.lang.Class<?>[0] );
                return (char[]) method.invoke( console, new java.lang.Object[0] );
            }
        } catch ( java.lang.Exception e ) {
            throw new com.beust.jcommander.ParameterException( e );
        }
    }

}

// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


import com.beust.jcommander.ParameterException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DefaultConsole implements com.beust.jcommander.internal.Console
{

    public  void print( java.lang.String msg )
    {
    }

    public  void println( java.lang.String msg )
    {
        System.out.println( msg );
    }

    public  char[] readPassword( boolean echoInput )
    {
        try {
            java.io.InputStreamReader isr = new java.io.InputStreamReader( System.in );
            java.io.BufferedReader in = new java.io.BufferedReader( isr );
            java.lang.String result = in.readLine();
            in.close();
            isr.close();
            return result.toCharArray();
        } catch ( java.io.IOException e ) {
            throw new com.beust.jcommander.ParameterException( e );
        }
    }

}

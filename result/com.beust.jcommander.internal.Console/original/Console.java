// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


public interface Console
{

     void print( java.lang.String msg );

     void println( java.lang.String msg );

     char[] readPassword( boolean echoInput );

}

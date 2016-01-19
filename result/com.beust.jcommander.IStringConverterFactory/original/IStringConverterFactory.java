// This is a mutant program.
// Author : ysma

package com.beust.jcommander;


public interface IStringConverterFactory
{

    <T> java.lang.Class<? extends IStringConverter<T>> getConverter( java.lang.Class<T> forType );

}

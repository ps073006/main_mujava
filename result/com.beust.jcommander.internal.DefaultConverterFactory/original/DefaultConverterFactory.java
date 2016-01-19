// This is a mutant program.
// Author : ysma

package com.beust.jcommander.internal;


import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.IStringConverterFactory;
import com.beust.jcommander.converters.BigDecimalConverter;
import com.beust.jcommander.converters.BooleanConverter;
import com.beust.jcommander.converters.DoubleConverter;
import com.beust.jcommander.converters.FileConverter;
import com.beust.jcommander.converters.FloatConverter;
import com.beust.jcommander.converters.ISO8601DateConverter;
import com.beust.jcommander.converters.IntegerConverter;
import com.beust.jcommander.converters.LongConverter;
import com.beust.jcommander.converters.StringConverter;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;


public class DefaultConverterFactory implements com.beust.jcommander.IStringConverterFactory
{

    private static java.util.Map<Class,Class<? extends IStringConverter<?>>> m_classConverters;

    static {
        m_classConverters = Maps.newHashMap();
        m_classConverters.put( java.lang.String.class, com.beust.jcommander.converters.StringConverter.class );
        m_classConverters.put( java.lang.Integer.class, com.beust.jcommander.converters.IntegerConverter.class );
        m_classConverters.put( int.class, com.beust.jcommander.converters.IntegerConverter.class );
        m_classConverters.put( java.lang.Long.class, com.beust.jcommander.converters.LongConverter.class );
        m_classConverters.put( long.class, com.beust.jcommander.converters.LongConverter.class );
        m_classConverters.put( java.lang.Float.class, com.beust.jcommander.converters.FloatConverter.class );
        m_classConverters.put( float.class, com.beust.jcommander.converters.FloatConverter.class );
        m_classConverters.put( java.lang.Double.class, com.beust.jcommander.converters.DoubleConverter.class );
        m_classConverters.put( double.class, com.beust.jcommander.converters.DoubleConverter.class );
        m_classConverters.put( java.lang.Boolean.class, com.beust.jcommander.converters.BooleanConverter.class );
        m_classConverters.put( boolean.class, com.beust.jcommander.converters.BooleanConverter.class );
        m_classConverters.put( java.io.File.class, com.beust.jcommander.converters.FileConverter.class );
        m_classConverters.put( java.math.BigDecimal.class, com.beust.jcommander.converters.BigDecimalConverter.class );
        m_classConverters.put( java.util.Date.class, com.beust.jcommander.converters.ISO8601DateConverter.class );
    }

    public  java.lang.Class<? extends IStringConverter<?>> getConverter( java.lang.Class forType )
    {
        return m_classConverters.get( forType );
    }

}

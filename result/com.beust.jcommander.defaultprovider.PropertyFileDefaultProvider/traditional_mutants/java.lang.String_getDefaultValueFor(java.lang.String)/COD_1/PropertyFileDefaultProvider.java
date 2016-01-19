// This is a mutant program.
// Author : ysma

package com.beust.jcommander.defaultprovider;


import com.beust.jcommander.IDefaultProvider;
import com.beust.jcommander.ParameterException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class PropertyFileDefaultProvider implements com.beust.jcommander.IDefaultProvider
{

    public static final java.lang.String DEFAULT_FILE_NAME = "jcommander.properties";

    private java.util.Properties m_properties;

    public PropertyFileDefaultProvider()
    {
        init( DEFAULT_FILE_NAME );
    }

    public PropertyFileDefaultProvider( java.lang.String fileName )
    {
        init( fileName );
    }

    private  void init( java.lang.String fileName )
    {
        try {
            m_properties = new java.util.Properties();
            java.net.URL url = ClassLoader.getSystemResource( fileName );
            if (url != null) {
                m_properties.load( url.openStream() );
            } else {
                throw new com.beust.jcommander.ParameterException( "Could not find property file: " + fileName + " on the class path" );
            }
        } catch ( java.io.IOException e ) {
            throw new com.beust.jcommander.ParameterException( "Could not open property file: " + fileName );
        }
    }

    public  java.lang.String getDefaultValueFor( java.lang.String optionName )
    {
        int index = 0;
        while (index < optionName.length() && Character.isLetterOrDigit( optionName.charAt( index ) )) {
            index++;
        }
        java.lang.String key = optionName.substring( index );
        return m_properties.getProperty( key );
    }

}

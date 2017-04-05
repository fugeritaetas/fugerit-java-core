package org.fugerit.java.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/*
 * 
 *
 * @author Morozko
 *
 */
public class PropsIO {

	public static final Properties BLANK_PROPS = new Properties();
	
	public static void fill( Properties from, Properties to ) {
		Enumeration e = from.keys();
		while ( e.hasMoreElements() ) {
			String key = (String)e.nextElement();
			String value = from.getProperty(key);
			if ( key != null && value != null ) {
				to.setProperty(key, value);	
			}
		}
	}
	
	public static Properties loadFromClassLoader( String path ) throws IOException {
		return loadFromStream( PropsIO.class.getResourceAsStream( path ) );
	}		
	
	public static Properties loadFromURL( String u ) throws IOException {
		return loadFromURL( new URL( u ) );
	}	
	
	public static Properties loadFromURL( URL u ) throws IOException {
		return loadFromStream( u.openStream() );
	}		
	
	public static Properties loadFromFile( String f ) throws IOException {
		return loadFromStream( new FileInputStream( f ) );
	}	
	
	public static Properties loadFromFile( File f ) throws IOException {
		return loadFromStream( new FileInputStream( f ) );
	}
	
	public static Properties loadFromStream( InputStream is ) throws IOException {
		Properties props = new Properties();
		props.load( is );
		is.close();
		return props;
	}
	
}

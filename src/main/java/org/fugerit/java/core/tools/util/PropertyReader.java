package org.fugerit.java.core.tools.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.fugerit.java.core.tools.util.args.Arg;
import org.fugerit.java.core.tools.util.args.ArgList;
import org.fugerit.java.core.tools.util.args.ArgUtils;

/*
 * <p>
 *	
 * 		
 * </p>
 *
 * @author mfranci
 *
 */
public class PropertyReader {

	public static void main( String [] args ) {
		try {
			ArgList argList = ArgUtils.parseArgsDefault( args );
			Arg fileArg = argList.findArg( "f" );
			Arg propArg = argList.findArg( "p" );
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream( new File( fileArg.getValue() ) );
			props.load( fis );
			fis.close();
			String value = props.getProperty( propArg.getValue() );
			System.out.println( value );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

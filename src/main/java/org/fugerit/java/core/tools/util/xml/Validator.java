package org.fugerit.java.core.tools.util.xml;

import java.io.File;
import java.io.FileInputStream;

import org.fugerit.java.core.tools.util.args.ArgList;
import org.fugerit.java.core.tools.util.args.ArgUtils;
import org.fugerit.java.core.xml.XMLValidator;
import org.fugerit.java.core.xml.sax.SAXParseResult;
import org.fugerit.java.core.xml.sax.XMLValidatorSAX;
import org.xml.sax.InputSource;

/*
 * 
 *
 * @author Morozko
 *
 */
public class Validator {

	public static void main( String[] args ) {
		try {
			ArgList list = ArgUtils.parseArgsDefault( args );
			File f = new File( list.findArgValue( "f" ) );
			XMLValidator validator = XMLValidatorSAX.newInstance();
			SAXParseResult result = validator.validateXML( new InputSource( new FileInputStream( f ) ) );
			result.printErrorReport( System.out );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

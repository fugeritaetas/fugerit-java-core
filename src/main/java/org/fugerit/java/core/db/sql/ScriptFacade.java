package org.fugerit.java.core.db.sql;

import java.io.IOException;

import org.fugerit.java.core.io.FileIO;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ScriptFacade {

	private final static String TOKEN1 = "@@@TOKEN1@@@";
	private final static String TOKEN2 = "@@@TOKEN2@@@";
	
	public static String[] parseScript( String script ) throws IOException {
		return parseSqlCommands( removeSqlComments( script ) );
	}
	
	public static String removeSqlComments( String script ) throws IOException {
		return script.replaceAll( "\\B--*\\B.*", "" );
	}
	
	public static String[] parseSqlCommands( String script ) throws IOException {	
		script = script.replaceAll( "'(.*?);(.*?)'" , "'$1"+TOKEN1+"$2'" );
		script = script.replaceAll( ";", TOKEN2 );
		script = script.replaceAll( TOKEN1, ";" );
		script = script.trim();
		int index = script.length()-1;
		//System.out.println( "ScriptFacade: '"+script+"'" );
		if ( script.length() > 0 && script.lastIndexOf( ";" ) == index ) {
			script = script.substring( 0, index );
		}
		return script.split( TOKEN2 );
	}
	
	public static void main( String[] args ) {
		try {
			
			String script = FileIO.readString( "C:/omnia/mfranci/java/eclipse-3.2/workspace-dev/org.opinf.jlib.mod.app.cms/src/org/opinf/jlib/mod/app/cms/web/update/sql/oracle/0_8_2.sql");
			
//			String script = " INSERT INTO test ( 'ci;ao', 'prova;', casa ); -- prova \n"+
//			" INSERT INTO test ( 'resf', 'dfadf', afadf ); ";			
			
			System.out.println( "A "+script );
			
			System.out.println( "-----------------------------" );
			System.out.println( );
			System.out.println( );
			System.out.println( );
			
			script = removeSqlComments( script );
			
			System.out.println( "B "+script );
			
			System.out.println( "-----------------------------" );
			System.out.println( );
			System.out.println( );
			System.out.println( );			
			
			String[] result = parseSqlCommands( script );
			
			for ( int k=0 ; k<result.length; k++ ) {
				System.out.println( "T "+k+" : "+result[k] );
			}

		} catch ( Exception e ){
			e.printStackTrace();
		}
	}
	
}

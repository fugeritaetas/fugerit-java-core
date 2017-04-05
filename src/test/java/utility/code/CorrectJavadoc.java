/**
 * 
 */
package utility.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mttfranci
 *
 */
public class CorrectJavadoc {

	
	private static String JAVA_COMMENT_OPEN_TAG = "/\\**";
	private static String JAVA_COMMENT_CLOSE_TAG = "\\*/";
	private static final Pattern TAG_REGEX_SECTION = Pattern.compile( JAVA_COMMENT_OPEN_TAG+"(.+?)"+JAVA_COMMENT_CLOSE_TAG, Pattern.DOTALL );
	
	//private static final String REGEXT = "/\\*\\*([^\\*]|\\*(?!/))*(.+?)\\*/";
	//private static final Pattern TAG_REGEX_SECTION = Pattern.compile( REGEXT, Pattern.DOTALL );
	
	
	
	public static String processFile( String fileContent ) throws Exception {
		String newContent = fileContent;
		//System.out.println( fileContent );
		Matcher matcher = TAG_REGEX_SECTION.matcher( fileContent );
		//System.out.println( matcher.find() );
		boolean found = matcher.find();
		System.out.println( found );
		while ( found ) {
			String current = matcher.group( 1 );
			
			if ( !current.contains( "code>" ) && !current.contains( "p>" ) ) {
				String newText = current.replaceAll( "<" , "&lt;" );
				newText = newText.replaceAll( ">" , "&gt;" );
				int index = newContent.indexOf(  current );
				newContent = newContent.substring( 0, index ) + newText + newContent.substring( index+current.length() );
				System.out.println( "TEST"+newText );
			}
			found = matcher.find();
		}
		return newContent;
	}
	
}

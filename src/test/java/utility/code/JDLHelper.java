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
public class JDLHelper {

	private static final Pattern TAG_REGEX_SECTION = Pattern.compile("<jdl:section>(.+?)</jdl:section>", Pattern.DOTALL );
	private static final Pattern TAG_REGEX_TEXT_EN = Pattern.compile( "<jdl:text lang='en'>(.+?)</jdl:text>", Pattern.DOTALL );
	
	public static String processFile( String fileContent ) throws Exception {
		String newContent = fileContent;
		Matcher matcher = TAG_REGEX_SECTION.matcher( fileContent );
		while ( matcher.find() ) {
			String current = matcher.group( 1 );
			Matcher matcherText = TAG_REGEX_TEXT_EN.matcher( current );
			if ( matcherText.find() ) {
				String text = matcherText.group( 1 );
				String replaceText = "<jdl:section>"+current+"</jdl:section>";
				int index = newContent.indexOf(  replaceText );
				newContent = newContent.substring( 0, index ) + text + newContent.substring( index+replaceText.length() );
			}
		}
		return newContent;
	}
	
}

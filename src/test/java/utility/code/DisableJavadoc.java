/**
 * 
 */
package utility.code;

/**
 * @author mttfranci
 *
 */
public class DisableJavadoc {

	
	private static String JAVA_COMMENT_OPEN_TAG = "/\\*\\*";
	private static String DISABLE = "/*";
	
	
	public static String processFile( String fileContent ) throws Exception {
		String newContent = fileContent.replaceAll( JAVA_COMMENT_OPEN_TAG , DISABLE );
		return newContent;
	}
	
}

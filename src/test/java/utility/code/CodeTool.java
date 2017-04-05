/**
 * 
 */
package utility.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.StringReader;

import org.fugerit.java.core.io.FileIO;

/**
 * @author mttfranci
 *
 */
public class CodeTool {

	private final static FileFilter FILTER = new FileFilter() {
		@Override
		public boolean accept(File pathname) {
			return pathname.isDirectory() || pathname.getName().endsWith( "java" );
		}
	};
	
	private static String preprocessing( String fileContent ) throws Exception {
		BufferedReader reader = new BufferedReader( new StringReader( fileContent ) );
		String packageFound = null;
		String line = reader.readLine();
		while ( line != null && packageFound == null ) {
			if ( line.trim().startsWith( "package " ) ) {
				packageFound = line;
			}
			line = reader.readLine();
		}
		int index = fileContent.indexOf( packageFound );
		String newContent = fileContent.substring( index );
		return newContent;
	}
	
	private static void processFile( File file, FileFilter filter ) throws Exception {
		if ( file.isDirectory())  {
			File[] list = file.listFiles( filter );
			for ( int k=0; k<list.length; k++ ) {
				processFile( list[k] , filter );
			}
		} else {
			String fileContent = FileIO.readString( file );
			String newContent = preprocessing( fileContent );
			newContent = JDLHelper.processFile( newContent );
			newContent = DisableJavadoc.processFile( newContent );
			//System.out.println( "processing > "+file.getCanonicalPath() );
			if ( !fileContent.equals( newContent ) ) {
				FileIO.writeString( newContent , file );
				System.out.println( "changed made to file > "+file.getCanonicalPath() );
			}
		}
	}
	
	public static void main( String[] args ) {
		try {
			processFile( new File( args[0] ), FILTER );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


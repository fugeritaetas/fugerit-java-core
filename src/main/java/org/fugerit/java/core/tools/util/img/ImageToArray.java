package org.fugerit.java.core.tools.util.img;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import org.fugerit.java.core.io.StreamIO;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ImageToArray {

	public static void main( String[] args ) {
		try {
			String img = args[0];
			File file = new File( img );
			FileInputStream fis = new FileInputStream( file );
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			StreamIO.pipeStream( fis, baos, StreamIO.MODE_CLOSE_BOTH );
			byte[] data = baos.toByteArray();
			for ( int k=0; k<data.length; k++ ) {
				System.out.print( data[k]+", " );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

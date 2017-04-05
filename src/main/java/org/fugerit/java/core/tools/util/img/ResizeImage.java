package org.fugerit.java.core.tools.util.img;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.fugerit.java.core.log.LogFacade;
import org.fugerit.java.core.tools.util.args.ArgList;
import org.fugerit.java.core.tools.util.args.ArgUtils;

/*
 * 
 *
 * @author Morozko
 *
 */
public class ResizeImage {

	private static void resize( File file, int w, int h ) throws Exception {
		Image image = Toolkit.getDefaultToolkit().getImage( file.toURL() );
		ImageIcon icon = new ImageIcon( image.getScaledInstance( w , h, Image.SCALE_SMOOTH ) );
		BufferedImage bi = new BufferedImage( icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB );
        Graphics g = bi.getGraphics();
        g.drawImage( icon.getImage(), 0, 0, null);
        ImageIO.write(bi, "jpg", file);
	}
	
	private static void resize( File file, int p ) throws Exception {
		Image image = Toolkit.getDefaultToolkit().getImage( file.toURL() );
		ImageIcon icon = new ImageIcon( image );
		int w = icon.getIconWidth()*p/100;
		int h = icon.getIconHeight()*p/100;
		icon = new ImageIcon( image.getScaledInstance( w , h, Image.SCALE_SMOOTH ) );
		BufferedImage bi = new BufferedImage( icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB );
        Graphics g = bi.getGraphics();
        g.drawImage( icon.getImage(), 0, 0, null);
        ImageIO.write(bi, "jpg", file);
	}
	
	private static void resize( File file, String w, String h, String p ) throws Exception {
		if ( p != null ) {
			LogFacade.getLog().info( "RESIZING : "+file.getCanonicalPath() );
			resize( file, Integer.parseInt( p ) );
		} else {
			resize( file, Integer.parseInt( w ), Integer.parseInt( h ) );
		}
	}
	
	public static void main( String[] args ) {
		try {
			ArgList argList = ArgUtils.parseArgsDefault( args );
			File file = new File( argList.findArgValue( "f" ) );
			String w = argList.findArgValue( "w" );
			String h = argList.findArgValue( "h" );
			String p = argList.findArgValue( "p" );
			if ( file.isFile() ) {
				resize( file , w, h , p );
			} else {
				File[] list = file.listFiles();
				for ( int k=0; k<list.length; k++ ) {
					resize( list[k] , w, h , p );	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

package org.fugerit.java.core.lang.helpers.cl;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/*
 * 
 *
 * @author Morozko
 *
 */
public class ClassLoaderFacade {

	public static ClassLoader fromDir( File[] dir, ClassLoader parent ) throws Exception {
		File[] list = dir;
		URL[] url = new URL[list.length];
		for ( int k=0; k<list.length; k++ ) {
			url[k] = list[k].toURL();
		}
		return new DirClassLoader( url, parent );
	}

}

class DirClassLoader extends URLClassLoader {

	/* (non-Javadoc)
	 * @see java.net.URLClassLoader#findClass(java.lang.String)
	 */
	protected Class findClass(String name) throws ClassNotFoundException {
		Class c = super.findClass(name);
		return c;
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#loadClass(java.lang.String)
	 */
	public Class loadClass(String name) throws ClassNotFoundException {
		Class c = null;
		try {
			c = this.findClass( name );
		} catch ( ClassNotFoundException cnfe ) {
			c = super.loadClass(name);
		}
		return c;
	}

	/*
	 * @param urls
	 * @param parent
	 */
	public DirClassLoader(URL[] urls, ClassLoader parent) {
		super(urls, parent);
	}

	
}
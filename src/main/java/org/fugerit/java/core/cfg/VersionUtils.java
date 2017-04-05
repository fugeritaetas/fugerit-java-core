package org.fugerit.java.core.cfg;

import java.util.Properties;

import org.fugerit.java.core.lang.helpers.ClassHelper;

/*
 * <p>Helper class for wrapping a module versione meta information.</p>
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class VersionUtils {

	public static Properties MODULES = new Properties();

	/*
	 * Register a module
	 * 
	 * @param name			the name of the module to register
	 * @param className		the implementing class for the module
	 */
	public synchronized static void registerModule( String name, String className ) {
		MODULES.setProperty( name , className );
	}
	
	/*
	 * Returns the registered module list
	 * 
	 * @return	the module list
	 */
	public synchronized static Properties getModuleList() {
		return MODULES;
	}
	
	/*
	 * Return a versione string for a module
	 * 
	 * @param moduleName	the module to look for
	 * @return				the version string
	 */
	public static String getVersionString( String moduleName ) {
		String versionString = null;
		String type = getModuleList().getProperty( moduleName );
		if ( type != null ) {
			try {
				Object o = ClassHelper.newInstance( type );
				try {
					ModuleVersion vc = (ModuleVersion) o;
					versionString = vc.getName()+" "+vc.getVersion()+" "+vc.getDate();
				} catch ( Throwable t2 ) {
					versionString = "[03] Impossible to find module version";
				}
			} catch (Exception t1) {
				versionString = "[02] Class module isn't loaded : ("+type+") - "+t1;
				t1.printStackTrace();
			}	
		} else {
			versionString = "[01] Module does not exist";
		}
		return versionString;
	}
	
}

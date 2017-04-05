package org.fugerit.java.core.cfg;

import java.util.Properties;

/*
 * <p>Helper class for wrapping a module versione meta information.</p>
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public interface ModuleVersion {

	/*
	 * Returns the name of this module
	 * 
	 * @return	 the name of this module
	 */
	public String getName();

	/*
	 * Returns the version of this module
	 * 
	 * @return	 the version of this module
	 */
	public String getVersion();

	/*
	 * Returns the date of this module
	 * 
	 * @return	 the date of this module
	 */
	public String getDate();
	
	/*
	 * Returns the last time this module was loaded
	 * 
	 * @return	 the last time this module was loaded
	 */	
	public String getLoadTime();
	
	/*
	 * Returns the dependancies (as module names and versions) of this module
	 * 
	 * @return	 the dependeancies of this module
	 */
	public Properties getDependancies();
	
}

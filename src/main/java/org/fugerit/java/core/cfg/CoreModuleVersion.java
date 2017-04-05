package org.fugerit.java.core.cfg;

/**
 * <p>Module versione for this library (Fugerit Java Library).</p>
 * 
 * @author Matteo a.k.a. Fugerit <d@fugerit.org>
 *
 */
public class CoreModuleVersion extends BaseModuleVersion {

	private static final String MODULE_CONFIG_PATH = "/org/fugerit/java/core/cfg/module.properties";
	
	/**
	 * <p>Default constructor</p>
	 */
	public CoreModuleVersion() {
		super( loadSafe( MODULE_CONFIG_PATH ) );
	}

}

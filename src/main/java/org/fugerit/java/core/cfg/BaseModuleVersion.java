package org.fugerit.java.core.cfg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.fugerit.java.core.util.PropsIO;

/**
 * <p>Helper class for wrapping a module versione meta information.</p>
 * 
 * @author Matteo a.k.a. Fugerit
 *
 */
public class BaseModuleVersion implements ModuleVersion { 

	// inherited methods - start
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDate() {
		return this.date;
	}
	
	@Override
	public String getVersion() {
		return this.version;
	}
	
	@Override
	public String getLoadTime() {
		return (String)LOAD_TIME.get( this.getClass().getName() );
	}
	
	@Override
	public Properties getDependancies() {
		return this.dependancies;
	}

	// inherited methods - end
	
	/*
	 * Module Name key
	 */
	public static final String PROP_MODULE_NAME = "module.name";
	
	/*
	 * Module Version key
	 */
	public static final String PROP_MODULE_VERSION = "module.version";
	
	/*
	 * Module Date key
	 */
	public static final String PROP_MODULE_DATE = "module.date";
	
	/*
	 * Default dependancies.
	 */
	public static final Properties NO_DEPENDANCIES = new Properties();

	/*
	 * Constructor loading dependancies from a resources file
	 * 
	 * @param name		name of the module
	 * @param version	version of the module
	 * @param date		date of the module
	 * @param dependanciesCS	resource path of the dependacy properties
	 */
	public BaseModuleVersion( String name,
			String version, String date, String dependanciesCS ) {
		this( name, version, date, loadSafe( dependanciesCS ) );
	}
	
	/*
	 * <p>Constructor loading name, version and date from a properties object</p>
	 * 
	 * @param props			the property object
	 * @param dependancies	the dependancies properties
	 */
	public BaseModuleVersion( Properties props, Properties dependancies ) {
		this( props.getProperty( PROP_MODULE_NAME ),
				props.getProperty( PROP_MODULE_VERSION ),
				props.getProperty( PROP_MODULE_DATE ), 
				dependancies );
	}
	
	/*
	 * <p>Constructor loading name, version and date from a properties object</p>
	 * 
	 * @param props			the property object
	 */
	public BaseModuleVersion( Properties props ) {
		this( props, NO_DEPENDANCIES ) ;
	}

	/*
	 * Constructor loading dependancies from a resources file
	 * 
	 * @param name		name of the module
	 * @param version	version of the module
	 * @param date		date of the module
	 * @param dependancies 	the dependancies
	 */
	public BaseModuleVersion( String name,
			String version, String date, Properties dependancies ) {
		super();
		loadTime();
		this.dependancies = dependancies;
		this.date = date;
		this.version = version;
		this.name = name;
	}

	
	/*
	 * Save the load time for a module.
	 */
	private synchronized void loadTime() {
		try {
			String cName = this.getClass().getName();
			if ( LOAD_TIME.get( cName ) == null ) {
				LOAD_TIME.put( cName , String.valueOf( new java.sql.Timestamp( System.currentTimeMillis() ) ) );
			}
		} catch (Exception e) {}
	}
	
	private static HashMap<String, String> LOAD_TIME = new HashMap<String, String>();
	
	private Properties dependancies;
	
	private String date;
	
	private String version;
	
	private String name;
	
	protected static Properties loadSafe( String cs ) {
		Properties props = null;
		try {
			props = PropsIO.loadFromClassLoader( cs );
		} catch (IOException e) {
			throw new RuntimeException( e );
		}
		return props;
	}
	
}

package org.fugerit.java.core.cfg;

import java.io.InputStream;
import java.util.Properties;

import org.w3c.dom.Element;

/**
 * <p>A class implementing <code>ConfigurableObject</code> interface 
 *  is an object which could be configured through an XML Document or 
 *  a Properties object.
 *  </p>
 *
 * @author Matteo a.k.a. Fugerit
 *
 */
public interface ConfigurableObject {

	/**
	 * <p>Configure the object.</p>
	 * 
	 * @param source				The input source to use for configuration.
	 * @throws ConfigException		If troubles arise during object configuration.
	 */
	public void configureProperties( InputStream source ) throws ConfigException;	
	
	/**
	 * <p>Configure the object.</p>
	 * 
	 * @param source				The input source to use for configuration.
	 * @throws ConfigException		If troubles arise during object configuration.
	 */
	public void configureXML( InputStream source ) throws ConfigException;
	
	/**
	 * <p>Configure the object.</p>
	 * 
	 * @param props					The property object to use for configuration.
	 * @throws ConfigException		If troubles arise during object configuration.
	 */
	public void configure( Properties props ) throws ConfigException;
	
	/**
	 * <p>Configure the object.</p>
	 * 
	 * @param tag					The tag object to use for configuration.
	 * @throws ConfigException		If troubles arise during object configuration.
	 */
	public void configure( Element tag ) throws ConfigException;
	
}

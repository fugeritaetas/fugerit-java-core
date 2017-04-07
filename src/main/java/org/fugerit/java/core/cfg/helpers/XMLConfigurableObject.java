package org.fugerit.java.core.cfg.helpers;

import java.util.Properties;

import org.fugerit.java.core.cfg.ConfigException;

/*
 * <p>Base class for implementations of ConfigurableObject supporting only
 * the <code>configure(Element)</code> method.
 * The <code>configure(Properties)</code> method will throw an exception.</p>
 *
 * @author Matteo a.k.a. Fugerit
 *
 */
public abstract class XMLConfigurableObject extends AbstractConfigurableObject {

	/*
	 * 
	 */
	private static final long serialVersionUID = -3032211194907648543L;

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configure(java.util.Properties)
	 */
	public void configure(Properties props) throws ConfigException {
		throw ( new ConfigException( "Properties configuration not supported" ) );
	}

}

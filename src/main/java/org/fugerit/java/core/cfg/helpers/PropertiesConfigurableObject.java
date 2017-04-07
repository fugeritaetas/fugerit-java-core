package org.fugerit.java.core.cfg.helpers;

import org.fugerit.java.core.cfg.ConfigException;
import org.w3c.dom.Element;

/*
 * <p>Base class for implementations of ConfigurableObject supporting only
 * the <code>configure(Properties)</code> method.
 * The <code>configure(Element)</code> method will throw an exception.</p>
 *
 * @author Matteo a.k.a. Fugerit
 *
 */
public abstract class PropertiesConfigurableObject  extends AbstractConfigurableObject {

	/*
	 * 
	 */
	private static final long serialVersionUID = 2001953242749817211L;

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configure(org.w3c.dom.Element)
	 */
	public void configure(Element tag) throws ConfigException {
		throw ( new ConfigException( "Properties configuration not supported" ) );
	}

}

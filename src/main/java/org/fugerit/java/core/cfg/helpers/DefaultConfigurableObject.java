package org.fugerit.java.core.cfg.helpers;

import java.util.Properties;

import org.fugerit.java.core.cfg.ConfigException;
import org.fugerit.java.core.cfg.ConfigurableObject;
import org.fugerit.java.core.xml.dom.DOMUtils;
import org.w3c.dom.Element;

/*
 * <p>Default implementation of <code>ConfigurableObject</code>,
 * <code>configure(Properties)</code> method is a donothing, while
 * <code>configure(Element)</code> calls <code>configure(Properties)</code>
 * with the Element attributes transformed in a Properties object.</p>
 *
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class DefaultConfigurableObject extends AbstractConfigurableObject implements ConfigurableObject {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1596415517623964943L;

	/*
	 * <p>Converts an XML Tag in a Properties object.</p> 
	 * 
	 * <p>Each attribute on the tag is set as a key/value entry in the resulting properties object.</p>
	 * 
	 * @param tag		The tag for configu
	 * @return			The properties
	 */
	public static Properties defaultConversion( Element tag ) {
		return DOMUtils.attributesToProperties( tag );
	}
	
	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configure(java.util.Properties)
	 */
	public void configure(Properties props) throws ConfigException {

	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configure(org.w3c.dom.Element)
	 */
	public void configure(Element tag) throws ConfigException {
		configure( defaultConversion( tag ) );
	}

}

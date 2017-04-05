package org.fugerit.java.core.cfg.helpers;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.fugerit.java.core.cfg.ConfigException;
import org.fugerit.java.core.cfg.ConfigurableObject;
import org.fugerit.java.core.log.BasicLogObject;
import org.fugerit.java.core.util.PropsIO;
import org.fugerit.java.core.xml.dom.DOMIO;
import org.w3c.dom.Element;

/*
 * <p>Abstract implementation of ConfigurableObject interface.
 * 	Subclasses must only implement configure(Properties) and configure(Document).</p>
 *
 * @author Morozko
 *
 */
public abstract class AbstractConfigurableObject extends BasicLogObject implements ConfigurableObject, Serializable {

	/*
	 * 
	 */
	private static final long serialVersionUID = -5893401779153563982L;

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configure(java.util.Properties)
	 */
	public abstract void configure(Properties props) throws ConfigException;

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configure(org.w3c.dom.Element)
	 */
	public abstract void configure(Element tag) throws ConfigException;

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configureProperties(java.io.InputStream)
	 */
	public void configureProperties(InputStream source) throws ConfigException {
		try {
			this.configure( PropsIO.loadFromStream( source ) );
		} catch (Exception e) {
			throw new ConfigException( e );
		}
	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.cfg.ConfigurableObject#configureXML(java.io.InputStream)
	 */
	public void configureXML(InputStream source) throws ConfigException {
		try {
			this.configure( DOMIO.loadDOMDoc( source ).getDocumentElement() );
		} catch (Exception e) {
			throw new ConfigException( e );
		}
	}

}

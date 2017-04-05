package org.fugerit.java.core.xml.dom;

import java.util.Properties;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/*
 * 
 *
 * @author Morozko
 *
 */
public class DOMUtils {

	   public static Properties attributesToProperties(Element tag) {
	        Properties props = new Properties();
	        NamedNodeMap atts = tag.getAttributes();
	        for (int k=0; k<atts.getLength(); k++) {
	            Attr a = (Attr)atts.item(k);
	            props.setProperty(a.getName(), a.getValue());
	        }
	        return props;
	    }
	    

	    private DOMUtils() {
	        super();
	    }	
	
}

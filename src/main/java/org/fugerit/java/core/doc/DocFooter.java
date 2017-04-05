package org.fugerit.java.core.doc;

/*
 * 
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class DocFooter extends DocHeaderFooter {

	public DocFooter() {
		this.useFooter = false;
	}
	
	private boolean useFooter;

	/*
	 * @return the useFooter
	 */
	public boolean isUseFooter() {
		return useFooter;
	}

	/*
	 * @param useFooter the useFooter to set
	 */
	public void setUseFooter(boolean useFooter) {
		this.useFooter = useFooter;
	}
	
}

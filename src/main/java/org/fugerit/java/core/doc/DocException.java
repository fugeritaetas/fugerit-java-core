package org.fugerit.java.core.doc;

/*
 * 
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class DocException extends Exception {

	private String code;
	
	public DocException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	/*
	 * 
	 */
	private static final long serialVersionUID = -8872968598674596827L;
	
}

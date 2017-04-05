package org.fugerit.java.core.cfg;

/*
 * <p>Exception for handling unexpected situations during configuration.</p>
 *
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class ConfigException extends Exception {

	private int code;	// error code
	
	/*
	 * 
	 */
	private static final long serialVersionUID = -4205246051306630691L;

	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 */
	public ConfigException() {
		super();
	}


	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param message	the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
	 * @param cause		the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public ConfigException(String message, Throwable cause) {
		super(message, cause);
	}


	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param message	the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
	 */
	public ConfigException(String message) {
		super(message);
	}

	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param cause		the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public ConfigException(Throwable cause) {
		super(cause);
	}

	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param code		the error code
	 */
	public ConfigException(int code) {
		super();
		this.code = code;
	}

	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param message	the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
	 * @param code		the error code
	 */
	public ConfigException(String message, int code) {
		super(message);
		this.code = code;
	}

	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param cause		the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 * @param code		the error code
	 */
	public ConfigException(Throwable cause, int code) {
		super(cause);
		this.code = code;
	}

	/*
	 * <p>Creates a new <code>ConfigException</code></p>
	 * 
	 * @param message	the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
	 * @param cause		the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 * @param code		the error code
	 */
	public ConfigException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}
	
	/*
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/*
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		return super.toString()+"[code:"+this.code+"]";
	}

}

package org.fugerit.java.core.doc;

/*
 * 
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class DocElement {

	public String toString() {
		return this.getClass().getName();
	}
	
	public static final int ELEMENT_TYPE_TABLE = 1;
	
	public static final int ELEMENT_TYPE_TABLEROW = 2;
	
	public static final int ELEMENT_TYPE_TABLECELL = 3;
	
	public static final int ELEMENT_TYPE_PARAGRAPH = 4;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

package org.fugerit.java.core.db.metadata;


/*
 * 
 *
 * @author mfranci
 *
 */
public class IndexModel extends ColumnContainer {
	
	private String name;
	
	/*
	 * @return Restituisce il valore di name.
	 */
	public String getName() {
		return name;
	}

	/*
	 * @param name il valore di name da impostare.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}

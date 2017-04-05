package org.fugerit.java.core.db.metadata.query;

/*
 * 
 *
 * @author mfranci
 *
 */
public class QueryColumnModel {
	
	private String name;
	
	private String display;
	
	private int type;
	
	private String typeName;
	
	private String typeClass;

	/*
	 * @return the typeClass
	 */
	public String getTypeClass() {
		return typeClass;
	}

	/*
	 * @param typeClass the typeClass to set
	 */
	public void setTypeClass(String typeClass) {
		this.typeClass = typeClass;
	}

	/*
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/*
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/*
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/*
	 * @param display the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/*
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/*
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/*
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	
}

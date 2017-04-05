package org.fugerit.java.core.db.metadata;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ColumnModel {

	public static final int NULLABLE_FALSE = 0;
	public static final int NULLABLE_TRUE = 1;
	public static final int NULLABLE_UNKNOWN = -1;
	
	public String toString() {
		return this.getClass().getName()+"[name:"+this.getName()+";typeSql:"+this.getTypeSql()+";typeName:"+this.typeName+"]";
	}
	
	private String name;
	
	private int typeSql;
	
	private int nullable;
	
	private int size;
	
	private String typeName;
	
	private String comment;
	
	private String extra;

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

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

	/*
	 * @return Restituisce il valore di typeName.
	 */
	public String getTypeName() {
		return typeName;
	}

	/*
	 * @param typeName il valore di typeName da impostare.
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/*
	 * @return Restituisce il valore di typeSql.
	 */
	public int getTypeSql() {
		return typeSql;
	}

	/*
	 * @param typeSql il valore di typeSql da impostare.
	 */
	public void setTypeSql(int typeSql) {
		this.typeSql = typeSql;
	}

	/*
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/*
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/*
	 * @return the nullable
	 */
	public int getNullable() {
		return nullable;
	}

	/*
	 * @param nullable the nullable to set
	 */
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}

	/*
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/*
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
}

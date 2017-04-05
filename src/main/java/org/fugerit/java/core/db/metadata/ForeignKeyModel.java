package org.fugerit.java.core.db.metadata;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ForeignKeyModel  {

	public ForeignKeyModel() {
		this.columnMap = new Properties();
	}
	
	private Properties columnMap;
	
	private String name;

	private TableId foreignTableId;
	

	/*
	 * @return Restituisce il valore di foreignTableId.
	 */
	public TableId getForeignTableId() {
		return foreignTableId;
	}

	/*
	 * @param foreignTableId il valore di foreignTableId da impostare.
	 */
	public void setForeignTableId(TableId foreignTableId) {
		this.foreignTableId = foreignTableId;
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

	public Properties getColumnMap() {
		return columnMap;
	}

	public List foreignColumnList( TableModel tableModel ) {
		List columnList = new ArrayList();
		Enumeration e = columnMap.keys();
		while ( e.hasMoreElements() ) {
			String columnName = (String)(e.nextElement());
			columnList.add( tableModel.getColumn( columnName ) );
		}
		return columnList;
	}
	
	public List internalColumnList( TableModel tableModel ) {
		List columnList = new ArrayList();
		Enumeration e = columnMap.elements();
		while ( e.hasMoreElements() ) {
			String columnName = (String)(e.nextElement());
			columnList.add( tableModel.getColumn( columnName ) );
		}
		return columnList;
	}	
	
}

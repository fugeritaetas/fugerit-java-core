package org.fugerit.java.core.db.metadata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ColumnContainer {

	
	private List columnList;
	
	private Map columnMap;
	
	private Map columnMapNoCase;
	

	/*
	 * @return Restituisce il valore di columnList.
	 */
	public List getColumnList() {
		return columnList;
	}

	/*
	 * @return Restituisce il valore di columnMap.
	 */
	public Map getColumnMap() {
		return columnMap;
	}	
	
	public ColumnContainer() {
		this.columnList = new ArrayList();
		this.columnMap = new HashMap();
		this.columnMapNoCase = new HashMap();
	}
	
	public void addColumn( ColumnModel columnModel ) {
		if ( columnModel != null ) {
			this.columnList.add( columnModel );
			this.columnMap.put( columnModel.getName(), columnModel );
			this.columnMapNoCase.put( columnModel.getName().toLowerCase(), columnModel );
		}
	}	
	
	public ColumnModel getColumn( String columnName ) {
		ColumnModel columnModel = (ColumnModel)this.getColumnMap().get( columnName );
		if ( columnModel == null ) {
			columnModel = (ColumnModel)this.columnMapNoCase.get( columnName.toLowerCase() );
		}
		return columnModel;
	}
	
}

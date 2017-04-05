package org.fugerit.java.core.db.dao.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 
 *
 * @author mfranci
 *
 */
public class QueryTableModel {

	public void addColumn( String name, QueryTableColumn column ) {
		this.valueMap.put( name.toLowerCase(), column );
		this.valueList.add( column );
	}
	
	public QueryTableModel() {
		this.valueList = new ArrayList();
		this.valueMap = new HashMap();
	}
	
	private Map valueMap;
	
	private List valueList;
	
	public Iterator iterateQueryColumn() {
		return this.valueList.iterator();
	}
	
	public QueryTableColumn getQueryColumn( String name ) {
		return (QueryTableColumn)this.valueMap.get( name.toLowerCase() );
	}
	
	public QueryTableColumn getQueryColumn( int index ) {
		return (QueryTableColumn)this.valueList.get( index );
	}	
	
}

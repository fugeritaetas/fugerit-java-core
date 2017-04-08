package org.fugerit.java.core.db.filter;


/*
 * 
 * 
 * @author Matteo a.k.a. Fugerit
 *
 */
public class TableConfig {

	private String name;
	
	private DataFilter filter;
	
	private String[] columnsName;
	
	private String[] columnsKeyName;

	public String[] getColumnsKeyName() {
		return columnsKeyName;
	}

	public void setColumnsKeyName(String[] columnsKeyName) {
		this.columnsKeyName = columnsKeyName;
	}


	public String[] getColumnsName() {
		return columnsName;
	}


	public void setColumnsName(String[] columnsName) {
		this.columnsName = columnsName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public DataFilter getFilter() {
		return filter;
	}

	public void setFilter(DataFilter filter) {
		this.filter = filter;
	}
	
	
	
}

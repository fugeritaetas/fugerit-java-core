package org.fugerit.java.core.db.dao.table;

/*
 * 
 *
 * @author mfranci
 *
 */
public class QueryTableParam {

	public static QueryTableParam newInstance( String columnName, Object columnValue ) {
		QueryTableParam queryTableParam = new QueryTableParam();
		queryTableParam.setColumnName( columnName );
		queryTableParam.setColumnValue( columnValue );
		return queryTableParam;
	}
	
	private String columnName;
	
	private Object columnValue;

	/*
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/*
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/*
	 * @return the columnValue
	 */
	public Object getColumnValue() {
		return columnValue;
	}

	/*
	 * @param columnValue the columnValue to set
	 */
	public void setColumnValue(Object columnValue) {
		this.columnValue = columnValue;
	}
	
}

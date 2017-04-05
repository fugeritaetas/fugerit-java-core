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
public class TableModel extends ColumnContainer {

	public void addForeignKey( ForeignKeyModel foreignKeyModel ) {
		this.foreignKeyMap.put( foreignKeyModel.getName(), foreignKeyModel );
		this.foreignKeyList.add( foreignKeyModel );
	}	
	
	public void addIndex( IndexModel indexModel ) {
		this.indexMap.put( indexModel.getName(), indexModel );
		this.indexList.add( indexModel );
	}
	
	public TableModel() {
		this.indexMap = new HashMap();
		this.indexList = new ArrayList();
		this.foreignKeyMap = new HashMap();
		this.foreignKeyList = new ArrayList();
	}
	
	private Map foreignKeyMap;
	
	private List foreignKeyList;
	
	private Map indexMap;
	
	private List indexList;
	
	private TableId tableId;
	
	private IndexModel primaryKey;
	
	private String comment;

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
	 * @return the primaryKey
	 */
	public IndexModel getPrimaryKey() {
		return primaryKey;
	}

	/*
	 * @param primaryKey the primaryKey to set
	 */
	public void setPrimaryKey(IndexModel primaryKey) {
		this.primaryKey = primaryKey;
	}

	/*
	 * @return Restituisce il valore di tableId.
	 */
	public TableId getTableId() {
		return tableId;
	}

	/*
	 * @param tableId il valore di tableId da impostare.
	 */
	public void setTableId(TableId tableId) {
		this.tableId = tableId;
	}

	/*
	 * @return Restituisce il valore di name.
	 */
	public String getName() {
		return this.getTableId().getTableName();
	}
	
	/*
	 * @return Restituisce il valore di name.
	 */
	public String getCatalog() {
		return this.getTableId().getTableCatalog();
	}	

	/*
	 * @return Restituisce il valore di name.
	 */
	public String getSchema() {
		return this.getTableId().getTableSchema();
	}	
	
	/*
	 * @return Restituisce il valore di indexMap.
	 */
	public Map getIndexMap() {
		return indexMap;
	}

	/*
	 * @return Restituisce il valore di indexList.
	 */
	public List getIndexList() {
		return indexList;
	}

	/*
	 * @return Restituisce il valore di foreignKeyList.
	 */
	public List getForeignKeyList() {
		return foreignKeyList;
	}

	/*
	 * @return Restituisce il valore di foreignKeyMap.
	 */
	public Map getForeignKeyMap() {
		return foreignKeyMap;
	}
	
}

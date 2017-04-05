package org.fugerit.java.core.db.backup;

/*
 * 
 *
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class TableConfig {
	
	private String table;
	
	private String select;
	
	private String meta;


	private BackupAdaptor adaptorFrom;
	
	private BackupAdaptor adaptorTo;
	
	/*
	 * @return the select
	 */
	public String getSelect() {
		return select;
	}

	/*
	 * @param select the select to set
	 */
	public void setSelect(String select) {
		this.select = select;
	}

	/*
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/*
	 * @param table the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public BackupAdaptor getAdaptorFrom() {
		return adaptorFrom;
	}

	public void setAdaptorFrom(BackupAdaptor adaptorFrom) {
		this.adaptorFrom = adaptorFrom;
	}

	public BackupAdaptor getAdaptorTo() {
		return adaptorTo;
	}

	public void setAdaptorTo(BackupAdaptor adaptorTo) {
		this.adaptorTo = adaptorTo;
	}

	
	
	
	
}

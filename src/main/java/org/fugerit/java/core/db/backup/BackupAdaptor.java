package org.fugerit.java.core.db.backup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.w3c.dom.Element;

/*
 * <p>Interface for a backup adaptor.</p>
 * 
 * <p>Backup adaptor provides custom functionality for data to backup.</p>
 *
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public interface BackupAdaptor {

	/*
	 * Helper method for setting parameter to a PreparedStatement
	 * 
	 * @param ps		PreparedStatement for current query
	 * @param rsmd		ResultSetMetadataData for current query
	 * @param obj		The current parameter value to set
	 * @param index		the current paramter index to set (starting from 1)
	 * @throws SQLException		if anything goes wrong
	 */
	public void set( PreparedStatement ps, ResultSetMetaData rsmd, Object obj, int index ) throws SQLException;
	
	/*
	 * Helper method for getting objects from a ResultSet
	 * 
	 * @param rs		the ResultSet to look from
	 * @param rsmd		ResultSetMetaData for current query
	 * @param index		The index of the object to get (starting from 1)
	 * @return			the object at given index on current row
	 * @throws SQLException		if anything goes wrong
	 */
	public Object get( ResultSet rs, ResultSetMetaData rsmd, int index ) throws SQLException;
	
	
	/*
	 * Configure the adaptor
	 * 
	 * @param config		the custom configuration for this adaptor
	 * @throws Exception	if configuration fail
	 */
	public void configure( Element config ) throws Exception;
	
}

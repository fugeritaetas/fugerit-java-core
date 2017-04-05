package org.fugerit.java.core.db.dao.rse;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import org.fugerit.java.core.db.dao.RSExtractor;

/*
 * 
 *
 * @author mfranci
 *
 */
public class PropertiesExtractor implements RSExtractor {

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.dao.RSExtractor#extractNext(java.sql.ResultSet)
	 */
	public Object extractNext(ResultSet rs) throws SQLException {
		Properties props = new Properties();
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		for ( int k=1; k<=cols; k++) {
			String name = rsmd.getColumnName( k );
			String value = rs.getString( name );
			if ( value != null ) {
				props.setProperty( name, value );	
			}
		}
		return props;
	}

}

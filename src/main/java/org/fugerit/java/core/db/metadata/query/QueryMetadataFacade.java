package org.fugerit.java.core.db.metadata.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.fugerit.java.core.log.LogFacade;

/*
 * 
 *
 * @author mfranci
 *
 */
public class QueryMetadataFacade {

	public static QueryColumnMap columnMap( Connection conn, String select, boolean noModify ) throws Exception {
		Statement stm = conn.createStatement();
		String metaSelect = select;
		if ( !noModify ) {
			metaSelect = " SELECT * FROM ( "+select+" ) v WHERE 1=0 ";
		}
		LogFacade.getLog().info( "QueryMetadataFacade.columnMap metaSelect: "+metaSelect );
		ResultSet rs = stm.executeQuery( metaSelect );
		ResultSetMetaData rsmd = rs.getMetaData();
		QueryColumnMap map = columnMap( rsmd );
		rs.close();
		stm.close();
		return map;
	}		

	
	public static QueryColumnMap columnMap( Connection conn, String select ) throws Exception {
		return columnMap(conn, select, false);
	}		
	
	public static QueryColumnMap columnMap( ResultSetMetaData rsmd ) throws Exception {
		QueryColumnMap map = new QueryColumnMap();
		for ( int k = 1; k<= rsmd.getColumnCount(); k++ ) {
			QueryColumnModel model = new QueryColumnModel();
			model.setName( rsmd.getColumnName( k ) );
			model.setDisplay( rsmd.getColumnLabel( k ) );
			model.setType( rsmd.getColumnType( k ) );
			model.setTypeName( rsmd.getColumnTypeName( k ) );
			model.setTypeClass( rsmd.getColumnClassName( k ) );
			map.add( model );
		}
		return map;
	}	
	
}

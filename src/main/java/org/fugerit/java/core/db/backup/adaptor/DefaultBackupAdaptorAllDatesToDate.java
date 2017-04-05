package org.fugerit.java.core.db.backup.adaptor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import org.fugerit.java.core.db.backup.BackupAdaptor;
import org.fugerit.java.core.io.StreamIO;
import org.fugerit.java.core.log.BasicLogObject;
import org.w3c.dom.Element;

/*
 * 
 *
 * @author mfranci
 *
 */
public class DefaultBackupAdaptorAllDatesToDate extends BasicLogObject implements BackupAdaptor {

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.backup.BackupAdaptor#get(java.sql.ResultSet, java.sql.ResultSetMetaData, int)
	 */
	public Object get(ResultSet rs, ResultSetMetaData rsmd, int index) throws SQLException {
		int type = rsmd.getColumnType( index );
		String colName = rsmd.getColumnName( index );
		Object result = rs.getObject( colName );
        if (type==Types.DATE) {
        	result = rs.getDate( index );
        }
		return result;
	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.backup.BackupAdaptor#set(java.sql.PreparedStatement, java.sql.ResultSetMetaData, java.lang.Object, int)
	 */
	public void set(PreparedStatement ps, ResultSetMetaData rsmd, Object obj, int index) throws SQLException {
		int type = rsmd.getColumnType( index );
		this.getLogger().debug( "DefaultBackupAdaptor>>> SETTING TYPE : "+rsmd.getColumnName( index ) );
		if (  obj == null ) {
			ps.setNull( index , type );
		} else if (type==Types.DATE || type==Types.TIME || type == Types.TIMESTAMP)  {
	        ps.setDate( index , (Date)obj );
		 } else if (type==Types.BLOB) {
			Blob b = (Blob)obj;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				StreamIO.pipeStream( b.getBinaryStream() , baos, StreamIO.MODE_CLOSE_BOTH );
			} catch (IOException e) {
				throw new SQLException( e.toString() );
			}
			ps.setBytes( index , baos.toByteArray() );
	     } else {
	    	ps.setObject( index , obj );
	     }
	}

	public void configure(Element config) throws Exception {
	}

}

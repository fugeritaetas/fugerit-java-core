package org.fugerit.java.core.db.backup.adaptor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.fugerit.java.core.db.backup.DefaultBackupAdaptor;

/*
 * 
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public class BackupAdaptorFilterChar extends DefaultBackupAdaptor {

	private static final String[][] FILTER = {
		
	};
	
	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.backup.DefaultBackupAdaptor#get(java.sql.ResultSet, java.sql.ResultSetMetaData, int)
	 */
	public Object get(ResultSet rs, ResultSetMetaData rsmd, int index) throws SQLException {
		Object obj = super.get(rs, rsmd, index);
		if ( obj instanceof String ) {
			String s = (String) obj;
			for ( int k=0; k<FILTER.length; k++ ) {
				String test = FILTER[k][0];
				String replace = FILTER[k][1];
				if ( s.indexOf( test ) != -1 ) {
					System.err.println( "FROM "+s  );
					s = s.replaceAll( test , replace );
					System.err.println( "TO   "+s  );
				}
			}
			obj = s;
		}
		return obj;
	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.backup.DefaultBackupAdaptor#set(java.sql.PreparedStatement, java.sql.ResultSetMetaData, java.lang.Object, int)
	 */
	public void set(PreparedStatement ps, ResultSetMetaData rsmd, Object obj, int index) throws SQLException {
		// TODO Auto-generated method stub
		super.set(ps, rsmd, obj, index);
	}

}

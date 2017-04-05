package org.fugerit.java.core.db.backup;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public interface SequenceReset {

	public long loadNextValue( Connection conn, String sequenceName ) throws SQLException;
	
	public void saveNextValue( Connection conn, String sequenceName, long value ) throws SQLException;
	
}

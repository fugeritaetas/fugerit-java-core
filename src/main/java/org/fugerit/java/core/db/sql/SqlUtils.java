package org.fugerit.java.core.db.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 
 *
 * @author mfranci
 *
 */
public class SqlUtils {

	public static boolean closeLoose( Connection conn, Statement stm, ResultSet rs ) {
		return closeLoose( conn ) && closeLoose( stm ) && closeLoose( rs );
	}	
	
	public static boolean closeLoose( Connection conn, Statement stm ) {
		return closeLoose( conn ) && closeLoose( stm );
	}	
	
	public static boolean closeLoose( Connection conn ) {
		boolean close = true;
		try {
			conn.close();
		} catch (Exception e) {
			close = false;
		}
		return close;
	}
	
	public static boolean closeLoose( ResultSet rs ) {
		boolean close = true;
		try {
			rs.close();
		} catch (Exception e) {
			close = false;
		}
		return close;
	}	
	
	public static boolean closeLoose( Statement stm ) {
		boolean close = true;
		try {
			stm.close();
		} catch (Exception e) {
			close = false;
		}
		return close;
	}		
	
}

package org.fugerit.java.core.db.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.fugerit.java.core.db.connect.ConnectionFactory;
import org.fugerit.java.core.db.dao.DAOException;

/*
 * 
 *
 * @author mfranci
 *
 */
public class ExecFacade {

	public static int executeUpdate( ConnectionFactory cf, String sql ) throws DAOException {
		int result = 0;
		Connection conn = cf.getConnection();
		System.out.println( "CONN "+conn );
		try {
			Statement stm = conn.createStatement();
			result = stm.executeUpdate( sql );
			stm.close();
		} catch (SQLException e) {
			throw ( new DAOException( e ) );
		} finally {
			SqlUtils.closeLoose( conn );
		}
		return result;
	}	
	
	public static boolean execute( ConnectionFactory cf, String sql ) throws DAOException {
		boolean result = false;
		Connection conn = cf.getConnection();
		try {
			Statement stm = conn.createStatement();
			result = stm.execute( sql );
			stm.close();
		} catch (SQLException e) {
			throw ( new DAOException( e ) );
		} finally {
			SqlUtils.closeLoose( conn );
		}
		return result;
	}
	
}

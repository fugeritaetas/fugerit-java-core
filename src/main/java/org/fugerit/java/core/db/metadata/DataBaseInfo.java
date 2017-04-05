package org.fugerit.java.core.db.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.fugerit.java.core.db.connect.ConnectionFactory;
import org.fugerit.java.core.db.dao.DAOException;

/*
 * 
 *
 * @author mfranci
 *
 */
public class DataBaseInfo {

	public void init( ConnectionFactory cf ) throws DAOException {
		Connection conn = cf.getConnection();
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			this.setDatabaseProductName( dbmd.getDatabaseProductName() );
			this.setDatabaseProductVersion( dbmd.getDatabaseProductVersion() );
			this.setDriverName( dbmd.getDriverName() );
			this.setDriverVersion( dbmd.getDriverVersion() );				
		} catch (SQLException e) {
			throw ( new DAOException( e ) );
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String databaseProductName;
	
	private String databaseProductVersion;
	
	private String driverName;
	
	private String driverVersion;

	/*
	 * @return the databaseProductName
	 */
	public String getDatabaseProductName() {
		return databaseProductName;
	}

	/*
	 * @param databaseProductName the databaseProductName to set
	 */
	public void setDatabaseProductName(String databaseProductName) {
		this.databaseProductName = databaseProductName;
	}

	/*
	 * @return the databaseProductVersion
	 */
	public String getDatabaseProductVersion() {
		return databaseProductVersion;
	}

	/*
	 * @param databaseProductVersion the databaseProductVersion to set
	 */
	public void setDatabaseProductVersion(String databaseProductVersion) {
		this.databaseProductVersion = databaseProductVersion;
	}

	/*
	 * @return the driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/*
	 * @param driverName the driverName to set
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/*
	 * @return the driverVersion
	 */
	public String getDriverVersion() {
		return driverVersion;
	}

	/*
	 * @param driverVersion the driverVersion to set
	 */
	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}
	
}

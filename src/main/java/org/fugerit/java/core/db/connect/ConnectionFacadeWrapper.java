package org.fugerit.java.core.db.connect;

import java.sql.Connection;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.metadata.DataBaseInfo;

/*
 * 
 *
 * @author Morozko
 *
 */
public class ConnectionFacadeWrapper implements ConnectionFactory {

	private ConnectionFactory wrapperConnectionFactory;
	
	public ConnectionFacadeWrapper( ConnectionFactory wrapperConnectionFactory ) {
		this.wrapperConnectionFactory = wrapperConnectionFactory;
	}
	
	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.connect.ConnectionFactoryImpl#getDataBaseInfo()
	 */
	public DataBaseInfo getDataBaseInfo() throws DAOException {
		return this.getWrapperConnectionFactory().getDataBaseInfo();
	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.connect.ConnectionFactoryImpl#release()
	 */
	public void release() throws DAOException {
		this.getWrapperConnectionFactory().release();
	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.connect.ConnectionFactoryImpl#getConnection()
	 */
	public Connection getConnection() throws DAOException {
		return this.getWrapperConnectionFactory().getConnection();
	}

	/*
	 * @return the wrapperConnectionFactory
	 */
	public ConnectionFactory getWrapperConnectionFactory() {
		return wrapperConnectionFactory;
	}

}

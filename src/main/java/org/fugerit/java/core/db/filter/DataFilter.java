package org.fugerit.java.core.db.filter;

import org.fugerit.java.core.db.connect.ConnectionFactory;
import org.fugerit.java.core.db.dao.DAOException;

/*
 * 
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 *
 */
public interface DataFilter {

	public void applyFilter( ConnectionFactory cf, String table, String[] columnsName, String[] columnsKeyName ) throws DAOException;

}

package org.fugerit.java.core.db.connect;

import java.sql.Connection;

import org.fugerit.java.core.db.dao.DAOException;
import org.fugerit.java.core.db.metadata.DataBaseInfo;

/*
 * <p>Una implementazione di ConnectionFactory fornisce un metodo semplice
 * per accedere a delle Connessioni verso una specifica sorgente dati jdbc.</p>
 * 
 * @author Matteo a.k.a. Fugerit
 */
public interface ConnectionFactory {
	
	/*
	 * Restituisce una serie di informazioni convernenti il database.
	 * 
	 * @return le info sul db
	 * @throws DAOException	if any problem happens
	 */
	public DataBaseInfo getDataBaseInfo() throws DAOException;
	
	/*
	 * <p>Metodo che rilascia la ConnectionFactory ed ogni risorsa
	 * eventualmente impeganta da essa.</p>
	 * 
	 * @throws DAOException	if any problem happens
	 */
	public void release() throws DAOException;
	
	/*
	 * <p>Metodo che restituisce una java.sql.Connection secondo
	 * le regole definite per questa ConnectionFactory.</p>
	 * 
	 * @return	the connection
	 * @throws DAOException	if any problem happens
	 */
	public Connection getConnection() throws DAOException;
	
}

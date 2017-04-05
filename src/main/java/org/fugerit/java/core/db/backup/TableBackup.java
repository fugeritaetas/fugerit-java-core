package org.fugerit.java.core.db.backup;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * <p>Permette il backup di una tabella da un DATABASE ad 
 * un altro DATABASE.</p>
 * 
 * <p>La tabella deve esistere in entrambi i database ed
 * essere formata dagli stessi campi, inoltre devono
 * essere rispettati eventuali vincoli di integrità
 * su altre tabelle.</p>
 * 
 * @author Matteo a.k.a. Fugerit (d@fugerit.org)
 */
public interface TableBackup {

	/*
	 * Proprietà  che indica ogni quante righe va eseguito il commit dei dati.
	 */
	public static final String PROP_COMMIT_ON = "commit-on";
	
	public static final String PROP_COLUMN_CHECK_MODE = "column-check-mode";
	
	public static final String PROP_COLUMN_CHECK_MODE_VALUE_NOCHECK = "no-check";
	
	public static final String PROP_COLUMN_CHECK_MODE_VALUE_COMPLETE = "complete";
	
	public static final String PROP_ADAPTOR_FROM = "adaptor-from";
	
	public static final String PROP_ADAPTOR_TO = "adaptor-to";
	
	public static final String PROP_ADAPTOR_VALUE_DEFAULT = "org.fugerit.java.core.db.backup.DefaultBackupAdaptor";
	
	
	public static final String PROP_STATEMENT_MODE = "statement-mode";
	public static final String PROP_STATEMENT_MODE_BATCH = "batch";
	public static final String PROP_STATEMENT_MODE_EXECUTE = "execute";
	public static final String PROP_STATEMENT_MODE_SINGLE = "single";
	
	/*
	 * Proprietà che governa la modalità di inserimento tra la tabella destinazione e quella di origine.
	 */
	public static final String PROP_INSERT_MODE = "insert-mode";
	
	/*
	 * Modalità di inserimento che prevede l'inserimento solo se la tabella di origine e di destinazione
	 * hanno esattamente gli stessi campi.
	 */		
	public static final String PROP_INSERT_MODE_VALUE_STRICT = "strict";
	
	/*
	 * Modalità di inserimento che prevede l'inserimento nella tabella destinazione, di tutti i campi presenti
	 * nella tabella di origine (LEFT).
	 */		
	public static final String PROP_INSERT_MODE_VALUE_LEFT = "left";
	
	/*
	 * Modalità di inserimento che prevede l'inserimento nella tabella destinazione, di tutti i campi presenti
	 * nella tabella di destinazione stessa (RIGHT).
	 */	
	public static final String PROP_INSERT_MODE_VALUE_RIGHT = "right";
	
	/*
	 * Modalità di inserimento che prevede l'inserimento nella tabella destinazione, dei soli campi
	 * esistenti sia nella tabella di destinazione che in quella di origine.
	 */
	public static final String PROP_INSERT_MODE_VALUE_LOOSE = "loose";
	
	public boolean setProperty( String name, String value );
	
    /*
     * <p>Fa il backup di una tabella da un db ad un altro db.</p>
     * 
     * @param table     la tabella di cui fare il backup
     * @param from      una connessione valida col db sorgente
     * @param to        una connessione valida col db destinazione
     * @param tableConfig        L'oggetto di configurazione della tabella
     * @return          <code>0</code> se tutto à andato correttamente,
     *                  o un <code>int</code> rappresentante il numero di
     *                  record non inseriti correttamente
     * @throws SQLException     se si verifica qualche errore fatale
     *                          che non permette neanche di iniziare
     *                          il backup dei dati
     */    
    public int backupTable(String table, Connection from, Connection to, TableConfig tableConfig ) throws SQLException; 
    
    /*
     * <p>Fa il backup di una tabella da un db ad un altro db.</p>
     * 
     * @param table     la tabella di cui fare il backup
     * @param from      una connessione valida col db sorgente
     * @param to        una connessione valida col db destinazione
     * @param select    la query da usare per estrarre i dati (puà eventualmente 
     *                  essere usata per filtrare il risultato).
		@param tableConfig        L'oggetto di configurazione della tabella                   
     * @return          <code>0</code> se tutto à andato correttamente,
     *                  o un <code>int</code> rappresentante il numero di
     *                  record non inseriti correttamente
     * @throws SQLException     se si verifica qualche errore fatale
     *                          che non permette neanche di iniziare
     *                          il backup dei dati
     */
    public int backupTable(String table, Connection from, Connection to, String select, TableConfig tableConfig ) throws SQLException ;
    
    

}

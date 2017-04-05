package org.fugerit.java.core.db.dao.idgen;

/*
 * 
 *
 * @author mfranci
 *
 */
public class PostgresqlSeqIdGenerator extends BasicSeqIdGenerator {

	public static String createSequenceQuery( String seqName) {
		return " SELECT nextval('"+seqName+"'); ";
	}
	
	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.dao.idgen.BasicSeqIdGenerator#createSequenceQuery()
	 */
	protected String createSequenceQuery() {
		return createSequenceQuery( this.getSequenceName() ); 
	}

}

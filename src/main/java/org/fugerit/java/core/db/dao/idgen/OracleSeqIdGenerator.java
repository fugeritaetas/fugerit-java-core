package org.fugerit.java.core.db.dao.idgen;

/*
 * 
 *
 * @author mfranci
 *
 */
public class OracleSeqIdGenerator extends BasicSeqIdGenerator {

	public static String createSequenceQuery( String seqName) {
		return " SELECT "+seqName+".NEXTVAL FROM DUAL ";
	}
	
	/* (non-Javadoc)
	 * @see org.fugerit.java.core.db.dao.idgen.BasicSeqIdGenerator#createSequenceQuery()
	 */
	protected String createSequenceQuery() {
		return createSequenceQuery( this.getSequenceName() ); 
	}

}

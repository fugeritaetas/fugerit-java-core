package org.fugerit.java.core.db.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * <p>.</p>
 *
 * @author tux2
 */
public abstract class Field {
    
    public abstract void setField(PreparedStatement ps, int index) throws SQLException;

}


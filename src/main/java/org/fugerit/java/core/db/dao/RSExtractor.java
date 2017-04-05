package org.fugerit.java.core.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * <p>.</p>
 *
 * @author tux2
 */
public interface RSExtractor {

    public Object extractNext(ResultSet rs) throws SQLException;
    
}

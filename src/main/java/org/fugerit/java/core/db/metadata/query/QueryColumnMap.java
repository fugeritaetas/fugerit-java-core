package org.fugerit.java.core.db.metadata.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 
 *
 * @author mfranci
 *
 */
public class QueryColumnMap {

	private List<QueryColumnModel> list = new ArrayList<QueryColumnModel>();
	
	private Map<String, QueryColumnModel> map = new HashMap<String, QueryColumnModel>();
	
	public int size() {
		return this.list.size();
	}
	
	public void add( QueryColumnModel model ) {
		list.add( model );
		map.put( model.getName().toLowerCase(), model );
	}
	
	public Iterator<QueryColumnModel> iterator() {
		return this.list.iterator();
	}
	
	public QueryColumnModel get( String name ) {
		return (QueryColumnModel)this.map.get( name.toLowerCase() );
	}
	
}

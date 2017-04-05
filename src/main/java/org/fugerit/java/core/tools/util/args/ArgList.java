package org.fugerit.java.core.tools.util.args;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public class ArgList extends ArrayList<Arg> {

	public String[] toArgs() {
		List<String> list = new ArrayList<String>();
		for ( int k=0; k<this.size(); k++ ) {
			Arg arg = (Arg)this.get( k );
			list.add( "-"+arg.getName() );
			if ( arg.isSingleArg() ) {
				list.add( arg.getValue() );
			} else if ( arg.isMultiArg() ) {
				for ( int i=0; i<arg.getValueCount(); i++ ) {
					list.add( arg.getValueAt( i ) );
				}
			}
		}
		String[] result = new String[ list.size() ];
		for ( int k=0; k<result.length; k++ ) {
			result[k] = (String)list.get( k );
		}
		return result;
	}
	
	/*
	 * 
	 */
	private static final long serialVersionUID = -1485325580209630344L;

	/*
     * <p>Crea un nuovo ArgList</p>
     * 
     * 
     */
    public ArgList() {
        super(); 
    }
    

    public Arg findArg(Arg defValue) {
        return this.findArg(defValue.getName(), defValue);
    }
    
    public Arg findArg(String name) {
        return this.findArg(name, null);
    }
    
    public String findArgValue( String name ) {
    	String result = null;
    	Arg arg = this.findArg( name );
    	if ( arg != null ) {
    		result = arg.getValue();
    	}
    	return result;
    }
    public String findArgValue(String name, String defValue) {
        String result = findArgValue( name );
        if ( result == null ) {
        	result = defValue;
        }
        return result;
    }
    
    
    public Arg findArg(String name, Arg defValue) {
        Arg result = defValue;
        for (int k=0; k<this.size() && result==defValue; k++) {
            Arg current = (Arg)this.get(k);
            if (current.getName().equals( name )) {
                result = current;
            }
        }
        return result;
    }
    
    public boolean containsArg(String name) {
        return (this.findArg(name)!=null);
    }

	public void printArgs( PrintStream stream ) {
		for ( int k=0; k<this.size(); k++ ) {
			Arg arg = (Arg)this.get( k );
			stream.println( arg.getName()+" - "+arg.getValue() );
		}
	}
    
}

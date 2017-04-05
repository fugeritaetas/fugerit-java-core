package org.fugerit.java.core.util.filter;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public class DefaultFilter implements ObjectFilter {

    public static final ObjectFilter DENY_ALL = new DefaultFilter(false);
    
    public static final ObjectFilter ACCEPT_ALL = new DefaultFilter(true);
    
    private boolean accept;
    
    public DefaultFilter() {
        this(true);
    }
    
    /*
     * <p>Crea un nuovo DefaultFilter</p>
     * 
     * 
     */
    public DefaultFilter(boolean accept) {
        super();
        this.accept = accept;
    }

    /* (non-Javadoc)
     * @see org.fugerit.java.core.util.filter.ObjectFilter#accept(java.lang.Object)
     */
    public boolean accept(Object item) {
        return this.accept;
    }

}

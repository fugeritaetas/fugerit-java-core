package org.fugerit.java.core.lang.helpers;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public interface Op {

    public boolean doOp() throws Exception;
    
    public boolean doOpSecure();
    
    public boolean undoOp() throws Exception;
    
    public boolean undoOpSecure() throws Exception;
    
}

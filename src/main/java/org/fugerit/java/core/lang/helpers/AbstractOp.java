package org.fugerit.java.core.lang.helpers;

import org.fugerit.java.core.log.BasicLogObject;

/*
 * 
 * 
 * @author  Matteo Franci a.k.a. Fugerit
 */
public abstract class AbstractOp extends BasicLogObject implements Op {

    private ExHandler handler;
    
    public AbstractOp() {
        this(MuteExHandler.MUTE_HANDLER);
    }
    
    /*
     * <p>Crea un nuovo AbstractOp</p>
     * 
     * 
     */
    public AbstractOp(ExHandler handler) {
        super();
        this.handler = handler;
    }

    /* (non-Javadoc)
     * @see org.fugerit.java.core.lang.Op#doOp()
     */
    public abstract boolean doOp() throws Exception;

    /* (non-Javadoc)
     * @see org.fugerit.java.core.lang.Op#doOpSecure()
     */
    public boolean doOpSecure() {
        boolean result = false;
        try {
            result = this.doOp();
        } catch (Exception e) {
            this.handler.error(e);
        }
        return result;
    }

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.lang.Op#undoOp()
	 */
	public boolean undoOp() throws Exception {
		if ( true ) {
			throw ( new Exception( "Unimplemented Method" ) );
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.fugerit.java.core.lang.Op#undoOpSecure()
	 */
	public boolean undoOpSecure() throws Exception {
        boolean result = false;
        try {
            result = this.undoOp();
        } catch (Exception e) {
            this.handler.error(e);
        }
		return result;
	}

}

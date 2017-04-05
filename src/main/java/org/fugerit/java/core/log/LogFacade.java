package org.fugerit.java.core.log;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * <p>.</p>
 *
 * @author Matteo Franci a.k.a. TUX2
 *
 */
public class LogFacade {

    private static Logger logger = LoggerFactory.getLogger( LogFacade.class ); 
    
    public static Logger getLog() {
    	return logger;
    }

    public static Logger newLogger( Object c ) {
    	return LoggerFactory.getLogger( c.getClass() );
    }
    
    public static void handleWarn( Throwable t ) {
    	handleWarn( getLog(), t );
    }
    
    public static void handleWarn( Logger logger, Throwable t ) {
    	logger.warn( t.getMessage(), t );
    }
    
    public static void handleError( Throwable t ) {
    	handleError( getLog(), t );
    }
    
    public static void handleError( Logger logger, Throwable t ) {
    	logger.error( t.getMessage(), t );
    }
    
}


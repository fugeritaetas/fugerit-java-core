package org.fugerit.java.core.web.servlet.filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public abstract class ServletContextFilter extends HttpFilter {

	private ServletContext context;
	
	/*
	 * <p>Restituisce il valore di context.</p>
	 *
	 * @return il valore di context.
	 */
	public ServletContext getContext() {
		return context;
	}

	/*
	 * <p>Imposta il valore di context.</p>
	 *
	 * @param context il valore da impostare.
	 */
	public void setContext(ServletContext context) {
		this.context = context;
	}

	public void init(FilterConfig config) throws ServletException {
		this.setContext( config.getServletContext() );
	}

	public void destroy() {
		this.setContext( null );
	}

}

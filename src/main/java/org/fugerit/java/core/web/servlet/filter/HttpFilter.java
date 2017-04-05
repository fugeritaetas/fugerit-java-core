package org.fugerit.java.core.web.servlet.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fugerit.java.core.web.log.helpers.LogObjectFilter;

public abstract class HttpFilter extends LogObjectFilter {

	public abstract void init(FilterConfig config) throws ServletException;

	public abstract void doFilter( HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if ( request instanceof HttpServletRequest && response instanceof HttpServletResponse ) {
			this.getLogger().debug( "Http request and response : doFilter http" );
			this.doFilter( (HttpServletRequest)request, (HttpServletResponse)response, chain );
		} else {
			this.getLogger().debug( "Not http request and response : proceeding with chain" );
			chain.doFilter( request, response );
		}
	}

	public abstract void destroy();

}

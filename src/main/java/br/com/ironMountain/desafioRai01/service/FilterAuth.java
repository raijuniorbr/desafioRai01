package br.com.ironMountain.desafioRai01.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ironMountain.desafioRai01.model.IronUser;

/**
 * Servlet Filter implementation class FilterAuth
 */

/*
 * para todas as URLs do projeto
 */
@WebFilter("/*")
public class FilterAuth implements Filter {
	
	/*
	 * Injeção de Dependência para Usário
	 * --> Traz a informação da memória ...
	 */
	@Inject
	private IronUser ironUser;

    /**
     * Default constructor. 
     */
    public FilterAuth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;

		if (!ironUser.isLogado() 
				&& !req.getRequestURI().endsWith("/Login.xhtml") 
				&& !req.getRequestURI().contains("/javax.faces.resource/")) {
			
            res.sendRedirect(req.getContextPath() + "/Login.xhtml"); 
            
        } else {
			// pass the request along the filter chain
	    		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

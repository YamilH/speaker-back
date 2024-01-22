package ar.com.speaker.filters;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"})
public class CorsFilter implements Filter {
	
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		List<String> origenesPermitidos = List.of("http://localhost:5500","http://127.0.0.1:5500","http://localhost:5501","http://127.0.0.1:5501");
		
		String origin = ((HttpServletRequest)request).getHeader("origin");
		
	    if (origin != null && origenesPermitidos.contains(origin)) {
	        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", origin);
	        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
	    }
		
		chain.doFilter(request, response);
	}
}

package fr.imie.productmanager.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class AuthenticateFilter extends HttpFilter{
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		
		System.out.println("Username in session in filter : " + session.getAttribute("username"));

		
		if(session.getAttribute("username") != null) {
		
			chain.doFilter(req, res);
		
		}else {
			
			res.sendRedirect("login");
			
		}
			
		
	}
	
	public void destroy() {}

}

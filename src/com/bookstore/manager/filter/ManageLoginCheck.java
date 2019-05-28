package com.bookstore.manager.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManageLoginCheck extends HttpServlet implements Filter {
	
	
	
	    public void init(FilterConfig config)throws ServletException{
			
		}
	 
	  
	    
	  
	    public void doFilter(ServletRequest arg0, ServletResponse arg1,
				FilterChain arg2) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)arg0;
			HttpServletResponse response = (HttpServletResponse)arg1;
			HttpSession session = request.getSession();
			
			if(session.getAttribute("manager")!=null){
				arg2.doFilter(arg0, arg1);
			}else{
				String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
				response.sendRedirect(path + "/manager/login.jsp");
			}
		}

	 
	  
	    public void destroy() {        
	        
	    }

}

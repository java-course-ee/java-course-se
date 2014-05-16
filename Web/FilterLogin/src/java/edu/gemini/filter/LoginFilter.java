package edu.gemini.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

        HttpServletRequest hr = (HttpServletRequest)request;
	try {
            System.out.println("LOGIN_FILTER");
            if(hr.getSession().getAttribute(LoginServlet.ACCESSED)!=null) {
                System.out.println("LOGIN_FILTER CHAIN");
                chain.doFilter(request, response);
            } else {
                System.out.println("LOGIN_FILTER TO LOGIN");
                hr.getRequestDispatcher("/login.jsp").forward(request, response);
            }
	}
	catch(Throwable t) {
	    t.printStackTrace();
	}

    }
    
    public void destroy() { 
    }

    public void init(FilterConfig filterConfig) { 
    }

}

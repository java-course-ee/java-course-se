package edu.gemini.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class Filter1 implements Filter {

    public Filter1() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            if(request.getParameter("check")!=null) {
                //request.getRequestDispatcher("index.jsp").forward(request, response);
                ((HttpServletResponse)response).sendRedirect("index.jsp");
            }

            response.getWriter().append("<h4>Filter1 before<h4>");
            chain.doFilter(request, response);
            response.getWriter().append("<h4>Filter1 after<h4>");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}

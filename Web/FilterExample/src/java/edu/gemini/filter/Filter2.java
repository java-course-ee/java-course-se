package edu.gemini.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter {

    public Filter2() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            response.getWriter().append("<h4>Filter2 before<h4>");
            chain.doFilter(request, response);
            response.getWriter().append("<h4>Filter2 after<h4>");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}

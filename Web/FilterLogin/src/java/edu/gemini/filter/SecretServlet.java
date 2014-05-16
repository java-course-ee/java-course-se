package edu.gemini.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecretServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("SECRET_SERVLET");

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Secret Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Secret Page is available for registered user</h1>");
            out.println("<h4>Hello, " + request.getSession().getAttribute(LoginServlet.ACCESSED)+ " </h4>");
            out.println("<a href='index.jsp'>Go to main page</a>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}

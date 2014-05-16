package edu.gemini.session;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASaburov
 */
public class GetInfo2 extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Получаем параметр из сессии и покажем его на экране
        // Т.к. в сессии храняться Object - приводим к нужному типу
        String param = (String)request.getSession(true).getAttribute(GetInfo1.PARAMETER_SESSION);

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetInfo2</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetInfo2. Parameter:" + param + "</h1>");
            out.println("<a href='index.jsp'>Go home</a>");
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
}

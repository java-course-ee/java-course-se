package edu.gemini.servlet;

import edu.gemini.model.ModelClass;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

    private static final String CLASS_REQUEST = "classRequest";
    private static final String CLASS_SESSION = "classSession";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Поместим параметр в объект request
        ModelClass mc1 = new ModelClass("Петр", "Лихачев");
        request.setAttribute(CLASS_REQUEST, mc1);
        // Поместим параметр в объект request
        ModelClass mc2 = new ModelClass("Михаил", "Андреев");
        request.getSession(true).setAttribute(CLASS_SESSION, mc2);

        // Переходим на страницу через forward
        getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
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

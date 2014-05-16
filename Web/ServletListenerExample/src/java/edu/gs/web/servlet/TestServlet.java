package edu.gs.web.servlet;

import edu.gs.web.listener.ListenerHttpSessionBinding;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Здесь мы увидим реакцию ListenerContextAttribute
        getServletContext().setAttribute("TestContext", "Context1");
        getServletContext().setAttribute("TestContext", "Context2");
        getServletContext().removeAttribute("TestContext");

        // Здесь мы увидим реакцию ListenerHttpSession
        HttpSession session = request.getSession();

        // Здесь мы увидим реакцию ListenerHttpSessionAttribute
        session.setAttribute("TestContextSession", "Session1");
        session.setAttribute("TestContextSession", "Session2");
        session.removeAttribute("TestContextSession");

        // Здесь мы увидим реакцию ListenerHttpSessionAttribute - ЗДЕСЬ ошибка, надо найти проблему
        request.setAttribute("TestContextRequest", "Request1");
        request.setAttribute("TestContextRequest", "Request2");
        request.removeAttribute("TestContextRequest");
        
        // Здесь мы увидим реакцию ListenerHttpSessionBinding
        ListenerHttpSessionBinding test = new ListenerHttpSessionBinding();
        session.setAttribute("Binding", test);
        session.removeAttribute("Binding");
        
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

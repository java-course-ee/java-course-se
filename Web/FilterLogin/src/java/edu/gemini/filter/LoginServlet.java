package edu.gemini.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    public static final String ACCESSED = "ACCESSED";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("LOGIN_SERVLET");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Здесь мы можем проверить правильно ли ввели данные пустить на секретную страницу или нет.

        // Также мы запоминаем в сессии, что пользователь пполучил разрешение
        // и в качестве параметра передаем его логин
        if(login!=null && !login.isEmpty()) {
            // Считаем что пользователь проел проверку
            request.getSession().setAttribute(ACCESSED, login);
            getServletContext().getRequestDispatcher("/Secret").forward(request, response);
        } else {
            // Считаем, что пользователь сбросил свои данные
            request.getSession().removeAttribute(ACCESSED);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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

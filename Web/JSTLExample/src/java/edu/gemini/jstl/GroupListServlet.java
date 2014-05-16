package edu.gemini.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GroupListServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Получаем список групп и помещаем его в объект request
        GroupSystem gs = new GroupSystem();
        List<String> head = new ArrayList<String>();
        head.add("ID");
        head.add("Наименование");
        head.add("Куратор");
        head.add("Специальность");
        request.setAttribute("headList", head);

        List<Group> gl = gs.findGroup();
        request.setAttribute("groupList", gl);

        getServletContext().getRequestDispatcher("/groupList.jsp").forward(request, response);
        // Другое отображение вызывается простой заменой JSP
        //getServletContext().getRequestDispatcher("/groupList2.jsp").forward(request, response);
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

package check;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Пример выводит список всех загловков, который пришли от клиента
 * 
 * @author ASaburov
 */
public class ClickMe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();

        pw.println("<table border='1'>");
        pw.println("<tr>");
        pw.println("<th>Name</th><th>Value</th>");
        pw.println("</tr>");
        for (Enumeration en = request.getHeaderNames(); en.hasMoreElements();) {
            String name = (String) en.nextElement();
            String header = request.getHeader(name);

            pw.println("<tr>");
            pw.println("<td>" + name + "</td><td>" + header + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table>");
        
        pw.close();
    }
}

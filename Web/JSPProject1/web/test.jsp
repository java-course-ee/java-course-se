<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.gemini.model.ModelClass"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <h1>Test data</h1>

        <!-- Вариант заполнения через EL -->
        <p><strong>Использование EL</strong></p>
        <p>
            ${classRequest.firstName} ${classRequest.lastName}
        </p>
        <p>
            ${classSession.firstName} ${classSession.lastName}
        </p>
        <hr/>


        <!-- 
        Вариант заполнения через скриптлеты.
        Здесь необходимо обратить внимание на наличие стандратных объектов
        request, session, out
        -->
        <p><strong>Использование скриптлетов</strong></p>
        <p>
            <%
            ModelClass mc1 = (ModelClass)request.getAttribute("classRequest");
            out.println(mc1.getFirstName() + " " + mc1.getLastName());
            %>
        </p>
        <p>
            <%
            ModelClass mc2 = (ModelClass)session.getAttribute("classSession");
            out.println(mc2.getFirstName() + " " + mc2.getLastName());
            %>
        </p>

    </body>
</html>

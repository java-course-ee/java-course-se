<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>
            <%-- Обратите внимание на обращение к полному пути до приложения --%>
            <a href="${pageContext.servletContext.contextPath}/login.jsp">Login</a>
            <br/>

            <%-- Обратите внимание на обращение к полному пути до приложения --%>
            <a href="${pageContext.servletContext.contextPath}/Secret">Secret Page</a>
            <br/>

            <%-- Обратите внимание на обращение к полному пути до приложения --%>
            <a href="${pageContext.servletContext.contextPath}/secretFolder/secret.jsp">Secret Page JSP</a>
        </h4>
    </body>
</html>

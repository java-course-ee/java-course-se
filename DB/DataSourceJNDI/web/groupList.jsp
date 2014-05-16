<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.gemini.jndi.Group"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>

        <table border="1">
            <%
                List<Group> groups = (List) request.getAttribute("groupList");
                for (Group g : groups) {
            %>
            <tr>
                <td><%=g.getGroupId()%></td>
                <td><%=g.getGroupName()%></td>
                <td><%=g.getSpeciality()%></td>
            </tr>
            <% }%>
        </table>

    </body>
</html>

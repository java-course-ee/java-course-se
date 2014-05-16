<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>

        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <c:forEach var="head" items="${headList}">
                        <th>${head}</th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="group" items="${groupList}" varStatus="status">

                    <c:if test="${status.count%2==1}">
                      <tr style="background-color: yellow;">
                    </c:if>
                    <c:if test="${status.count%2!=1}">
                      <tr style="background-color: white;">
                    </c:if>

                        <td>${status.count}</td>
                        <td>${group.groupId}</td>
                        <td>${group.groupName}</td>
                        <td>${group.curator}</td>
                        <td>${group.speciality}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>

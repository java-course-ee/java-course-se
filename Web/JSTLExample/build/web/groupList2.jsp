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
        <%-- Пример задания переменной --%>
        <c:set var="title" value="The best title in the world"/>
        <%-- Пример использования переменной --%>
        <h3>${title}</h3>
        
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

                    <%-- Иллюстрация создания ссылки с параметрами --%>
                    <c:url var="groupUrl" value="GoTo">
                        <c:param name="groupId" value="${group.groupId}"/>
                        <c:param name="orderName" value="${group.groupName}"/>
                    </c:url>

                    <%--
                    Другой вариант вызова условия - через when.
                    Число пунктов when может быть больше одного
                    --%>
                    <c:choose>
                          <c:when test="${status.count%2==1}">
                             <tr style="background-color: green;">
                          </c:when>
                          <c:otherwise>
                             <tr style="background-color: yellow;">
                          </c:otherwise>
                      </c:choose>

                        <td>${status.count}</td>
                        <%-- Иллюстрация использования ссылки с параметрами --%>
                        <td><a href="${groupUrl}">${group.groupId}</a></td>
                        <td>${group.groupName}</td>
                        <td>${group.curator}</td>
                        <td>${group.speciality}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-30
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>name, age</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String age = request.getParameter("age");
%>

<c:set var="name" value="<%= name %>" />
<c:set var="age" value="<%= age %>" />

<c:choose>
    <c:when test="${name == null || name == ''}">
        이름이 없으면 로그인 하세요.
    </c:when>
    <c:otherwise>
        당신의 이름은 ${name}이고, 나이는 ${age}세 입니다.
    </c:otherwise>
</c:choose>
</body>
</html>

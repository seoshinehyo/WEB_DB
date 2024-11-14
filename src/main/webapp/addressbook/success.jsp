<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-13
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>성공 페이지</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${param.action == 'add'}">
        <c:set var="act" value="Added"></c:set>
        <h3>Data ${act}</h3>
        <hr>
        ${param.name}<br>
        <c:out value="${param.email}"/><br>
        ${param.addr}<br>
        ${param.tel}<br>
        <hr>
    </c:when>

    <c:when test="${param.action == 'del'}">
        <c:set var="act" value="Deleted"></c:set>
        <h3>Data ${act}</h3>
        <hr>
        ${param.name}
        <hr>
    </c:when>
</c:choose>


</body>
</html>


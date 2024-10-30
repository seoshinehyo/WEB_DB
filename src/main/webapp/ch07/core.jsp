<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-30
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% int a=5; %>
======================================<br>
<% out.print("a = " + a); %><br>
======================================<br><br>

<c:set var="a" value="5"/>
======================================<br>
a = ${a}<br>
======================================<br><br>

<c:set var="num" value="3"></c:set>
<c:if test="${num>0}">
  positive
</c:if><br>
======================================<br><br>

<c:choose>
  <c:when test="${num>0}">
    P
  </c:when>
  <c:otherwise>
    N
  </c:otherwise>
</c:choose><br>
======================================<br><br>

</body>
</html>
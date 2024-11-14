<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-23
  Time: 오전 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>성인여부 출력</title>
</head>
<body>
<jsp:useBean id="adult" class="ssh.jwbook.com.ch07.Adult" scope="request" />
<jsp:setProperty name="adult" property="*" />
<jsp:forward page="adultResult.jsp"/>
<%--<jsp:setProperty name="adult" property="name" value="KIM" />--%>
<%--<jsp:setProperty name="adult" property="age" value="23" />--%>
</body>
</html>

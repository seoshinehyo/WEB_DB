<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-23
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>성인 결과</title>
</head>
<body>
<jsp:useBean id="adult" class="ssh.jwbook.com.ch07.Adult" scope="request" />
이름 : <jsp:getProperty name="adult" property="name"/>
성인 여부 : <jsp:getProperty name="adult" property="adul"/>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-23
  Time: 오전 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>person</title>
</head>
<body>
<jsp:useBean id="per" class="ssh.jwbook.com.ch07.Person" />
<jsp:setProperty name="per" property="id" value="idKim" />
<jsp:setProperty name="per" property="name" value="김다인" />

<%
//    per.setName("김다인");
//    per.setId("kim");
//
//    String name = per.getName();
//    String id = per.getId();

    out.print("이름 : " + per.getName());
    out.print("ID : " + per.getId());

%>
</body>
</html>

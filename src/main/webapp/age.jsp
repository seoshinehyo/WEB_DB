<%@ page import="ssh.jwbook.com.ch07.CalcAge" %><%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-23
  Time: 오전 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>나이 출력</title>
</head>
<body>
    <jsp:useBean id="age" class="ssh.jwbook.com.ch07.CalcAge"/>
    <%
        int year = Integer.parseInt(request.getParameter("date"));
        age.setAge(year);
        out.print("당신의 나이는 " + age.getAge() + "세 입니다.");
    %>
</body>
</html>
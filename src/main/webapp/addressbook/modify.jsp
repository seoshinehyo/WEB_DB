<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-13
  Time: 오전 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주소록 수정 페이지</title>
</head>
<body>
<h3>주소록 수정 폼</h3>
<form action="/addressBook?action=modify" method="post">
    <input type="hidden" name="num" value="${param.num}">
    <label for="name">이름:</label>
    <input type="text" id="name" name="name" value="${param.name}" required><br><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" value="${param.email}" required><br><br>

    <label for="addr">주소:</label>
    <input type="text" id="addr" name="addr" value="${param.addr}" required><br><br>

    <label for="tel">전화번호:</label>
    <input type="text" id="tel" name="tel" value="${param.tel}" required><br><br>

    <input type="submit" value="수정">
</form>
</body>
</html>

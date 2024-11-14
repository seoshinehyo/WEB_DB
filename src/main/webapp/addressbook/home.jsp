<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-13
  Time: 오전 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주소록</title>
</head>
<body>
<a href="/addressBook?action=list">View List</a>
<br><br>

<form action="/addressBook?action=add" method="get">
    <fieldset>
        <legend>주소 추가</legend>
        <label for="name">이름:</label>
        <input type="text" id="name" name="name"><br>
        <label for="email">이메일:</label>
        <input type="text" id="email" name="email"><br>
        <label for="addr">주소:</label>
        <input type="text" id="addr" name="addr"><br>
        <label for="tel">전화번호:</label>
        <input type="text" id="tel" name="tel"><br><br>
        <input type="submit" value="Add">
        <input type="hidden" name="action" value="add">
    </fieldset>
</form>

<br>

<form action="/addressBook?action=del" method="get">
    <fieldset>
        <legend>주소 삭제</legend>
        <label for="del-name">이름:</label>
        <input type="text" id="del-name" name="name"><br><br>
        <input type="submit" value="Delete">
        <input type="hidden" name="action" value="del">
    </fieldset>
</form>

<br>

<form action="/addressBook?action=search" method="get">
    <fieldset>
        <legend>주소 검색</legend>
        <label for="search-name">이름:</label>
        <input type="text" id="search-name" name="name"><br><br>
        <input type="submit" value="Search">
        <input type="hidden" name="action" value="search">
    </fieldset>
</form>
</body>
</html>

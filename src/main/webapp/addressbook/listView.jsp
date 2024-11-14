<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-13
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ssh.jwbook.com.addressbook.AddressBookDto" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>View List</title>
</head>
<body>
<h3>주소록 리스트</h3>
<table border="1" cellspacing="0" cellpadding="5">
    <thead>
    <tr>
        <th>이름</th>
        <th>이메일</th>
        <th>주소</th>
        <th>전화번호</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list_all}" var="ab">
        <tr>
            <td><a href="AddressBookController?action=detail&num=${ab.num}">${ab.name}</a></td>
            <td>${ab.email}</td>
            <td>${ab.addr}</td>
            <td>${ab.tel}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>

<a href="/addressbook/modify.jsp">주소록 수정하기</a>

</body>
</html>

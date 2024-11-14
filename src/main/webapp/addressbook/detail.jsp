<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-13
  Time: 오전 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세 페이지</title>
</head>
<body>
<h3>주소록 상세 정보</h3>
<c:choose>
    <c:when test="${not empty addrbookDTO}">
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>번호</th>
                <td>${addrbookDTO.num}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${addrbookDTO.name}</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>${addrbookDTO.email}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${addrbookDTO.addr}</td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>${addrbookDTO.tel}</td>
            </tr>
        </table>
    </c:when>
</c:choose>

<br>
<a href="/addressBook?action=list">목록으로 돌아가기</a>
</body>
</html>
